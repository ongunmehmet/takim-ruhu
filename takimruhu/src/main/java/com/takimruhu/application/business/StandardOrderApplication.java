package com.takimruhu.application.business;

import com.takimruhu.application.OrderApplication;
import com.takimruhu.application.business.exception.OrderAlreadyExistException;
import com.takimruhu.application.business.exception.OrderNotFoundException;
import com.takimruhu.dto.request.orderrequest.AddOrderRequest;
import com.takimruhu.dto.request.orderrequest.UpdateOrderRequest;
import com.takimruhu.dto.response.orderresponse.AddOrderResponse;
import com.takimruhu.dto.response.orderresponse.DeleteOrderResponse;
import com.takimruhu.dto.response.orderresponse.DetailedOrderResponse;
import com.takimruhu.dto.response.orderresponse.UpdateOrderResponse;
import com.takimruhu.entities.Order;
import com.takimruhu.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StandardOrderApplication implements OrderApplication {

    private OrderRepository orderRepository;
    private ModelMapper modelMapper;

    public StandardOrderApplication(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DetailedOrderResponse findOrderById(int orderId) {
        var order = orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException());
        var detailedOrderResponse = modelMapper.map(order,DetailedOrderResponse.class);
        return detailedOrderResponse;
    }

    @Override
    @Transactional
    public AddOrderResponse addOrder(AddOrderRequest request) {
        var orderId = request.getOrderId();
        if(orderRepository.existsById(orderId))
            throw new OrderAlreadyExistException();
        var order = modelMapper.map(request, Order.class);
        return modelMapper.map(orderRepository.save(order),
                AddOrderResponse.class);
    }

    @Override
    @Transactional
    public UpdateOrderResponse updateOrder(int orderId, UpdateOrderRequest request) {
        var managedOrder = orderRepository.findById(orderId)
                .orElseThrow(()->new OrderNotFoundException());
        //managedOrder.setTimeStamp(request.getTimeStamp());
        managedOrder.setProductId(request.getProductId());
        managedOrder.setCargoId(request.getCargoId());
        managedOrder.setAddress(request.getAddress());
        orderRepository.save(managedOrder);
        var updateOrderResponse = modelMapper.map(managedOrder, UpdateOrderResponse.class);
        return updateOrderResponse;
    }

    @Override
    @Transactional
    public DeleteOrderResponse deleteOrderById(int orderId) {
        var managedOrder = orderRepository.findById(orderId)
                .orElseThrow(()-> new OrderNotFoundException());
        orderRepository.delete(managedOrder);
        return modelMapper.map(managedOrder,DeleteOrderResponse.class);
    }
}
