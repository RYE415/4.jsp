package calc;//1.기능별로 구분

//2.public class로 작성->외부에서(calResult.jsp에서 호출할 메서드)

public class CalcBean {

	
	//3.입력
	private int num1,num2;//"10"->10
	private String operator="";//연산자->null(객체의 초기값을 부여)
	//추가
	private int result;//계산목적
	//웹상에서 호출해서 실행되는 메서드=>비지니스 로직메서드
	
	public void calculate() throws Exception{
		//(+)
		if(operator.equals("+")) {
			result=num1+num2;
		}
		//-
		if(operator.equals("-")) {
			result=num1-num2;
		}
		//*
		if(operator.equals("*")) {
			result=num1*num2;
		}
		// /
		if(operator.equals("/")) {
			result=num1/num2;
		}
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
		System.out.println("setNum() 호출됨!");
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
		System.out.println("setNum2() 호출됨!");
	}
	public int getResult() {//calResult.jsp호출
		return result;
	}
	public void setOperator(String operator) {
		this.operator = operator;
		System.out.println("setOperator() 호출됨!");
	}
	
	
	
}
