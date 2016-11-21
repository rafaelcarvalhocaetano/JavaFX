package application;

public class Controle {

	public float calculadora(long num1, long num2, String operador) {

		switch (operador) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if (num2 == 0) {
				return 0;
			}
			return num1 / num2;
		default:
			return 0;

		}
	}
}