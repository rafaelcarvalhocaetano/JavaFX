package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class MainController {
	
	@FXML
	private CheckBox cb1;
	
	@FXML
	private CheckBox cb2;
	
	@FXML
	private CheckBox cb3;
	
	@FXML
	private CheckBox cb4;
	
	@FXML
	private Label lblista;
	
	@FXML
	private Label lbitens;
	
	
	public void checkEvento(ActionEvent event){
		int count = 0;
		String mensagem = "";
		if(cb1.isSelected()){
			count ++;
			mensagem += cb1.getText() +"\n";
		}
		if(cb2.isSelected()){
			count ++;
			mensagem += cb2.getText()+"\n";
		}
		if(cb3.isSelected()){
			count ++;
			mensagem += cb3.getText()+"\n";
		}
		if(cb4.isSelected()){
			count ++;
			mensagem += cb4.getText()+"\n";
		}
		lbitens.setText("Itens selecionados : "+ count);
		lblista.setText(mensagem);
	}
	

}