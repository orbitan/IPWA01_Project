package com.example.ipwa_co2;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;


@ViewScoped
@ManagedBean
public class Dataset {
    private final List<Country> countries = new ArrayList<>();
    private static final Dataset instance = new Dataset();
    private int counter = 0;

    public Dataset() {

        // Reads data from data.csv and transforms from each row a country object
        try {
            //TODO filename should not be the absolute path
            BufferedReader bf = new BufferedReader(new FileReader("/home/sarahh/Projects/IPWA01_Project/src/main/java/com/example/ipwa_co2/data.csv"));

            String line;

            //TODO tempArr and finArr should not exist both, so get rid of tempArr
            while ((line = bf.readLine()) != null) {
                List<String> tempArr;
                List<Double> finArr = new ArrayList<>();
                tempArr = List.of(line.split(","));

                // Casts each String from tempArr in Double
                for(String s : tempArr.subList(1, tempArr.size()-2)){
                    try {
                        finArr.add(Double.parseDouble(s.replaceAll("^\"|\"$", "")));
                    } catch (NumberFormatException exc) {
                        finArr.add((double) 0);
                    }
                }
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
        counter += 1;
        countries.add(new Country(countryName.replaceAll("^\"|\"$", ""), emissions));
    }

}

//t
