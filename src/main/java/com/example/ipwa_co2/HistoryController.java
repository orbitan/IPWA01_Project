package com.example.ipwa_co2;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Collections;


@ManagedBean
@ViewScoped
public class HistoryController extends Dataset {
    private LineChartModel lineModel;
    private int index;


    @PostConstruct
    public void init() {
        lineModel = new LineChartModel();
        LineChartSeries s = new LineChartSeries();

        Country c = this.getCountry();
        Double y_max = Collections.max(c.getAmount(), null);


        int k = 1960;
        for(int i = 4; i<c.getAmount().size()-2; i ++){
            s.set(k, c.getAmount().get(i));
            k ++;
        }

        lineModel.addSeries(s);
        lineModel.setLegendPosition("e");

        Axis y = lineModel.getAxis(AxisType.Y);
        y.setTickInterval(String.valueOf(y_max/4));
        y.setTickCount(5);
        y.setMin(0);
        y.setMax(y_max + y_max/100*4);
        y.setLabel("Kilotonnen");

        Axis x = lineModel.getAxis(AxisType.X);
        x.setMin(1950);
        x.setMax(2020);
        x.setTickInterval("5");
        x.setLabel("Jahr");

        s.setLabel("Kilotonnen Co2");
        s.setSmoothLine(true);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void back(){
        if (index > 0){
            index --;
        }
    }

    public void forward(){
        if (index < Dataset.getInstance().getCountries().size()-1){
            index ++;
        };
        this.init();
    }

    public Country getCountry(){
        return Dataset.getInstance().getCountries().get(index);
    }

}
