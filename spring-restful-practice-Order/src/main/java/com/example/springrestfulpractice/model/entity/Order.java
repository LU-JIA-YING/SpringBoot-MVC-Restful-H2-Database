package com.example.springrestfulpractice.model.entity;

import com.example.springrestfulpractice.model.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders") //order是H2 database保留字
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主鍵自動增長生成
    private int seq;

    @Column
    private int totalPrice;

    @Column
    private String waiter;

    @Column
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY) //cascade=CascadeType.ALL=>無論儲存、合併、 更新或移除，一併對被參考物件作出對應動作。
    @JoinTable(name = "ORDERS_MEAL_LIST",
            joinColumns = @JoinColumn(name = "order_seq", referencedColumnName = "seq"),
            inverseJoinColumns = @JoinColumn(name = "meal_list_id", referencedColumnName = "id"))
    private List<Meal> mealList;

    public int getTotalPrice() {
        this.totalPrice=0;
        for (Meal meal : this.getMealList()) {
            this.totalPrice += meal.getPrice();
        }
        return this.totalPrice;
    }
}
