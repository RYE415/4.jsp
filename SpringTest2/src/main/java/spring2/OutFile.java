package spring2;

import java.io.IOException;

//파일에 문자열을 입력받아서 추력시켜주는 공통의 추상메서드
public interface OutFile {
	public void out(String message)throws IOException;
}
