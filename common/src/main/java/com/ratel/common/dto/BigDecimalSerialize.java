package com.ratel.common.dto;

import java.io.IOException;
import java.math.BigDecimal; 
 
import com.fasterxml.jackson.core.JsonGenerator; 
import com.fasterxml.jackson.core.JsonProcessingException; 
import com.fasterxml.jackson.databind.JsonSerializer; 
import com.fasterxml.jackson.databind.SerializerProvider; 
 
/** 
 * BigDecimal类型转化 
 * <p>  属性上加 @JsonSerialize(using = BigDecimalSerialize.class)即可，用于统一小数的格式给前端
 *  
 * @author ratel
 * @date 2018年12月25日 
 * @version 1.0.0 
 */ 
public class BigDecimalSerialize extends JsonSerializer<BigDecimal> { 
 
	@Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException { 
		if (value != null) { 
			gen.writeString(value.setScale(2).toPlainString()); 
		} 
	} 
 
} 