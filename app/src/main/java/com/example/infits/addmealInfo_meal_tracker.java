package com.example.infits;

public class addmealInfo_meal_tracker {

    int mealIocn;
    String mealType,mealname,mealcalorie,carb,protein,fat,time;

    public addmealInfo_meal_tracker(int mealIocn,String mealType,String mealname,String mealcalorie,String carb,String protein,String fat){
        this.mealType=mealType;
        this.mealIocn=mealIocn;
        this.mealname=mealname;
        this.mealcalorie=mealcalorie;
        this.fat=fat;
        this.protein=protein;
        this.carb=carb;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
