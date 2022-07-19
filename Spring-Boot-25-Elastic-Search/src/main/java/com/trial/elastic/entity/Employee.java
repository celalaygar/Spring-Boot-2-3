package com.trial.elastic.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "employee")
public class Employee {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String employeeName;
}
