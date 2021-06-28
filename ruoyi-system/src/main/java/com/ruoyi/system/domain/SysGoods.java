package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 商品信息对象 sys_goods
 *
 * @author Tippy
 * @date 2021-06-26
 */
public class SysGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long goodsId;

    /** 商品标题 */
    @Excel(name = "商品标题")
    private String goodsTitle;

    /** 商品发布者 */
    @Excel(name="发布者")
    private SysUser goodsAuthor;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Long goodsPrice;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String goodsDesc;

    private List<SysGoodsGallery> goodsGallery;

    private List<SysTag> goodsTags;

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsTitle(String goodsTitle)
    {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsTitle()
    {
        return goodsTitle;
    }
    public void setGoodsPrice(Long goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public Long getGoodsPrice()
    {
        return goodsPrice;
    }
    public void setGoodsDesc(String goodsDesc)
    {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsDesc()
    {
        return goodsDesc;
    }

    public List<SysGoodsGallery> getGoodsGallery() {
        return goodsGallery;
    }

    public void setGoodsGallery(List<SysGoodsGallery> goodsGallery) {
        this.goodsGallery = goodsGallery;
    }

    public List<SysTag> getGoodsTags() {
        return goodsTags;
    }

    public void setGoodsTags(List<SysTag> goodsTags) {
        this.goodsTags = goodsTags;
    }

    public SysUser getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(SysUser goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("goodsId", getGoodsId())
                .append("goodsTitle", getGoodsTitle())
                .append("goodsPrice", getGoodsPrice())
                .append("goodsDesc", getGoodsDesc())
                .toString();
    }
}