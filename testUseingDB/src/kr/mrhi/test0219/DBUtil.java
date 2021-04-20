package kr.mrhi.test0219;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	
	//DB�� �����ϴ� �Լ�
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Properties properties = new Properties(); //Properties ��ü �����ϱ�.
			String filePath = DBUtil.class.getResource("db.properties").getPath(); //Properties���� ��� ��������.
			properties.load(new FileReader(filePath));//Properties �ҷ�����.
			
			//���ε� �ϱ�.
			String MYSQL_DRIVER = properties.getProperty("MYSQL_DRIVER");
			String URL = properties.getProperty("URL");
			String USERNAME = properties.getProperty("userName");
			String PASSWORD = properties.getProperty("password");
			
			//����̹��� �����ϱ�.
			Class.forName(MYSQL_DRIVER);
			//DB�� �����ϱ�.
			connection = DriverManager.getConnection(URL+"?useSSL=false",USERNAME,PASSWORD);
		}catch (Exception e) {
			System.out.println("DB���� ����");
			e.printStackTrace();
		}
		//����� connection�����ֱ�
		return connection;
	}
}
