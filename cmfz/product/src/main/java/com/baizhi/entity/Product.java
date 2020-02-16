package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  private String productId;
  private String productName;
  private Double productPrice;
  private Integer productStock;
  private String productDescription;
  private String productIcon;
  private String categoryType;
  private Date createTime;
  private Date updateTime;
  @Transient
  private Integer count;
}
