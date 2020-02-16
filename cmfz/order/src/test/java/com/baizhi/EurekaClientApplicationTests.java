package com.baizhi;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.CategoryVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class EurekaClientApplicationTests {
    @Autowired
    CategoryDao categoryDao;
    @Test
    void contextLoads() {
        List<CategoryVO> categoryVOS = categoryDao.selectAllCategoryVO();
        System.out.println(categoryVOS);
    }

}
