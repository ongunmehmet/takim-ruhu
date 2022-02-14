package com.takimruhu.application;

import com.takimruhu.dto.request.orderrequest.AddOrderRequest;
import com.takimruhu.dto.request.orderrequest.UpdateOrderRequest;
import com.takimruhu.dto.response.orderresponse.AddOrderResponse;
import com.takimruhu.dto.response.orderresponse.DeleteOrderResponse;
import com.takimruhu.dto.response.orderresponse.DetailedOrderResponse;
import com.takimruhu.dto.response.orderresponse.UpdateOrderResponse;

public interface OrderApplication {

    DetailedOrderResponse findOrderById(int orderId);

    AddOrderResponse addOrder(AddOrderRequest request);

    UpdateOrderResponse updateOrder(int orderId, UpdateOrderRequest request);

    DeleteOrderResponse deleteOrderById(int orderId);
}
