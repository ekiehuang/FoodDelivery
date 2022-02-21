package com.southwind.repository;

import com.southwind.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);

    public List<Order> findAllByUid(int index, int limit, long uid);

    public int countByUid(long uid);
}
