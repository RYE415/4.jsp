package spring7;

import java.util.Set;

//고객,도서(서버에 접속->ip주소(=도메인이름),접속시간(spring8)
//책 대여 수
public class Customer {
	private Set<Integer> subSet;//책 대여수(중복X)
	//Set인 경우 xml에서 어떻게 환경설정?-><set>태그 사용
	
	public void setSubSet(Set<Integer> subSet) {
		this.subSet=subSet;
		System.out.println("setSubSet call");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer[subSet="+subSet+"]";
	}
	
	
	
	
}
