package anno3;

import org.springframework.beans.factory.annotation.Required;

public class Camera extends Object {

	private int number;//카메라 수 0
	
	@Required
	public void setNumber(int number) {
		this.number = number;
		System.out.println("setNumber() call");
	}
	
	//메서드 이름 위에 기술=>메서드명이 오버라이딩이 된 메서드인지 확인해주는 기능을 주는 어노테이션
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Camera[number="+number+"]";
	}
	
}
