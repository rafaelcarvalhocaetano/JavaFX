package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	private Label result;
	
	@FXML
	private TextField txt;
	
	@FXML
	private PasswordField senha;
	
	@FXML
	public void entrar(ActionEvent evento){
		
		if(txt.equals("rafael") && senha.equals("rafael")){
			result.setText("OK");
		}else{
			result.setText("SENHA E LOGIN ERRADOS");
		}
	}

}