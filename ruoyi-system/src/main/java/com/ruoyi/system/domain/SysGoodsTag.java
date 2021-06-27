package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品标签对应关系对象 sys_goods_tag
 *
 * @author Tippy
 * @date 2021-06-27
 */
public class SysGoodsTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long goodsId;

    /** 标签id */
    private Long tagId;

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setTagId(Long tagId)
    {
        this.tagId = tagId;
    }

    public Long getTagId()
    {
        return tagId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("goodsId", getGoodsId())
                .append("tagId", getTagId())
                .toString();
    }
}