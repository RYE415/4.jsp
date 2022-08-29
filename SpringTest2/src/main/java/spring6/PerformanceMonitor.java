package spring6;

import java.util.List;
//성능(List객체)
public class PerformanceMonitor {

	private List<Double> number;//성능

	public void setNumber(List<Double> number) {
		this.number = number;
		System.out.println("setNumber() call=>"+number);
	}
	
	
}
