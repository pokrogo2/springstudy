package ex01_xml;

public class javaMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//개발자가 직접 new 이용해서 객체 생성
		Calculator calculator1 = new Calculator();
		Calculator calculator2 = new Calculator();
		
		//EngineerCalculator 는 field가 있어 객체에 데이터저장해야한다.
		//1.디폴트 생성자 + setter
		EngineerCalculator engineerCalculator1 = new EngineerCalculator();
		engineerCalculator1.setNum1(7);
		engineerCalculator1.setNum2(2);
		engineerCalculator1.setCalculator(calculator1);
		//2.필드를 이용
		EngineerCalculator engineerCalculator2 = new EngineerCalculator(5,2,calculator2);
		
		
		engineerCalculator1.add();
		engineerCalculator1.subtract();
		engineerCalculator1.multiply();
		engineerCalculator1.divide();
		
		engineerCalculator2.add();
		engineerCalculator2.subtract();
		engineerCalculator2.multiply();
		engineerCalculator2.divide();
		
	}

}
