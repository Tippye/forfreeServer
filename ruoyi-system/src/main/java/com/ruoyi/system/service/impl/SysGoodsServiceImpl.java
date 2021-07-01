package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGoodsMapper;
import com.ruoyi.system.domain.SysGoods;
import com.ruoyi.system.service.ISysGoodsService;

/**
 * 商品信息Service业务层处理
 *
 * @author Tippy
 * @date 2021-06-26
 */
@Service
public class SysGoodsServiceImpl implements ISysGoodsService
{
    @Autowired
    private SysGoodsMapper sysGoodsMapper;

    /**
     * 查询商品信息
     *
     * @param goodsId 商品信息ID
     * @return 商品信息
     */
    @Override
    public SysGoods selectSysGoodsById(Long goodsId)
    {
        System.out.println(goodsId);
        return sysGoodsMapper.selectSysGoodsById(goodsId);
    }

    /**
     * 查询商品信息列表
     *
     * @param sysGoods 商品信息
     * @return 商品信息
     */
    @Override
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods)
    {
        return sysGoodsMapper.selectSysGoodsList(sysGoods);
    }

    /**
     * 新增商品信息
     *
     * @param sysGoods 商品信息
     * @return 结果
     */
    @Override
    public int insertSysGoods(SysGoods sysGoods)
    {
        return sysGoodsMapper.insertSysGoods(sysGoods);
    }

    /**
     * 修改商品信息
     *
     * @param sysGoods 商品信息
     * @return 结果
     */
    @Override
    public int updateSysGoods(SysGoods sysGoods)
    {
        return sysGoodsMapper.updateSysGoods(sysGoods);
    }

    /**
     * 批量删除商品信息
     *
     * @param goodsIds 需要删除的商品信息ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsByIds(Long[] goodsIds)
    {
        return sysGoodsMapper.deleteSysGoodsByIds(goodsIds);
    }

    /**
     * 删除商品信息信息
     *
     * @param goodsId 商品信息ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsById(Long goodsId)
    {
        return sysGoodsMapper.deleteSysGoodsById(goodsId);
    }
}