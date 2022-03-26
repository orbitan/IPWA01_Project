package com.example.ipwa_co2;


import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.Collections;
import java.util.List;




@ManagedBean
public class Dataset {
    private final List<Country> countries = new ArrayList<>();
    private static final Dataset instance = new Dataset();
    private LineChartModel lineModel;
    private int index;

    public Dataset() {

        try {
            BufferedReader bf = new BufferedReader(new FileReader("/home/sarahh/Projects/IPWA01_Project/src/main/java/com/example/ipwa_co2/data.csv"));
            String line;
            String nullValue = "\"\"";
            while ((line = bf.readLine()) != null) {
                List<String> tempArr = new ArrayList<>();
                List<Double> finArr = new ArrayList<>();
                tempArr = List.of(line.split(","));
                for (int i = 1; i < tempArr.size(); i ++) {
                    String n = tempArr.get(i);
                    String t = n.replaceAll("^\"|\"$", "");
                    System.out.println(t);
                    try {
                        Double k = Double.parseDouble(t);
                        finArr.add(k);
                    } catch (NumberFormatException exc) {
                        finArr.add((double) 0);
                    }
                }
                countries.add(new Country(tempArr.get(0).replaceAll("^\"|\"$", ""), finArr));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static Dataset getInstance(){
        return instance;
    }


    public Country getCountry(){
        return Dataset.getInstance().getCountries().get(index);
    }

    public List<Country> getCountries(){
        return this.countries;
    }




}


