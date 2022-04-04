package com.example.ipwa_co2;

import javax.faces.bean.ManagedBean;
import java.util.List;

//  Model for country objects
@ManagedBean
public class Country {

    private String name;
    private final List<Double> amount;

    public Country(String name, List<Double> amount){
        this.name = name;
        this.amount = amount;

    }

    public void setName(String name) {
        this.name = name;
    }

//TODO round return value on two decimals
    public Double getLAmount() {
        if (amount.get(55) == 0){
            return null;
        } else {
            return amount.get(55);
        }
    }

    public List<Double> getAmount(){
        return amount;
    }

    public String getName() {
        return name;
    }

}
