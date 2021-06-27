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
import com.ruoyi.system.domain.SysGoodsGallery;
import com.ruoyi.system.service.ISysGoodsGalleryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品图片Controller
 *
 * @author Tippy
 * @date 2021-06-26
 */
@RestController
@RequestMapping("/system/gallery")
public class SysGoodsGalleryController extends BaseController
{
    @Autowired
    private ISysGoodsGalleryService sysGoodsGalleryService;

    /**
     * 查询商品图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:gallery:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysGoodsGallery sysGoodsGallery)
    {
        startPage();
        List<SysGoodsGallery> list = sysGoodsGalleryService.selectSysGoodsGalleryList(sysGoodsGallery);
        return getDataTable(list);
    }

    /**
     * 导出商品图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:gallery:export')")
    @Log(title = "商品图片", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysGoodsGallery sysGoodsGallery)
    {
        List<SysGoodsGallery> list = sysGoodsGalleryService.selectSysGoodsGalleryList(sysGoodsGallery);
        ExcelUtil<SysGoodsGallery> util = new ExcelUtil<SysGoodsGallery>(SysGoodsGallery.class);
        return util.exportExcel(list, "商品图片数据");
    }

    /**
     * 获取商品图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:gallery:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(sysGoodsGalleryService.selectSysGoodsGalleryById(goodsId));
    }

    /**
     * 新增商品图片
     */
    @PreAuthorize("@ss.hasPermi('system:gallery:add')")
    @Log(title = "商品图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysGoodsGallery sysGoodsGallery)
    {
        return toAjax(sysGoodsGalleryService.insertSysGoodsGallery(sysGoodsGallery));
    }

    /**
     * 修改商品图片
     */
    @PreAuthorize("@ss.hasPermi('system:gallery:edit')")
    @Log(title = "商品图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysGoodsGallery sysGoodsGallery)
    {
        return toAjax(sysGoodsGalleryService.updateSysGoodsGallery(sysGoodsGallery));
    }

    /**
     * 删除商品图片
     */
    @PreAuthorize("@ss.hasPermi('system:gallery:remove')")
    @Log(title = "商品图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(sysGoodsGalleryService.deleteSysGoodsGalleryByIds(goodsIds));
    }
}