package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysGoodsGallery;

/**
 * 商品图片Mapper接口
 *
 * @author Tippy
 * @date 2021-06-26
 */
public interface SysGoodsGalleryMapper
{
    /**
     * 查询商品图片
     *
     * @param goodsId 商品图片ID
     * @return 商品图片
     */
    public SysGoodsGallery selectSysGoodsGalleryById(Long goodsId);

    /**
     * 查询商品图片列表
     *
     * @param sysGoodsGallery 商品图片
     * @return 商品图片集合
     */
    public List<SysGoodsGallery> selectSysGoodsGalleryList(SysGoodsGallery sysGoodsGallery);

    /**
     * 新增商品图片
     *
     * @param sysGoodsGallery 商品图片
     * @return 结果
     */
    public int insertSysGoodsGallery(SysGoodsGallery sysGoodsGallery);

    /**
     * 修改商品图片
     *
     * @param sysGoodsGallery 商品图片
     * @return 结果
     */
    public int updateSysGoodsGallery(SysGoodsGallery sysGoodsGallery);

    /**
     * 删除商品图片
     *
     * @param goodsId 商品图片ID
     * @return 结果
     */
    public int deleteSysGoodsGalleryById(Long goodsId);

    /**
     * 批量删除商品图片
     *
     * @param goodsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysGoodsGalleryByIds(Long[] goodsIds);
}