package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderVO {
    private String name;
    private String phone;
    private String address;
    private String openId;
    private List<Product> items;
}
