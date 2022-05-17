package com.micropos.counter.web;

import com.micropos.counter.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CounterResource {

    @RequestMapping(value = "counter", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Double> counterSettlement(List<Item> items) {
        double total = 0.0;
        for (Item item: items) {
            total += item.getPrice() * item.getQuantity();
        }
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

}
