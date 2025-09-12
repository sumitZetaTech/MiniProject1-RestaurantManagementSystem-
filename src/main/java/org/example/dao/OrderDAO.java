package org.example.dao;

public class OrderDAO {
    public int dishId;
    public String dishName;
    public int dishCount;

    public OrderDAO(int dishId, String dishName, int dishCount){
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishCount = dishCount;
    }
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishCount() {
        return dishCount;
    }

    public void setDishCount(int dishCount) {
        this.dishCount = dishCount;
    }
}
