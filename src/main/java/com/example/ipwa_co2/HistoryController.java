package com.example.ipwa_co2;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Collections;
import java.util.List;
//hi

@ManagedBean
@ViewScoped
@WebServlet("/countries")
public class HistoryController extends HttpServlet {
    private LineChartModel lineModel;
    private int index;

    @PostConstruct
    public void init() {

        //  Definition of the line chart;
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

        // TODO Render "CO2" in a more appropriate way
        s.setLabel("Kilotonnen C02");

        // TODO change line color to green
        s.setSmoothLine(true);
    }

//    public int getIndex(){
//        return index;
//    }

//    public void setIndex(int index){
//        System.out.println("Hello World");
//        this.index = index;

//    }


    public LineChartModel getLineModel() {
        return lineModel;
    }


    // TODO on change, only update line chart, not complete container
    public void back(){
        if (index > 0){
            index --;
        }
    }

    public void forward(){
        if (index < Dataset.getInstance().getCountries().size()-1){
            index ++;
        };
    }

    public Country getCountry(){
        return Dataset.getInstance().getCountries().get(index);
    }


    public List<Country> getCountries() {
        return Dataset.getInstance().getCountries();
    }


    // TODO Post Request for updating the line chart, once the user chose another country from Drop Down
    public void action(String name) {
        System.out.println("Hello World");
    }


}
