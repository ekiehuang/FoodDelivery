package com.southwind.controller;

import com.southwind.entity.Order;
import com.southwind.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Resource
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<Order> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return orderRepository.findAll(index, limit);
    }
}
