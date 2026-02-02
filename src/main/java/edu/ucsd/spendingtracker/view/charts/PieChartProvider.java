package edu.ucsd.spendingtracker.view.charts;

import java.util.Map;

import edu.ucsd.spendingtracker.model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class PieChartProvider implements IChartProvider{
  @Override
  public Node createChart(Map<Category, Double> data){

    PieChart chart = new PieChart();

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    
    data.forEach((cat, sum) -> {
      pieChartData.add(new PieChart.Data(cat.name(), sum));
    });

    chart.setData(pieChartData);

    //Stuck here ------

    for(PieChart.Data entry : pieChartData){
      String color = Category.valueOf(entry.getXValue()).color;
      Node bar = entry.getNode();
      if(bar != null){
        bar.setStyle("-fx-bar-fill: " + color + ";");
      }
    }

    chart.getData().add(series);
    chart.setLegendVisible(false);

    return chart;
  }

  @Override
  public String getDisplayName(){

    return "Bar Chart";

  } 
}
