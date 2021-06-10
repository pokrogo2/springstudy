package ex04_xml;

import java.util.List;

public class Member {
	//field ==property
	
	private String name;
	private double height;
	private double weight;
	private BMICaculator bmiCaculator;
	private List<String> services;

	//constructor 
	
	
	//method
	
	public void info() {
		System.out.println("이름 : " +name);
		System.out.println("키 : " +height+"cm");
		System.out.println("몸무게 : " +weight+"kg");
		bmiCaculator.info(height, weight);
		System.out.println("등록 : " + services.toString());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public BMICaculator getBmiCaculator() {
		return bmiCaculator;
	}

	public void setBmiCaculator(BMICaculator bmiCaculator) {
		this.bmiCaculator = bmiCaculator;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}
	
	
}
