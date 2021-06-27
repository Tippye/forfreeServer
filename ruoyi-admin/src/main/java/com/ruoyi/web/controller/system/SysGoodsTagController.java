package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysGoodsTag;
import com.ruoyi.system.service.ISysGoodsTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品标签对应关系Controller
 *
 * @author Tippy
 * @date 2021-06-27
 */
@RestController
@RequestMapping("/system/goodsTag")
public class SysGoodsTagController extends BaseController
{
    @Autowired
    private ISysGoodsTagService sysGoodsTagService;

    /**
     * 查询商品标签对应关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:goodsTag:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysGoodsTag sysGoodsTag)
    {
        startPage();
        List<SysGoodsTag> list = sysGoodsTagService.selectSysGoodsTagList(sysGoodsTag);
        return getDataTable(list);
    }

    /**
     * 导出商品标签对应关系列表
     */
    @PreAuthorize("@ss.hasPermi('system:goodsTag:export')")
    @Log(title = "商品标签对应关系", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysGoodsTag sysGoodsTag)
    {
        List<SysGoodsTag> list = sysGoodsTagService.selectSysGoodsTagList(sysGoodsTag);
        ExcelUtil<SysGoodsTag> util = new ExcelUtil<SysGoodsTag>(SysGoodsTag.class);
        return util.exportExcel(list, "商品标签对应关系数据");
    }

    /**
     * 获取商品标签对应关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:goodsTag:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(sysGoodsTagService.selectSysGoodsTagById(goodsId));
    }

    /**
     * 新增商品标签对应关系
     */
    @PreAuthorize("@ss.hasPermi('system:goodsTag:add')")
    @Log(title = "商品标签对应关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysGoodsTag sysGoodsTag)
    {
        return toAjax(sysGoodsTagService.insertSysGoodsTag(sysGoodsTag));
    }

    /**
     * 修改商品标签对应关系
     */
    @PreAuthorize("@ss.hasPermi('system:goodsTag:edit')")
    @Log(title = "商品标签对应关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysGoodsTag sysGoodsTag)
    {
        return toAjax(sysGoodsTagService.updateSysGoodsTag(sysGoodsTag));
    }

    /**
     * 删除商品标签对应关系
     */
    @PreAuthorize("@ss.hasPermi('system:goodsTag:remove')")
    @Log(title = "商品标签对应关系", businessType = BusinessType.DELETE)
    @DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(sysGoodsTagService.deleteSysGoodsTagByIds(goodsIds));
    }
}