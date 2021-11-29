package com.huike.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Shopcar implements Serializable {
    private String id;
    private String name;
    private String path;
    private Double salary;
    private Integer age;

}
