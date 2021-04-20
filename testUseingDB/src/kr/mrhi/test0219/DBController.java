package kr.mrhi.test0219;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBController {
	
	// 기본 출력 함수
	public static ArrayList<ScoreTable> inquiryData(ArrayList<ScoreTable> list) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB와 연결하기.
		String inquiryQuery = "select * from student_score_tbl"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //실행할 구문을 prepareStatement에 준비하기.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement에 실행되어 받아 온 결과 값을 resultSet에 넣어준다.
			
			while(resultSet.next()) { 
				// resultSet에 데이터를 하나씩 찾아가며 값을 가져오기.
				String s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//가져온 데이터를 하나씩 ScoreTable객체에 넣어주기.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
				//데이터를 받은 ScoreTable객체를 ArrayList에 추가하기.
				list.add(scoreTable);
			}//while
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}
		//값이 저장된 ArrayList돌려주기.
		return list;
	}//inquiryData
	
	// 데이터 학번 기준 오름차순으로 출력하는 함수
	public static ArrayList<ScoreTable> inquiryDataOrderByAsc(ArrayList<ScoreTable> list)throws Exception{
		Connection connection = DBUtil.getConnection();//DB와 연결하기.
		String inquiryQuery = "select * from student_score_tbl order by s_num asc"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //실행할 구문을 prepareStatement에 준비하기.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement에 실행되어 받아 온 결과 값을 resultSet에 넣어준다.
			
			while(resultSet.next()) {
				// resultSet에 데이터를 하나씩 찾아가며 값을 가져오기.
				String s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//가져온 데이터를 하나씩 ScoreTable객체에 넣어주기.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
				//데이터를 받은 ScoreTable객체를 ArrayList에 추가하기.
				list.add(scoreTable);
			}//while
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}
		//값이 저장된 ArrayList돌려주기.
		return list;
	}//inquiryDataOrderByAsc
	
	// 데이터 학번 기준 내림차순으로 출력하는 함수
	public static ArrayList<ScoreTable> inquiryDataOrderByDesc(ArrayList<ScoreTable> list) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB와 연결하기.
		String inquiryQuery = "select * from student_score_tbl order by s_num desc"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //실행할 구문을 prepareStatement에 준비하기.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement에 실행되어 받아 온 결과 값을 resultSet에 넣어준다.
			
			while(resultSet.next()) {
				// resultSet에 데이터를 하나씩 찾아가며 값을 가져오기.
				String s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//가져온 데이터를 하나씩 ScoreTable객체에 넣어주기.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
				//데이터를 받은 ScoreTable객체를 ArrayList에 추가하기.
				list.add(scoreTable);
			}//while
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}
		//값이 저장된 ArrayList돌려주기.
		return list;
	}//inquiryDataOrderByDesc
	
	
	// 데이터 추가 저장하는 함수
	public static boolean insertData(ScoreTable scoreTable) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB와 연결하기.
		String insertQuery = "call  pro_student_score_tbl(?,?,?,?,?)"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		boolean flag = false;
		int count = 0;
		
		try {
			prepareStatement = connection.prepareStatement(insertQuery); //실행할 구문을 prepareStatement에 준비하기.
			// 메인의 삽입 함수에서 입력받은 정보를 하나씩 prepareStatement에 넣어주기.
			prepareStatement.setString(1, scoreTable.getS_num());
			prepareStatement.setString(2, scoreTable.getS_name());
			prepareStatement.setInt(3, scoreTable.getS_java());
			prepareStatement.setInt(4, scoreTable.getS_c());
			prepareStatement.setInt(5, scoreTable.getS_sql());
			
			//prepareStatement가 실행된 횟수를 받아온다.
			count = prepareStatement.executeUpdate();
			
			//실행된 횟수가 1일 때 flag를 true 값을 줘서 실행이 됨을 알림.
			if(count == 1) {
				flag = true;
			}else {
				flag = false;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}//finally
		
		return flag;
	}//insertData

	
	// 추가,삭제 할 데이터 찾아오는 함수
	public static ScoreTable checkData(String s_num) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB와 연결하기.
		String inquiryQuery = "select * from student_score_tbl where s_num = ?"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //실행할 구문을 prepareStatement에 준비하기.
			prepareStatement.setString(1, s_num); //입력받은 s_num을 prepareStatement에 저장해주기.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement에 실행되어 받아 온 결과 값을 resultSet에 넣어준다.
			
			while(resultSet.next()) {
				// resultSet에 데이터를 하나씩 찾아가며 값을 가져오기.
				s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//가져온 데이터를 하나씩 ScoreTable객체에 넣어주기.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
			}//while
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}//finally
		
		// 데이터를 받아 저장된 ScoreTable 객체를 돌려주기.
		return scoreTable;
	}//checkData

	
	// 데이터를 삭제하는 함수
	public static boolean deleteData(String s_num) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB와 연결하기.
		String inquiryQuery = "delete from student_score_tbl where s_num = ?"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		boolean flag = false;
		int count = 0;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //실행할 구문을 prepareStatement에 준비하기.
			prepareStatement.setString(1, s_num); //입력받은 s_num을 prepareStatement에 저장해주기.
			count = prepareStatement.executeUpdate(); // prepareStatement가 실행된 횟수를 센다.
			
			//실행된 횟수가 1일 때 flag를 true 값을 줘서 실행이 됨을 알림.
			if(count == 1) {
				flag = true;
			}else {
				flag = false;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}
		return flag;
	}//deleteData

	
	// 데이터를 학번으로 검색해서 찾는 함수
	public static ScoreTable searchNumData(String s_num) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB와 연결하기.
		String inquiryQuery = "select * from student_score_tbl where s_num = ?"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //실행할 구문을 prepareStatement에 준비하기.
			prepareStatement.setString(1, s_num); //입력받은 s_num을 prepareStatement에 저장해주기.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement에 실행되어 받아 온 결과 값을 resultSet에 넣어준다.
			
			while(resultSet.next()) {
				// resultSet에 데이터를 하나씩 찾아가며 값을 가져오기.
				s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//가져온 데이터를 하나씩 ScoreTable객체에 넣어주기.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}
		// 데이터를 받아 저장된 ScoreTable 객체를 돌려주기.
		return scoreTable;
	}//searchNumData

	
	//데이터를 이름으로 검색해서 찾는 함수
	public static ScoreTable searchNameData(String s_name) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB와 연결하기.
		String inquiryQuery = "select * from student_score_tbl where s_name = ?"; // 실행할 구문 정의하기.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //실행할 구문을 prepareStatement에 준비하기.
			prepareStatement.setString(1, s_name); //입력받은 s_num을 prepareStatement에 저장해주기.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement에 실행되어 받아 온 결과 값을 resultSet에 넣어준다.
			
			while(resultSet.next()) {
				// resultSet에 데이터를 하나씩 찾아가며 값을 가져오기.
				String s_num = resultSet.getString(1);
				s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//가져온 데이터를 하나씩 ScoreTable객체에 넣어주기.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement가 DB와 연결되어있을 때 연결을 끊어주기.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection이 DB와 연결되어있을 때 연결을 끊어주기.
				connection.close();
			}
		}//finally
		
		// 데이터를 받아 저장된 ScoreTable 객체를 돌려주기.
		return scoreTable;
	}//searchNameData

}//
