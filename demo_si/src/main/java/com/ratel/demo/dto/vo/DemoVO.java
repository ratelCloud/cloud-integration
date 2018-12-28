package com.ratel.demo.dto.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ratel.common.dto.BigDecimalSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author niexiang
 * @Description
 * @create 2018-03-19 19:16
 **/
@ApiModel(value = "demoVO")
public class DemoVO {

    @ApiModelProperty(value = "id")
    private int id;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @JsonSerialize(using = BigDecimalSerialize.class)
    @ApiModelProperty(value = "价格")
    private BigDecimal groupPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }

    public BigDecimal getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(BigDecimal groupPrice) {
        this.groupPrice = groupPrice;
    }
}