package com.baizhi.dao;

import com.baizhi.entity.Category;
import com.baizhi.entity.CategoryVO;
import com.baizhi.entity.Product;
import com.baizhi.entity.ProductVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryDao extends Mapper<Category> {
    List<CategoryVO> selectAllCategoryVO();
}
