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
                List<Long> finArr = new ArrayList<>();
                tempArr = List.of(line.split(","));
                for (int i = 5; i < tempArr.size(); i +=1) {
                    String n = tempArr.get(i);
                    if (Objects.equals(n, nullValue)) {
                        n = "0";
                    }
                    String t = n.replaceAll("^\"|\"$", "");
                    try {
                        finArr.add(Long.parseLong(t));
                    } catch (NumberFormatException exc) {
                        finArr.add((long) 0);
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


    public void vor(){
        if (index < Dataset.getInstance().getCountries().size()-1){
            index ++;

        };
//        this.init();
    }

    public void zurueck(){
        if (index > 0){
            index --;
        }
    }
    public int getIndex() {
        return index;
    }
    @PostConstruct
    public void init() {
        lineModel = new LineChartModel();
        LineChartSeries s = new LineChartSeries();
        s.setSmoothLine(true);

        Country c = this.getCountry();
        Long y_max = Collections.max(c.getAmount(), null);

        s.setLabel("Kilotonnen Co2");


        int k = 1960;
        for(int i = 7; i<c.getAmount().size()-1; i ++){
            long val6 = c.getAmount().get(i);
            s.set(k, val6);
            k ++;

            System.out.println(val6);
        }
        lineModel.addSeries(s);
        lineModel.setLegendPosition("e");


        Axis y = lineModel.getAxis(AxisType.Y);
        y.setTickInterval(String.valueOf(y_max/4));
        y.setTickCount(5);
        y.setMin(0);
        y.setMax(y_max + y_max/100*5);
        y.setLabel("Kilotonnen");

        Axis x = lineModel.getAxis(AxisType.X);

        x.setMin(1960);
        x.setMax(2020);
        x.setTickInterval("4");
        x.setLabel("Jahr");



    }
    public LineChartModel getLineModel() {
        return lineModel;
    }

}


