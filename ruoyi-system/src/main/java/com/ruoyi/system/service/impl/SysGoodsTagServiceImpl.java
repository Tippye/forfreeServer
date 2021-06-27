package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGoodsTagMapper;
import com.ruoyi.system.domain.SysGoodsTag;
import com.ruoyi.system.service.ISysGoodsTagService;

/**
 * 商品标签对应关系Service业务层处理
 *
 * @author Tippy
 * @date 2021-06-27
 */
@Service
public class SysGoodsTagServiceImpl implements ISysGoodsTagService
{
    @Autowired
    private SysGoodsTagMapper sysGoodsTagMapper;

    /**
     * 查询商品标签对应关系
     *
     * @param goodsId 商品标签对应关系ID
     * @return 商品标签对应关系
     */
    @Override
    public SysGoodsTag selectSysGoodsTagById(Long goodsId)
    {
        return sysGoodsTagMapper.selectSysGoodsTagById(goodsId);
    }

    /**
     * 查询商品标签对应关系列表
     *
     * @param sysGoodsTag 商品标签对应关系
     * @return 商品标签对应关系
     */
    @Override
    public List<SysGoodsTag> selectSysGoodsTagList(SysGoodsTag sysGoodsTag)
    {
        return sysGoodsTagMapper.selectSysGoodsTagList(sysGoodsTag);
    }

    /**
     * 新增商品标签对应关系
     *
     * @param sysGoodsTag 商品标签对应关系
     * @return 结果
     */
    @Override
    public int insertSysGoodsTag(SysGoodsTag sysGoodsTag)
    {
        return sysGoodsTagMapper.insertSysGoodsTag(sysGoodsTag);
    }

    /**
     * 修改商品标签对应关系
     *
     * @param sysGoodsTag 商品标签对应关系
     * @return 结果
     */
    @Override
    public int updateSysGoodsTag(SysGoodsTag sysGoodsTag)
    {
        return sysGoodsTagMapper.updateSysGoodsTag(sysGoodsTag);
    }

    /**
     * 批量删除商品标签对应关系
     *
     * @param goodsIds 需要删除的商品标签对应关系ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsTagByIds(Long[] goodsIds)
    {
        return sysGoodsTagMapper.deleteSysGoodsTagByIds(goodsIds);
    }

    /**
     * 删除商品标签对应关系信息
     *
     * @param goodsId 商品标签对应关系ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsTagById(Long goodsId)
    {
        return sysGoodsTagMapper.deleteSysGoodsTagById(goodsId);
    }
}