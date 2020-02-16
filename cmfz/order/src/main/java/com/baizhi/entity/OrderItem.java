package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "order_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
  @Id
  private String detailId;
  private String orderId;
  private String productId;
  private String productName;
  private Double productPrice;
  private String productIcon;
  private Integer productQuantity;
  private Date createTime;
  private Date updateTime;

}
