package com.example.ipwa_co2;

import javax.faces.bean.ManagedBean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;




@ManagedBean
public class Dataset {
    private final List<Country> countries = new ArrayList<>();
    private static final Dataset instance = new Dataset();

    public Dataset() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("/home/sarahh/Projects/IPWA01_Project/src/main/java/com/example/ipwa_co2/data.csv"));
            String line;

            while ((line = bf.readLine()) != null) {
                List<String> tempArr;
                List<Double> finArr = new ArrayList<>();
                tempArr = List.of(line.split(","));

                for (int i = 1; i < tempArr.size(); i ++) {
                    String n = tempArr.get(i);
                    String t = n.replaceAll("^\"|\"$", "");

                    try {
                        Double k = Double.parseDouble(t);
                        finArr.add(k);
                    } catch (NumberFormatException exc) {
                        finArr.add((double) 0);
                    }
                }
                countries.add(new Country(tempArr.get(0).replaceAll("^\"|\"$", ""), finArr));
                this.addToCountries(tempArr.get(0), finArr);
            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Dataset getInstance(){
        return instance;
    }

    public List<Country> getCountries(){
        return this.countries;
    }

    public void addToCountries(String countryName, List<Double> emissions){
        countries.add(new Country(countryName.replaceAll("^\"|\"$", ""), emissions));
    }

}


