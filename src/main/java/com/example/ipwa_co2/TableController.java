package com.example.ipwa_co2;


import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean

public class TableController {
    List<Country> countries;


    public void setCountries() {
        this.countries = Dataset.getInstance().getCountries();
    }


    public List<Country> getCountries() {
        return Dataset.getInstance().getCountries();
    }

}
