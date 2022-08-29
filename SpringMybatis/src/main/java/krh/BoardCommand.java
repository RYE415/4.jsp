package krh;

//BoardDTO->하나의 레코드에 관련된 필드와 연관이 있는 클래스
//BoardCommand->실질적으로 사용자로부터 값을 입력받는 필드로만 구성된 클래스를 작성
public class BoardCommand {
	
		int num;
        String author,title,content;//num,date,readcnt=>입력X(디폴트 처리)
        //스프링=><jsp:setProperty name=""   property="*" />=>Setter Method호출
		
        String writeday;
        int readcnt;
        String searchName,searchValue;//이 부분 때문에 따로 클래스 작성X
        
        public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

        
		public String getWriteday() {
			return writeday;
		}

		public void setWriteday(String writeday) {
			this.writeday = writeday;
		}

		public int getReadcnt() {
			return readcnt;
		}

		public void setReadcnt(int readcnt) {
			this.readcnt = readcnt;
		}

		public String getSearchName() {
			return searchName;
		}

		public void setSearchName(String searchName) {
			this.searchName = searchName;
		}

		public String getSearchValue() {
			return searchValue;
		}

		public void setSearchValue(String searchValue) {
			this.searchValue = searchValue;
		}

		//-------------------------------------------------------
		
		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {//request.getParameter("author")
			this.author = author;
			System.out.println("setAuthor()호출됨!");
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
			System.out.println("setTitle()호출됨!");
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
			System.out.println("setContent()호출됨!");
		}
}




