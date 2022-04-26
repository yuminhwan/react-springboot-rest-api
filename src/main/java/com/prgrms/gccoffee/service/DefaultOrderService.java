package com.prgrms.gccoffee.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.prgrms.gccoffee.model.Email;
import com.prgrms.gccoffee.model.Order;
import com.prgrms.gccoffee.model.OrderItem;
import com.prgrms.gccoffee.model.OrderStatus;
import com.prgrms.gccoffee.repository.OrderRepository;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Email email, String addfress, String postcode, List<OrderItem> orderItems) {
        Order order = new Order(UUID.randomUUID(), email, addfress, postcode, orderItems, OrderStatus.ACCEPTED,
            LocalDateTime.now(), LocalDateTime.now());
        return orderRepository.insert(order);
    }
}
