package com.example.springrestfulpractice.model;

import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findBySeq(int seq);

    @Modifying //以通過自定義的 JPQL 完成 UPDATE 和 DELETE 操作。
    @Transactional
    Long deleteBySeq(int seq);
}
