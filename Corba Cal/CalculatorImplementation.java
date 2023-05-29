import CalculatorModule.CalculatorPOA;

public class CalculatorImplementation extends CalculatorPOA {
	public CalculatorImplementation() {
		super();
	}
	
	public double add(double a, double b) {
		return (a + b);
	}

	public double sub(double a, double b) {
		return (a - b);
	}
	
	public double mul(double a, double b) {
		return (a * b);
	}
	
	public double div(double a, double b) {
		return (a / b);
	}			
}
