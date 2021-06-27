package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysGoods;

/**
 * 商品信息Mapper接口
 *
 * @author Tippy
 * @date 2021-06-26
 */
public interface SysGoodsMapper
{
    /**
     * 查询商品信息
     *
     * @param goodsId 商品信息ID
     * @return 商品信息
     */
    public SysGoods selectSysGoodsById(Long goodsId);

    /**
     * 查询商品信息列表
     *
     * @param sysGoods 商品信息
     * @return 商品信息集合
     */
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods);

    /**
     * 新增商品信息
     *
     * @param sysGoods 商品信息
     * @return 结果
     */
    public int insertSysGoods(SysGoods sysGoods);

    /**
     * 修改商品信息
     *
     * @param sysGoods 商品信息
     * @return 结果
     */
    public int updateSysGoods(SysGoods sysGoods);

    /**
     * 删除商品信息
     *
     * @param goodsId 商品信息ID
     * @return 结果
     */
    public int deleteSysGoodsById(Long goodsId);

    /**
     * 批量删除商品信息
     *
     * @param goodsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysGoodsByIds(Long[] goodsIds);
}