package com.example.ipwa_co2;


import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class Country {

    private String name;
    private List<Long> amount;

    public Country(String name, List<Long> amount){
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

    public Long getLAmount() {
        if (amount.get(55) == 0){
            return null;
        } else {
            return amount.get(55);
        }
    }

    public List<Long> getAmount(){
        return amount;
    }

    public void setAmount(List<Long> amount) {
        this.amount = amount;
    }
}
