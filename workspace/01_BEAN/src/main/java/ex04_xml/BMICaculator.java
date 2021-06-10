package ex04_xml;

public class BMICaculator {
	//field ==property
	private double normal; // 정상(20~25) 20저장
	//private double low; // 저체중  normal 20 기준이라 저장 불필요
	private Calculator calculator;
	double over; //과체중 25~30
	double obesity; //비만 >30
	
	
	//constructor
	public BMICaculator() {}


	public BMICaculator(double normal, double over, double obesity,Calculator calculator) {
		super();
		this.normal = normal;
		this.over = over;
		this.obesity = obesity;
		this.calculator = calculator;
	}
	
	public void info(double height , double weight) {
		//체질량 = 몸무게kg / 키m 제곱
		calculator.divide(height, 100); // m
		double bmi = calculator.divide(weight, calculator.multiply(height, height)); 
		String health =null;
		if(bmi >=obesity) {
			health = "비만";
		}else if(bmi >=over) {
			health = "과체중";
		}else if(bmi >=normal) {
			health = "정상";
		}else {
			health = "저체중";
		}
		System.out.println("체질량지수" + bmi +"("+health+")");
		
	}


	public double getNormal() {
		return normal;
	}


	public void setNormal(double normal) {
		this.normal = normal;
	}


	public Calculator getCalculator() {
		return calculator;
	}


	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}


	public double getOver() {
		return over;
	}


	public void setOver(double over) {
		this.over = over;
	}


	public double getObesity() {
		return obesity;
	}


	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
}
