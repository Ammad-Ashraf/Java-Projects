package Tayyab.Project.service;


import Tayyab.Project.dao.OrderDao;
import Tayyab.Project.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setOrderId(id);
            return orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order not found");
        }
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}

