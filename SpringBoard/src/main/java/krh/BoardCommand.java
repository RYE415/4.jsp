package krh;

/*
 * BoardDTO or BoardVO->하나의 레코드에 관련된 필드와 연관이 있는 클래스
 * BoardCommand => 실질적으로 사용자로부터 값을 입력을 받는 필드로만 구성된 클래스
 * 
 */
public class BoardCommand {

	String author,title,content;//num,date,readcnt=>입력X
	//스프링=><jsp:setProperty name="~" property="*" />

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		System.out.println("setAuthor() call");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("setTitle() call");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		System.out.println("setContent() call");
	}
	
	
}
