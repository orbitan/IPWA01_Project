package com.example.ipwa_co2;



import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Collections;
import java.util.List;

@ManagedBean
@ViewScoped
public class LineChartBean {
    private LineChartModel lineModel;
    private int index;

    public Country getCountry(){
        return Dataset.getInstance().getCountries().get(index);
    }

    public void vor(){
        if (index < Dataset.getInstance().getCountries().size()-1){
            index ++;

        };
        this.init();
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
