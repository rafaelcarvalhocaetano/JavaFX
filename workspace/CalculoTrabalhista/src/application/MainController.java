package application;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Button btnCalc;
	@FXML
	private TextField lbDias;
	@FXML
	private TextField lbFDS;
	@FXML
	private Button btnRecalc;
	@FXML
	private Button btnSair;
	@FXML
	private Label li;
	@FXML
	private Label refPiso;
	@FXML
	private Label refAdic;
	@FXML
	private Label refHoras;
	@FXML
	private Label refHorasSeis;
	@FXML
	private Label refHorasCem;
	@FXML
	private Label bruto;
	@FXML
	private Label vPiso;
	@FXML
	private Label vAdc;
	@FXML
	private Label vHoras;
	@FXML
	private Label vHorasSeis;
	@FXML
	private Label vHorasCem;
	@FXML
	private Label vDSR;	
	@FXML
	private Label vTrans;
	@FXML
	private Label vRef;
	@FXML
	private Label desconto;
	@FXML
	private Label vDesconto;
	@FXML
	private Label refSind;
	@FXML
	private Label refCOnv;
	@FXML
	private Label refVR;
	@FXML
	private Label refVT;
	@FXML
	private Label vSind;
	@FXML
	private Label vConv;
	@FXML
	private Label vVR;
	@FXML
	private Label vVT;
	@FXML
	private Label vInss;
	@FXML
	private Label refInss;
	@FXML
	private Label vLiquido;
	@FXML
	private Label refDSR;
	@FXML
	private TextField tFT;
	@FXML
	private TextField t100;
	
	
	
	private double diasTrabalhados;
	private int fds;
	private double piso;
	private double adc;
	private double horas;
	private double horasSeis;
	private double horasCem;
	private double inss;
	private double vt;
	private double vr;
	private double conv;
	private double sind;
	
	DecimalFormat formato = new DecimalFormat("#.##");
	
	public void somar(ActionEvent evento){
		
		try {
			
		refPiso.setText("1446.40");
		vPiso.setText(refPiso.getText());
		refAdic.setText("433.92");
		vAdc.setText(refAdic.getText());
		refHoras.setText(lbFDS.getText());
		refHorasSeis.setText("13.66");
		vHorasSeis.setText(refHorasSeis.getText());
		refHorasCem.setText("17.08");
		vHorasCem.setText(refHorasCem.getText());
		refDSR.setText(lbFDS.getText());
		
		horasSeis = Double.parseDouble(refHorasSeis.getText());
		horasCem = Double.parseDouble(refHorasCem.getText());
		diasTrabalhados = Integer.parseInt(lbDias.getText());
		fds = Integer.parseInt(lbFDS.getText());
		
		//convertendo
		refPiso.setText("1446.40");
		piso = Double.parseDouble(refPiso.getText());
		
		adc = Double.parseDouble(refAdic.getText());
		adc = (piso * 30) / 100;
		
		//Calc Horas trabalhada
		horas = (diasTrabalhados * 11) -191;
		refHoras.setText(String.valueOf(horas)+" Horas");
					
		//horas 100%
		double t1 = Double.parseDouble(t100.getText());
		t1 = 11;				
		horasCem = t1 * 17.08;		
		vHorasCem.setText(String.valueOf(horasCem));
		
		//Horas a 60%
		vHorasSeis.setText(refHorasSeis.getText());
		horasSeis = Double.parseDouble(vHorasSeis.getText());
		
		if(horasCem > 1){
			double ht = (horasSeis * horas) - horasCem; 
			horasSeis = ht * 13.66;
			vHorasSeis.setText(String.valueOf(ht));
			
		}else{
			horasSeis = horas * 13.66;
			vHorasSeis.setText(String.valueOf(horasSeis));
		
		}
		
		//Calc DSR
		double txt = Double.parseDouble(lbFDS.getText());
		double h60 = Double.parseDouble(vHorasSeis.getText());
		double txt1 = (h60 / diasTrabalhados) * txt;
		vDSR.setText(String.valueOf(formato.format(txt1)));
				
		//Calc bruto
		double res1 = Double.parseDouble(vHorasSeis.getText());
		double res2 = Double.parseDouble(vHorasCem.getText());
		double res3 = txt1;
				
		double somar = res1 + res2 + res3 + piso + adc;	
		bruto.setText(String.valueOf(formato.format(somar)));
		
		double nBruto = somar;
		
		//=============================Descontos============================//
		
		//=============================INSS============================//
		
		inss = nBruto;
			
		if( inss <= 1556.94){
		
			refInss.setText("8");
			double res = Double.parseDouble(refInss.getText());
			double r2 = (inss * res) / 100;			
			vInss.setText(String.valueOf(r2));
			
		}
		if(inss > 1556.95 || inss <= 2594.92){
			
			refInss.setText("9");
			double res = Double.parseDouble(refInss.getText());
			double r2 = (inss * res) / 100;
			vInss.setText(String.valueOf(r2));
			
		}
		if(inss > 2594.92){
			
			refInss.setText("11");
			double res = Double.parseDouble(refInss.getText());
			double r2 = ( inss * res) / 100;
			vInss.setText(String.valueOf(r2));
		}
		//=============================VT============================//
		
		refVT.setText("6");						
		vt = Double.parseDouble(refVT.getText());
		double res = (piso * 6) / 100;
		vVT.setText(String.valueOf(formato.format(res)));
		
		//=============================VR============================//
		refVR.setText("18");	
		
		vr = Double.parseDouble(lbDias.getText());
		double resVR = ((diasTrabalhados * 22.00) * vr) / 100;
		vVR.setText(String.valueOf(formato.format(resVR)));
		
		
		//=============================CONV============================//
		
		refCOnv.setText("6");
		double resCon = Double.parseDouble(refCOnv.getText());
		double calcCon = (piso * resCon) / 100;
		vConv.setText(String.valueOf(formato.format(calcCon)));		
		
		//=============================SIND============================//
		refSind.setText("1");
		sind = Double.parseDouble(refSind.getText());
		double resSind = (piso * sind) / 100;
		vSind.setText(String.valueOf(formato.format(resSind)));		
		
		//=============================VR============================//
		
		double resInss = Double.parseDouble(vInss.getText());
		
		double descontos = resSind + calcCon + resVR + res + resInss;
		vDesconto.setText(String.valueOf(formato.format(descontos)));
		
		
		//=============================LIQUIDO============================//
		
		double liquido = nBruto - descontos;
		vLiquido.setText(String.valueOf(formato.format(liquido)));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void limpar(ActionEvent event){
		
		//todos os ref
		refPiso.setText("");
		refAdic.setText("");
		refHoras.setText("");
		refHorasSeis.setText("");
		refHorasCem.setText("");
		refDSR.setText("");
		refCOnv.setText("");
		refInss.setText("");
		refSind.setText("");
		refVR.setText("");
		refVT.setText("");
		
		//todos v
		vPiso.setText("");
		vAdc.setText("");
		vHoras.setText("");
		vHorasSeis.setText("");
		vHorasCem.setText("");
		vDSR.setText("");
		vConv.setText("");
		vInss.setText("");
		vSind.setText("");
		vVR.setText("");
		vVT.setText("");
		vDesconto.setText("");
		vLiquido.setText("");
		
		//label sem referencias	
		bruto.setText("");
	
	}
	public void sair(ActionEvent event){
		
		System.exit(0);
	}

}
