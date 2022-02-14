package com.takimruhu.controller;

import com.takimruhu.application.OrderApplication;
import com.takimruhu.dto.request.orderrequest.AddOrderRequest;
import com.takimruhu.dto.request.orderrequest.UpdateOrderRequest;
import com.takimruhu.dto.response.orderresponse.AddOrderResponse;
import com.takimruhu.dto.response.orderresponse.DeleteOrderResponse;
import com.takimruhu.dto.response.orderresponse.DetailedOrderResponse;
import com.takimruhu.dto.response.orderresponse.UpdateOrderResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("orders")
@CrossOrigin
@Validated
public class OrderRestController {
    private OrderApplication orderApplication;

    public OrderRestController(OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }


    @GetMapping("{orderId}")
    public DetailedOrderResponse getOrderById(@PathVariable int orderId){
        return orderApplication.findOrderById(orderId);
    }

    @PostMapping
    public AddOrderResponse addOrder(@PathVariable @Validated AddOrderRequest request){
        return orderApplication.addOrder(request);
    }

    @PutMapping("{orderId}")
    public UpdateOrderResponse updateOrder(@PathVariable @Validated int orderId,
                                           @RequestBody @Validated UpdateOrderRequest request){
        return orderApplication.updateOrder(orderId,request);
    }

    @DeleteMapping("{orderId}")
    public DeleteOrderResponse deleteOrderById(@PathVariable int orderId){
        return orderApplication.deleteOrderById(orderId);
    }

}
