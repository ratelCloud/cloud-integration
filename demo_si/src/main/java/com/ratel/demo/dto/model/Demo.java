package com.ratel.demo.dto.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author niexiang
 * @Description
 * @create 2018-03-19 19:16
 **/
@ApiModel(value = "demo")
public class Demo implements Serializable {

    @NotNull
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}