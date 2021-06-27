package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTag;

/**
 * 商品标签Service接口
 *
 * @author ruoyi
 * @date 2021-06-26
 */
public interface ISysTagService
{
    /**
     * 查询商品标签
     *
     * @param tagId 商品标签ID
     * @return 商品标签
     */
    public SysTag selectSysTagById(Long tagId);

    /**
     * 查询商品标签列表
     *
     * @param sysTag 商品标签
     * @return 商品标签集合
     */
    public List<SysTag> selectSysTagList(SysTag sysTag);

    /**
     * 新增商品标签
     *
     * @param sysTag 商品标签
     * @return 结果
     */
    public int insertSysTag(SysTag sysTag);

    /**
     * 修改商品标签
     *
     * @param sysTag 商品标签
     * @return 结果
     */
    public int updateSysTag(SysTag sysTag);

    /**
     * 批量删除商品标签
     *
     * @param tagIds 需要删除的商品标签ID
     * @return 结果
     */
    public int deleteSysTagByIds(Long[] tagIds);

    /**
     * 删除商品标签信息
     *
     * @param tagId 商品标签ID
     * @return 结果
     */
    public int deleteSysTagById(Long tagId);
}