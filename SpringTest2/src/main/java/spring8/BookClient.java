package spring8;

import java.util.Properties;

public class BookClient {

	private Properties prop;
	
	public void setProp(Properties prop) {
		this.prop=prop;
		System.out.println("setProps() call=>"+prop);
		
	}
}
