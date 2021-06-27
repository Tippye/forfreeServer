package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTagMapper;
import com.ruoyi.system.domain.SysTag;
import com.ruoyi.system.service.ISysTagService;

/**
 * 商品标签Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-26
 */
@Service
public class SysTagServiceImpl implements ISysTagService
{
    @Autowired
    private SysTagMapper sysTagMapper;

    /**
     * 查询商品标签
     *
     * @param tagId 商品标签ID
     * @return 商品标签
     */
    @Override
    public SysTag selectSysTagById(Long tagId)
    {
        return sysTagMapper.selectSysTagById(tagId);
    }

    /**
     * 查询商品标签列表
     *
     * @param sysTag 商品标签
     * @return 商品标签
     */
    @Override
    public List<SysTag> selectSysTagList(SysTag sysTag)
    {
        return sysTagMapper.selectSysTagList(sysTag);
    }

    /**
     * 新增商品标签
     *
     * @param sysTag 商品标签
     * @return 结果
     */
    @Override
    public int insertSysTag(SysTag sysTag)
    {
        return sysTagMapper.insertSysTag(sysTag);
    }

    /**
     * 修改商品标签
     *
     * @param sysTag 商品标签
     * @return 结果
     */
    @Override
    public int updateSysTag(SysTag sysTag)
    {
        return sysTagMapper.updateSysTag(sysTag);
    }

    /**
     * 批量删除商品标签
     *
     * @param tagIds 需要删除的商品标签ID
     * @return 结果
     */
    @Override
    public int deleteSysTagByIds(Long[] tagIds)
    {
        return sysTagMapper.deleteSysTagByIds(tagIds);
    }

    /**
     * 删除商品标签信息
     *
     * @param tagId 商品标签ID
     * @return 结果
     */
    @Override
    public int deleteSysTagById(Long tagId)
    {
        return sysTagMapper.deleteSysTagById(tagId);
    }
}