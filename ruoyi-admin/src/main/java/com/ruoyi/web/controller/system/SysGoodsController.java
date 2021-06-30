package com.ruoyi.web.controller.system;

import java.util.ArrayList;
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
import com.ruoyi.system.domain.SysGoods;
import com.ruoyi.system.service.ISysGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品信息Controller
 *
 * @author Tippy
 * @date 2021-06-26
 */
@RestController
@RequestMapping("/system/goods")
public class SysGoodsController extends BaseController
{
    @Autowired
    private ISysGoodsService sysGoodsService;

    /**
     * 查询商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysGoods sysGoods)
    {
        startPage();
        List<SysGoods> list = sysGoodsService.selectSysGoodsList(sysGoods);
        return getDataTable(list);
    }

    /**
     * 查询推荐商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:list')")
    @GetMapping("/recommend")
    public TableDataInfo recommend(SysGoods sysGoods) {
        startPage();
        // TODO:推荐商品
        List<SysGoods> list = new ArrayList<SysGoods>();
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysGoods sysGoods)
    {
        List<SysGoods> list = sysGoodsService.selectSysGoodsList(sysGoods);
        ExcelUtil<SysGoods> util = new ExcelUtil<SysGoods>(SysGoods.class);
        return util.exportExcel(list, "商品信息数据");
    }

    /**
     * 获取商品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(sysGoodsService.selectSysGoodsById(goodsId));
    }

    /**
     * 新增商品信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysGoods sysGoods)
    {
        return toAjax(sysGoodsService.insertSysGoods(sysGoods));
    }

    /**
     * 修改商品信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysGoods sysGoods)
    {
        return toAjax(sysGoodsService.updateSysGoods(sysGoods));
    }

    /**
     * 删除商品信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(sysGoodsService.deleteSysGoodsByIds(goodsIds));
    }
}