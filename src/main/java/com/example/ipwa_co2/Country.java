package com.example.ipwa_co2;


import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class Country {

    private String name;
    private List<Double> amount;

    public Country(String name, List<Double> amount){
        this.name = name;
        this.amount = amount;

    }
    public Country(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void setAmount(List<Double> amount) {
        this.amount = amount;
    }
}
