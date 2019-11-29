package com.sp.bdi.test.test2;

public class CarMaker {

	private String carMakerName;
	private Car car;
	
	public CarMaker(String carMakerName) {
		this.carMakerName = carMakerName;
	}
	
	@Override
	public String toString() {
		return "CarMaker [carMakerName=" + carMakerName + ", car=" + car + "]";
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Car makeCar() {
		System.out.println(this.carMakerName + "가 차를 만듭니다.");
		return this.car;
	}
}
