package com.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhourui
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "user", type = "user")
public class User  {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String motto;

    @Field(type = FieldType.Integer)
    private Integer age;
}

