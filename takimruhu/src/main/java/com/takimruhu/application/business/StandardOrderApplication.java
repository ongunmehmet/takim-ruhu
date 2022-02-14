package com.takimruhu.application.business;

import com.takimruhu.application.OrderApplication;
import com.takimruhu.dto.request.AddOrderRequest;
import com.takimruhu.dto.request.UpdateOrderRequest;
import com.takimruhu.dto.response.AddOrderResponse;
import com.takimruhu.dto.response.DeleteOrderResponse;
import com.takimruhu.dto.response.DetailedOrderResponse;
import com.takimruhu.dto.response.UpdateOrderResponse;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
@Service
public class StandardOrderApplication implements OrderApplication {
    @Override
    public DetailedOrderResponse findOrderById(int orderId) {
        return null;
    }

    @Override
    public AddOrderResponse addOrder(AddOrderRequest request) {
        return null;
    }

    @Override
    public UpdateOrderResponse updateOrder(int orderId, UpdateOrderRequest request) {
        return null;
    }

    @Override
    public DeleteOrderResponse deleteOrderById(int orderId) {
        return null;
    }
}
