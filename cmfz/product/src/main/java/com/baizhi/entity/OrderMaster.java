package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMaster {
  @Id
  private String orderId;
  private String buyerName;
  private String buyerIphone;
  private String buyerAddress;
  private String buyerOpenid;
  private Double orderAmount;
  private String orderStatus;
  private String payStatus;
  private Date createTime;
  private Date updateTime;
}
