package com.micropos.orders.web;

import com.micropos.orders.model.Item;
import com.micropos.orders.model.Order;
import com.micropos.orders.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrdersResource {

    private final OrdersService ordersService;

    public OrdersResource(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "orders", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Order>> listOrder() {
        List<Order> orders = ordersService.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "order_items?id={orderId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Item>> listOrderItems(@PathVariable int orderId) {
        List<Item> products = ordersService.getOrder(orderId).getItems();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
