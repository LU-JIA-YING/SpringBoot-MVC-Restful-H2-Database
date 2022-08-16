package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.controller.dto.request.CreateOrderRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springrestfulpractice.model.OrderRepository;
import com.example.springrestfulpractice.model.entity.Meal;
import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        List<Order> orderListResponse = orderRepository.findAll();

        return orderListResponse;
    }

    public Order getOrderBySeq(int seq) {
        Order orderBySeqResponse = orderRepository.findBySeq(seq);

        return orderBySeqResponse;
    }

    public String createOrder(CreateOrderRequest request) {

        // 新增一個空的 order 的 entity = 新增一筆空的資料
        Order order = new Order();

        List<Meal> mealList = request.getMealList();
        int total = 0;
        for(Meal meal:mealList){
            total +=meal.getPrice();
        }
        order.setTotalPrice(total);

        // 塞好資料：order 裡的資料是從 request 來的
        order.setWaiter(request.getWaiter());
        order.setMealList(request.getMealList());

        // 儲存進 DB
        orderRepository.save(order);

        // 回傳 OK 告訴 Controller 完成儲存
        return "OK";
    }

    public String updateOrder(int id, UpdateOrderRequest request) {

        // 確認 DB 中有沒有這筆資料
        Order order = orderRepository.findBySeq(id);

        List<Meal> mealList = request.getMealList();
        int total = 0;
        for(Meal meal:mealList){
            total +=meal.getPrice();
        }
        order.setTotalPrice(total);

          if (null == order) {
              return "沒有此訂單";
          }

        // 將要更改的值塞進去
        order.setWaiter(request.getWaiter());
        order.setMealList(request.getMealList());

        // 儲存進 DB
        orderRepository.save(order);

        // 回傳 OK 告訴 Controller 完成儲存
        return "OK";
    }

    public String  deleteOrder(int seq) {
        Order order = orderRepository.findBySeq(seq);

        if (null == order) {
            return "沒有此訂單";
        }

        orderRepository.deleteBySeq(seq);

        return "OK";
    }

}
