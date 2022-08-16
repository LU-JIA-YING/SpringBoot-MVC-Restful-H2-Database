package com.example.springrestfulpractice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// 使用 Lombok 加入 Getter, Setter, Constructor
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主鍵自動增長生成
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String description;
}
