package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
  @Id
  private String categoryId;
  private String categoryName;
  private String categoryType;
  private Date createTime;
  private Date updateTime;

}
