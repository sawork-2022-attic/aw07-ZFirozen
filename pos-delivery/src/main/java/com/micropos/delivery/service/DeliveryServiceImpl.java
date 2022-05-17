package com.micropos.delivery.service;

import com.micropos.delivery.model.DeliveryOrder;
import com.micropos.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(@Autowired DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<DeliveryOrder> getOrders() {
        return deliveryRepository.getOrders();
    }

    @Override
    public DeliveryOrder getOrder(int OrderNo) {
        return deliveryRepository.getOrder(OrderNo);
    }

    @Override
    public boolean addOrder(int OrderNo) {
        return deliveryRepository.addOrder(OrderNo);
    }

}
