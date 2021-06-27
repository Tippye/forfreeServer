package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品图片对象 sys_goods_gallery
 *
 * @author Tippy
 * @date 2021-06-26
 */
public class SysGoodsGallery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品Id */
    private Long goodsId;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodsImg;

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsImg()
    {
        return goodsImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("goodsId", getGoodsId())
                .append("goodsImg", getGoodsImg())
                .toString();
    }
}