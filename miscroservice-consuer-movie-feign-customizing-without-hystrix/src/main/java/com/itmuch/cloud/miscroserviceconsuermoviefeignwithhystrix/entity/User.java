package com.itmuch.cloud.miscroserviceconsuermoviefeignwithhystrix.entity;

import java.math.BigDecimal;

public class User {

    private Long id;

    private String name;

    private String username;

    private Integer age;

    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User(Long id ,String username){
        super();
        this.id = id;
        this.username = username;
    }

    public User() {
        super();
    }
}
