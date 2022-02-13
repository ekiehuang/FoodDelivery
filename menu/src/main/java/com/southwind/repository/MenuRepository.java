package com.southwind.repository;

import com.southwind.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//@Mapper
public interface MenuRepository {
    public List<Menu> findAll(int index, int limit);
    public int count();
    public Menu findById(long id);
    public void save(Menu menu);
    public void deleteById(long id);
}
