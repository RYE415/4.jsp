package test;//1.package 최상위패키지명.하위패키지명...->빈즈구분

//자바빈즈=>웹상에서 불러다 사용하는 클래스
//2.public class로 시작해야한다.
public class BeanDTO {

	 //입력->매개변수를 전달=>필드별로 구분해서 저장=>최종(테이블에 저장)
	//3.private 멤버변수;
	private String name;//웹상에서 입력받은 값을 임시로 저장
	private String addr="";

	//4.public접근지정자를 줘서 멤버변수에 접근
	 public void setName(String name){
		 this.name=name;
		 System.out.println("setName()호출됨");
	 }
	 
	 public void setAddr(String addr){
		 this.addr=addr;
		 System.out.println("setAddr()호출됨");
	 }

	 public String getName(){ return name;}
	 public String getAddr() {return addr;}
}
