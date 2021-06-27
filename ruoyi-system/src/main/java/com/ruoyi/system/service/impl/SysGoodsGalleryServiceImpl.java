package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGoodsGalleryMapper;
import com.ruoyi.system.domain.SysGoodsGallery;
import com.ruoyi.system.service.ISysGoodsGalleryService;

/**
 * 商品图片Service业务层处理
 *
 * @author Tippy
 * @date 2021-06-26
 */
@Service
public class SysGoodsGalleryServiceImpl implements ISysGoodsGalleryService
{
    @Autowired
    private SysGoodsGalleryMapper sysGoodsGalleryMapper;

    /**
     * 查询商品图片
     *
     * @param goodsId 商品图片ID
     * @return 商品图片
     */
    @Override
    public SysGoodsGallery selectSysGoodsGalleryById(Long goodsId)
    {
        return sysGoodsGalleryMapper.selectSysGoodsGalleryById(goodsId);
    }

    /**
     * 查询商品图片列表
     *
     * @param sysGoodsGallery 商品图片
     * @return 商品图片
     */
    @Override
    public List<SysGoodsGallery> selectSysGoodsGalleryList(SysGoodsGallery sysGoodsGallery)
    {
        return sysGoodsGalleryMapper.selectSysGoodsGalleryList(sysGoodsGallery);
    }

    /**
     * 新增商品图片
     *
     * @param sysGoodsGallery 商品图片
     * @return 结果
     */
    @Override
    public int insertSysGoodsGallery(SysGoodsGallery sysGoodsGallery)
    {
        return sysGoodsGalleryMapper.insertSysGoodsGallery(sysGoodsGallery);
    }

    /**
     * 修改商品图片
     *
     * @param sysGoodsGallery 商品图片
     * @return 结果
     */
    @Override
    public int updateSysGoodsGallery(SysGoodsGallery sysGoodsGallery)
    {
        return sysGoodsGalleryMapper.updateSysGoodsGallery(sysGoodsGallery);
    }

    /**
     * 批量删除商品图片
     *
     * @param goodsIds 需要删除的商品图片ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsGalleryByIds(Long[] goodsIds)
    {
        return sysGoodsGalleryMapper.deleteSysGoodsGalleryByIds(goodsIds);
    }

    /**
     * 删除商品图片信息
     *
     * @param goodsId 商品图片ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsGalleryById(Long goodsId)
    {
        return sysGoodsGalleryMapper.deleteSysGoodsGalleryById(goodsId);
    }
}