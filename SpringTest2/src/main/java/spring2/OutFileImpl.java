package spring2;

import java.io.*;

//파일을 생성->파일 내부에 문자열을 출력시켜주는 프로그램을 작성하시오.
public class OutFileImpl implements OutFile {

	private String filePath;//경로 및 만들어진 파일명 저장
	
	//setFilePath 호출하기 위해서 <property>태그를 줘야 한다.
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("setFilePath()호출됨=>"+filePath);
	}


	public void out(String message)throws IOException {
		// TODO Auto-generated method stub
		//한글데이터 저장->FileOutputStream(영문),FileWriter(한글)
		FileWriter fw=new FileWriter(filePath);//c:/webtest/good.txt
		fw.write(message);
		fw.close();//메모리해제 종료
	}

}
