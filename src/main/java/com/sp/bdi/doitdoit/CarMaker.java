package com.sp.bdi.doitdoit;

public class CarMaker {

	private Car car;
	private String carMakerName;
	
	public CarMaker(String carMakerName) {
		this.carMakerName = carMakerName;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public Car makeCar() {
		System.out.println(this.carMakerName + "가" + car + "를 만듭니다.");
		return this.car;
	}
}
