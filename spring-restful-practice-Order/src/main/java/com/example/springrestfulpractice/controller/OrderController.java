package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.controller.dto.request.CreateOrderRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springrestfulpractice.controller.dto.response.StatusResponse;
import com.example.springrestfulpractice.model.entity.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping() //取得所有訂單
    public List<Order> getAllOrders() {
        List<Order> orderListResponse = this.orderService.getAllOrders();
        return orderListResponse;
    }

    @GetMapping("/{seq}") //根據ID 取得某筆訂單
    public Order getOrderBySeq(@PathVariable int seq) {
        Order orderBySeqResponse = orderService.getOrderBySeq(seq);

        return orderBySeqResponse;
    }

    @PostMapping() //新增訂單
    public StatusResponse createOrder(@RequestBody CreateOrderRequest request) {
        String createOrderResponse = orderService.createOrder(request);
        return new StatusResponse(createOrderResponse);
    }

    @PutMapping("/{seq}") //修改已存在訂單
    public StatusResponse updateOrder(@PathVariable int seq, @RequestBody UpdateOrderRequest request) {
        String updateOrder = this.orderService.updateOrder(seq, request);
        return new StatusResponse(updateOrder);
    }

    @DeleteMapping("/{seq}") //刪除訂單
    public StatusResponse  deleteOrder(@PathVariable int seq) {
        String  deletedOrder = this.orderService.deleteOrder(seq);
        return new StatusResponse(deletedOrder);
    }

}
