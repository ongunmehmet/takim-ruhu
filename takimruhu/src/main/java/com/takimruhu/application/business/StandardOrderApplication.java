package com.takimruhu.application.business;

import com.takimruhu.application.OrderApplication;
import com.takimruhu.dto.request.orderrequest.AddOrderRequest;
import com.takimruhu.dto.request.orderrequest.UpdateOrderRequest;
import com.takimruhu.dto.response.orderresponse.AddOrderResponse;
import com.takimruhu.dto.response.orderresponse.DeleteOrderResponse;
import com.takimruhu.dto.response.orderresponse.DetailedOrderResponse;
import com.takimruhu.dto.response.orderresponse.UpdateOrderResponse;
import org.springframework.stereotype.Service;

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
