package com.takimruhu.application;

import com.takimruhu.dto.request.AddOrderRequest;
import com.takimruhu.dto.request.UpdateOrderRequest;
import com.takimruhu.dto.response.AddOrderResponse;
import com.takimruhu.dto.response.DeleteOrderResponse;
import com.takimruhu.dto.response.DetailedOrderResponse;
import com.takimruhu.dto.response.UpdateOrderResponse;
import org.springframework.context.annotation.Bean;

public interface OrderApplication {

    DetailedOrderResponse findOrderById(int orderId);

    AddOrderResponse addOrder(AddOrderRequest request);

    UpdateOrderResponse updateOrder(int orderId, UpdateOrderRequest request);

    DeleteOrderResponse deleteOrderById(int orderId);
}
