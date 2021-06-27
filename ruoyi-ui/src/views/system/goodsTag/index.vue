<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品id" prop="goodsId">
        <el-select v-model="queryParams.goodsId" placeholder="请选择商品id" clearable size="small">
          <el-option label="请选择字典生成" value=""/>
        </el-select>
      </el-form-item>
      <el-form-item label="标签id" prop="tagId">
        <el-select v-model="queryParams.tagId" placeholder="请选择标签id" clearable size="small">
          <el-option label="请选择字典生成" value=""/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:goodsTag:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:goodsTag:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:goodsTag:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:goodsTag:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="goodsTagList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="商品id" align="center" prop="goodsId"/>
      <el-table-column label="标签id" align="center" prop="tagId"></el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:goodsTag:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:goodsTag:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改商品标签对应关系对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品Id" prop="goodsId">
          <el-select
            v-model="form.goodsId"
            placeholder="请选择商品id"
            remote
            filterable
            :remote-method="getGoodsList"
            :loading="goodsLoading"
          >
            <el-option
              v-for="g of goodsList"
              :key="g.goodsId"
              :value="g.goodsId"
              :label="g.goodsTitle"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="标签id" prop="tagId">
          <el-select
            v-model="form.tagId"
            placeholder="请选择标签id"
            remote
            filterable
            :remote-method="getTagList"
            :loading="tagLoading"
          >
            <el-option
              v-for="g of tagList"
              :key="g.tagId"
              :value="g.tagId"
              :label="g.tagName"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listGoodsTag,
  getGoodsTag,
  delGoodsTag,
  addGoodsTag,
  updateGoodsTag,
  exportGoodsTag,
  listGoods
} from "@/api/system/goods";
import {listTag} from "@/api/system/tag";

export default {
  name: "GoodsTag",
  components: {},
  data() {
    return {
      goodsLoading: true,
      tagLoading: true,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      goodsList: [],
      tagList: [],
      // 商品标签对应关系表格数据
      goodsTagList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        goodsId: null,
        tagId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        goodsId: [
          {required: true, message: "商品id不能为空", trigger: "change"}
        ],
        tagId: [
          {required: true, message: "标签id不能为空", trigger: "change"}
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商品标签对应关系列表 */
    getList() {
      this.loading = true;
      listGoodsTag(this.queryParams).then(response => {
        this.goodsTagList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getTagList(query) {
      this.tagLoading = true
      if (query !== '') {
        listTag({
          pageNum: 1,
          pageSize: 20,
          tagName: query
        })
          .then(res => {
            this.tagLoading = false;
            this.tagList = res.rows
          })
      } else {
        this.tagList = []
      }
    },
    getGoodsList(query) {
      this.goodsLoading = true
      if (query !== '') {
        listGoods({
          pageNum: 1,
          pageSize: 20,
          goodsTitle: query
        })
          .then(res => {
            this.goodsLoading = false
            this.goodsList = res.rows
          })
      } else {
        this.goodsList = [];
      }
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        goodsId: null,
        tagId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.goodsId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品标签对应关系";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const goodsId = row.goodsId || this.ids
      getGoodsTag(goodsId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品标签对应关系";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.title === "修改商品标签对应关系") {
            updateGoodsTag(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            console.log('add')
            addGoodsTag(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const goodsIds = row.goodsId || this.ids;
      this.$confirm('是否确认删除商品标签对应关系编号为"' + goodsIds + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return delGoodsTag(goodsIds);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有商品标签对应关系数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return exportGoodsTag(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
