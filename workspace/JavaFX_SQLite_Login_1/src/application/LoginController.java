package application;

import java.net.URL;
import java.sql.SQLException;
import java.time.chrono.IsoChronology;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	
	public LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label isConnected;
	@FXML
	private TextField txtUser;
	@FXML
	private PasswordField txtSenha;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(loginModel.isDbConnected()){
			
			isConnected.setText("CONECTADO");
			
		}else{
			
			isConnected.setText("N�O CONECTADO");
		}
		
	}
	public void Login(ActionEvent event){
		
		try {
			if(loginModel.isLogin(txtUser.getText(), txtSenha.getText())){
				isConnected.setText("usu�rio e senha - Corretor");
				
			}else{
				isConnected.setText("Usu�rio ou senha Invalido");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
