package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.chrono.IsoChronology;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	public LoginModel loginModel = new LoginModel();

	@FXML
	private Label isConnected;
	@FXML
	private TextField txtUser;
	@FXML
	private PasswordField txtSenha;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (loginModel.isDbConnected()) {

			isConnected.setText("CONECTADO");

		} else {

			isConnected.setText("N�O CONECTADO");
		}

	}

	public void Login(ActionEvent event) {

		try {
			if (loginModel.isLogin(txtUser.getText(), txtSenha.getText())) {
				
				isConnected.setText("usu�rio e senha - Corretor");
				((Node) event.getSource()).getScene().getWindow().hide();
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/User.fxml").openStream());
				UserController userController = (UserController) loader.getController();
				userController.GetUser(txtUser.getText());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();

			} else {
				isConnected.setText("Usu�rio ou senha Invalido");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
