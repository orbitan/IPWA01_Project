package com.example.ipwa_co2;


import javax.faces.bean.ManagedBean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@ManagedBean
public class Dataset {
    private final List<Country> countries = new ArrayList<>();
    private static final Dataset instance = new Dataset();

    public Dataset() {

        try {
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\sarah\\OneDrive\\Desktop\\InfoStudium\\IPWA_co2\\src\\main\\java\\com\\example\\ipwa_co2\\data.csv"));
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

    public List<Country> getCountries() {
        return countries;
    }
}
