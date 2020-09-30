package com.example.demo.config;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

//@JsonComponent
public class PageSerializer/* extends JsonSerializer<Page<?>>*/ {

//	@Override
//	public void serialize(Page<?> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//		// TODO Auto-generated method stub
//		gen.writeStartObject();
//		gen.writeFieldName("content");
//		serializers.defaultSerializeValue(value.getContent(), gen);
//
//		gen.writeObjectField("pageable", value.getPageable()); 
//		gen.writeBooleanField("last", value.isLast());
//		gen.writeBooleanField("first", value.isFirst());
//		gen.writeBooleanField("empty", value.isEmpty());
//		gen.writeNumberField("totalPages", value.getTotalPages());
//		gen.writeNumberField("totalElements", value.getTotalElements());
//		gen.writeNumberField("size", value.getSize());
//		gen.writeNumberField("number", value.getNumber());
//		gen.writeNumberField("numberOfElements", value.getNumberOfElements());
//		gen.writeObjectField("sort", value.getSort()); 
//		gen.writeEndObject();
//	}

}
