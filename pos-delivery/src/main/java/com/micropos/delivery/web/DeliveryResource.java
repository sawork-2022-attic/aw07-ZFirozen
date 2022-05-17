package com.micropos.delivery.web;

import com.micropos.delivery.model.DeliveryOrder;
import com.micropos.delivery.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class DeliveryResource {

    private final DeliveryService deliveryService;

    public DeliveryResource(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @RequestMapping(value = "deliveries", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<DeliveryOrder>> listOrder() {
        List<DeliveryOrder> orders = deliveryService.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "delivery?id={orderId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<DeliveryOrder> listOrderItems(@PathVariable int orderId) {
        return new ResponseEntity<>(deliveryService.getOrder(orderId), HttpStatus.OK);
    }

}
