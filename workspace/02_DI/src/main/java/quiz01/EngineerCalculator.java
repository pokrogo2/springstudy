package quiz01;

import javax.inject.Inject;

public class EngineerCalculator {
	@Inject
	private Calculator calculator;
	public void add(int a,int b) {
		calculator.add(a, b);
	}
	public void subtract(int a,int b) {
		calculator.subtract(a, b);
	}
	public void multiply(int a,int b) {
		calculator.multiply(a, b);
	}
	public void divide(int a,int b) {
		calculator.divide(a, b);
	}
	public EngineerCalculator() {
		// TODO Auto-generated constructor stub
	}
	public EngineerCalculator(Calculator calculator) {
		super();
		this.calculator = calculator;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	
	
}
