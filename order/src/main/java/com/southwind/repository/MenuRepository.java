package com.southwind.repository;

import com.southwind.entity.Menu;

//@Component
//@Mapper
public interface MenuRepository {
    public Menu findById(long id);
}
