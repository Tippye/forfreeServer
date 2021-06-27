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
import com.ruoyi.system.domain.SysTag;
import com.ruoyi.system.service.ISysTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品标签Controller
 *
 * @author ruoyi
 * @date 2021-06-26
 */
@RestController
@RequestMapping("/system/tag")
public class SysTagController extends BaseController
{
    @Autowired
    private ISysTagService sysTagService;

    /**
     * 查询商品标签列表
     */
    @PreAuthorize("@ss.hasPermi('system:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTag sysTag)
    {
        startPage();
        List<SysTag> list = sysTagService.selectSysTagList(sysTag);
        return getDataTable(list);
    }

    /**
     * 导出商品标签列表
     */
    @PreAuthorize("@ss.hasPermi('system:tag:export')")
    @Log(title = "商品标签", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysTag sysTag)
    {
        List<SysTag> list = sysTagService.selectSysTagList(sysTag);
        ExcelUtil<SysTag> util = new ExcelUtil<SysTag>(SysTag.class);
        return util.exportExcel(list, "商品标签数据");
    }

    /**
     * 获取商品标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tag:query')")
    @GetMapping(value = "/{tagId}")
    public AjaxResult getInfo(@PathVariable("tagId") Long tagId)
    {
        return AjaxResult.success(sysTagService.selectSysTagById(tagId));
    }

    /**
     * 新增商品标签
     */
    @PreAuthorize("@ss.hasPermi('system:tag:add')")
    @Log(title = "商品标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTag sysTag)
    {
        return toAjax(sysTagService.insertSysTag(sysTag));
    }

    /**
     * 修改商品标签
     */
    @PreAuthorize("@ss.hasPermi('system:tag:edit')")
    @Log(title = "商品标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTag sysTag)
    {
        return toAjax(sysTagService.updateSysTag(sysTag));
    }

    /**
     * 删除商品标签
     */
    @PreAuthorize("@ss.hasPermi('system:tag:remove')")
    @Log(title = "商品标签", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tagIds}")
    public AjaxResult remove(@PathVariable Long[] tagIds)
    {
        return toAjax(sysTagService.deleteSysTagByIds(tagIds));
    }
}