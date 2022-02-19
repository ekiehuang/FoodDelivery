package com.southwind.repository;

import com.southwind.entity.Menu;

import java.util.List;

//@Component
//@Mapper
public interface MenuRepository {
    public List<Menu> findAll(int index, int limit);

    public int count();

    public Menu findById(long id);

    public void save(Menu menu);

    public void deleteById(long id);

    public void update(Menu menu);
}
