package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class MainController {
	
	@FXML LineChart<String, Number> idLC;
	
	public void btn(ActionEvent evento){
		
		idLC.getData().clear();
		
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Fev", 100));
		series.getData().add(new XYChart.Data<String, Number>("Mar�o", 500));
		series.getData().add(new XYChart.Data<String, Number>("Abril", 50));
		series.setName("PAY 1");
		
	//	idLC.getData().add(series);
		
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		
		series1.getData().add(new XYChart.Data<String, Number>("Jan", 100));
		series1.getData().add(new XYChart.Data<String, Number>("Fev", 150));
		series1.getData().add(new XYChart.Data<String, Number>("Mar�o", 200));
		series1.getData().add(new XYChart.Data<String, Number>("Abril", 250));
		series1.setName("PAY 2");
		
		
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		
		series2.getData().add(new XYChart.Data<String, Number>("Jan", 800));
		series2.getData().add(new XYChart.Data<String, Number>("Fev", 950));
		series2.getData().add(new XYChart.Data<String, Number>("Mar�o", 1100));
		series2.getData().add(new XYChart.Data<String, Number>("Abril",250));
		series2.setName("PAY 2");
		
		
		
		idLC.getData().addAll(series, series1, series2);
	}

}
