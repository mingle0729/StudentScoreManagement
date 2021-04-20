package kr.mrhi.test0219;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	
	//DB에 연결하는 함수
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Properties properties = new Properties(); //Properties 객체 생성하기.
			String filePath = DBUtil.class.getResource("db.properties").getPath(); //Properties파일 경로 가져오기.
			properties.load(new FileReader(filePath));//Properties 불러오기.
			
			//바인딩 하기.
			String MYSQL_DRIVER = properties.getProperty("MYSQL_DRIVER");
			String URL = properties.getProperty("URL");
			String USERNAME = properties.getProperty("userName");
			String PASSWORD = properties.getProperty("password");
			
			//드라이버에 적재하기.
			Class.forName(MYSQL_DRIVER);
			//DB에 연결하기.
			connection = DriverManager.getConnection(URL+"?useSSL=false",USERNAME,PASSWORD);
		}catch (Exception e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		//연결된 connection돌려주기
		return connection;
	}
}
