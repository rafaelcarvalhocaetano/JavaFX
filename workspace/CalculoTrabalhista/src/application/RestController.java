package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class RestController {
	@FXML
	private Button btnCalc;
	@FXML
	private TextField tDias;

	@FXML
	public void calcular(ActionEvent event) {
		try {
			Parent rt = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(rt);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void infor(){
		
		int num1 = Integer.parseInt(tDias.getText());
	}
	
}
