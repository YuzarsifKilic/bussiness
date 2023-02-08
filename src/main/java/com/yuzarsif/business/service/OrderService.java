package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.OrderDtoConverter;
import com.yuzarsif.business.dto.model.OrderDto;
import com.yuzarsif.business.dto.request.CreateOrderRequest;
import com.yuzarsif.business.model.Customer;
import com.yuzarsif.business.model.Order;
import com.yuzarsif.business.model.Product;
import com.yuzarsif.business.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderDtoConverter orderDtoConverter;

    public OrderService(OrderRepository orderRepository,
                        CustomerService customerService,
                        ProductService productService,
                        OrderDtoConverter orderDtoConverter) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.orderDtoConverter = orderDtoConverter;
    }

    public OrderDto createOrder(CreateOrderRequest request) {
        Customer customer = customerService.findByEmail(request.getCustomerEmail());
        Product product = productService.findById(request.getProductId());
        Order order = new Order(customer, product, LocalDateTime.now());
        return orderDtoConverter.convert(orderRepository.save(order));
    }

    public List<OrderDto> getAll() {
        return orderDtoConverter.convert(orderRepository.findAll());
    }
}
