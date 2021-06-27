package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysGoodsTag;

/**
 * 商品标签对应关系Service接口
 *
 * @author Tippy
 * @date 2021-06-27
 */
public interface ISysGoodsTagService
{
    /**
     * 查询商品标签对应关系
     *
     * @param goodsId 商品标签对应关系ID
     * @return 商品标签对应关系
     */
    public SysGoodsTag selectSysGoodsTagById(Long goodsId);

    /**
     * 查询商品标签对应关系列表
     *
     * @param sysGoodsTag 商品标签对应关系
     * @return 商品标签对应关系集合
     */
    public List<SysGoodsTag> selectSysGoodsTagList(SysGoodsTag sysGoodsTag);

    /**
     * 新增商品标签对应关系
     *
     * @param sysGoodsTag 商品标签对应关系
     * @return 结果
     */
    public int insertSysGoodsTag(SysGoodsTag sysGoodsTag);

    /**
     * 修改商品标签对应关系
     *
     * @param sysGoodsTag 商品标签对应关系
     * @return 结果
     */
    public int updateSysGoodsTag(SysGoodsTag sysGoodsTag);

    /**
     * 批量删除商品标签对应关系
     *
     * @param goodsIds 需要删除的商品标签对应关系ID
     * @return 结果
     */
    public int deleteSysGoodsTagByIds(Long[] goodsIds);

    /**
     * 删除商品标签对应关系信息
     *
     * @param goodsId 商品标签对应关系ID
     * @return 结果
     */
    public int deleteSysGoodsTagById(Long goodsId);
}