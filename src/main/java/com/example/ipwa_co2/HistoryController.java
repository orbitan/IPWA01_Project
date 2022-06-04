package com.example.ipwa_co2;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


@ManagedBean
@SessionScoped
@WebServlet("/countries")
public class HistoryController extends HttpServlet {
    private LineChartModel lineModel;
    private int index;
    private List<Country> countries;
    private Country selectedCountry;
    String name;


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
    public String getIndex(){
        return String.valueOf(index);
    }
    public void setIndex(String index){
        this.index = (Integer.parseInt(index));
        this.init();
    }



    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void back(){
        if (index > 0){
            index --;
        }
        System.out.println(index);
        this.init();
    }

    public void forward(){
        if (index < Dataset.getInstance().getCountries().size()-1){
            index ++;
        };
        this.init();
        System.out.println(index);
    }

    public void skipCountries(){
        System.out.println("Hello World hihi");
        index += 10;
        this.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);

    }

    public Country getCountry(){
        return Dataset.getInstance().getCountries().get(index);
    }


    public List<Country> getCountries() {
        return Dataset.getInstance().getCountries();
    }

    public Country getSelectedCountry(){
        return selectedCountry;
    }

    public void action(String name) {
        System.out.println("Hello Wrld");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("vorname");
        System.out.println(name);
    }


}
