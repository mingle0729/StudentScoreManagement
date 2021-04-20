package kr.mrhi.test0219;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBController {
	
	// �⺻ ��� �Լ�
	public static ArrayList<ScoreTable> inquiryData(ArrayList<ScoreTable> list) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB�� �����ϱ�.
		String inquiryQuery = "select * from student_score_tbl"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement�� ����Ǿ� �޾� �� ��� ���� resultSet�� �־��ش�.
			
			while(resultSet.next()) { 
				// resultSet�� �����͸� �ϳ��� ã�ư��� ���� ��������.
				String s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//������ �����͸� �ϳ��� ScoreTable��ü�� �־��ֱ�.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
				//�����͸� ���� ScoreTable��ü�� ArrayList�� �߰��ϱ�.
				list.add(scoreTable);
			}//while
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}
		//���� ����� ArrayList�����ֱ�.
		return list;
	}//inquiryData
	
	// ������ �й� ���� ������������ ����ϴ� �Լ�
	public static ArrayList<ScoreTable> inquiryDataOrderByAsc(ArrayList<ScoreTable> list)throws Exception{
		Connection connection = DBUtil.getConnection();//DB�� �����ϱ�.
		String inquiryQuery = "select * from student_score_tbl order by s_num asc"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement�� ����Ǿ� �޾� �� ��� ���� resultSet�� �־��ش�.
			
			while(resultSet.next()) {
				// resultSet�� �����͸� �ϳ��� ã�ư��� ���� ��������.
				String s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//������ �����͸� �ϳ��� ScoreTable��ü�� �־��ֱ�.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
				//�����͸� ���� ScoreTable��ü�� ArrayList�� �߰��ϱ�.
				list.add(scoreTable);
			}//while
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}
		//���� ����� ArrayList�����ֱ�.
		return list;
	}//inquiryDataOrderByAsc
	
	// ������ �й� ���� ������������ ����ϴ� �Լ�
	public static ArrayList<ScoreTable> inquiryDataOrderByDesc(ArrayList<ScoreTable> list) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB�� �����ϱ�.
		String inquiryQuery = "select * from student_score_tbl order by s_num desc"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement�� ����Ǿ� �޾� �� ��� ���� resultSet�� �־��ش�.
			
			while(resultSet.next()) {
				// resultSet�� �����͸� �ϳ��� ã�ư��� ���� ��������.
				String s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//������ �����͸� �ϳ��� ScoreTable��ü�� �־��ֱ�.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
				//�����͸� ���� ScoreTable��ü�� ArrayList�� �߰��ϱ�.
				list.add(scoreTable);
			}//while
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}
		//���� ����� ArrayList�����ֱ�.
		return list;
	}//inquiryDataOrderByDesc
	
	
	// ������ �߰� �����ϴ� �Լ�
	public static boolean insertData(ScoreTable scoreTable) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB�� �����ϱ�.
		String insertQuery = "call  pro_student_score_tbl(?,?,?,?,?)"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		boolean flag = false;
		int count = 0;
		
		try {
			prepareStatement = connection.prepareStatement(insertQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			// ������ ���� �Լ����� �Է¹��� ������ �ϳ��� prepareStatement�� �־��ֱ�.
			prepareStatement.setString(1, scoreTable.getS_num());
			prepareStatement.setString(2, scoreTable.getS_name());
			prepareStatement.setInt(3, scoreTable.getS_java());
			prepareStatement.setInt(4, scoreTable.getS_c());
			prepareStatement.setInt(5, scoreTable.getS_sql());
			
			//prepareStatement�� ����� Ƚ���� �޾ƿ´�.
			count = prepareStatement.executeUpdate();
			
			//����� Ƚ���� 1�� �� flag�� true ���� �༭ ������ ���� �˸�.
			if(count == 1) {
				flag = true;
			}else {
				flag = false;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}//finally
		
		return flag;
	}//insertData

	
	// �߰�,���� �� ������ ã�ƿ��� �Լ�
	public static ScoreTable checkData(String s_num) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB�� �����ϱ�.
		String inquiryQuery = "select * from student_score_tbl where s_num = ?"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			prepareStatement.setString(1, s_num); //�Է¹��� s_num�� prepareStatement�� �������ֱ�.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement�� ����Ǿ� �޾� �� ��� ���� resultSet�� �־��ش�.
			
			while(resultSet.next()) {
				// resultSet�� �����͸� �ϳ��� ã�ư��� ���� ��������.
				s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//������ �����͸� �ϳ��� ScoreTable��ü�� �־��ֱ�.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
			}//while
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}//finally
		
		// �����͸� �޾� ����� ScoreTable ��ü�� �����ֱ�.
		return scoreTable;
	}//checkData

	
	// �����͸� �����ϴ� �Լ�
	public static boolean deleteData(String s_num) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB�� �����ϱ�.
		String inquiryQuery = "delete from student_score_tbl where s_num = ?"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		boolean flag = false;
		int count = 0;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			prepareStatement.setString(1, s_num); //�Է¹��� s_num�� prepareStatement�� �������ֱ�.
			count = prepareStatement.executeUpdate(); // prepareStatement�� ����� Ƚ���� ����.
			
			//����� Ƚ���� 1�� �� flag�� true ���� �༭ ������ ���� �˸�.
			if(count == 1) {
				flag = true;
			}else {
				flag = false;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}
		return flag;
	}//deleteData

	
	// �����͸� �й����� �˻��ؼ� ã�� �Լ�
	public static ScoreTable searchNumData(String s_num) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB�� �����ϱ�.
		String inquiryQuery = "select * from student_score_tbl where s_num = ?"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			prepareStatement.setString(1, s_num); //�Է¹��� s_num�� prepareStatement�� �������ֱ�.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement�� ����Ǿ� �޾� �� ��� ���� resultSet�� �־��ش�.
			
			while(resultSet.next()) {
				// resultSet�� �����͸� �ϳ��� ã�ư��� ���� ��������.
				s_num = resultSet.getString(1);
				String s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//������ �����͸� �ϳ��� ScoreTable��ü�� �־��ֱ�.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}
		// �����͸� �޾� ����� ScoreTable ��ü�� �����ֱ�.
		return scoreTable;
	}//searchNumData

	
	//�����͸� �̸����� �˻��ؼ� ã�� �Լ�
	public static ScoreTable searchNameData(String s_name) throws SQLException {
		Connection connection = DBUtil.getConnection(); //DB�� �����ϱ�.
		String inquiryQuery = "select * from student_score_tbl where s_name = ?"; // ������ ���� �����ϱ�.
		PreparedStatement prepareStatement = null;
		ScoreTable scoreTable = null;
		
		try {
			prepareStatement = connection.prepareStatement(inquiryQuery); //������ ������ prepareStatement�� �غ��ϱ�.
			prepareStatement.setString(1, s_name); //�Է¹��� s_num�� prepareStatement�� �������ֱ�.
			ResultSet resultSet = prepareStatement.executeQuery(); // prepareStatement�� ����Ǿ� �޾� �� ��� ���� resultSet�� �־��ش�.
			
			while(resultSet.next()) {
				// resultSet�� �����͸� �ϳ��� ã�ư��� ���� ��������.
				String s_num = resultSet.getString(1);
				s_name = resultSet.getString(2);
				int s_java = resultSet.getInt(3);
				int s_c = resultSet.getInt(4);
				int s_sql = resultSet.getInt(5);
				int s_total = resultSet.getInt(6);
				double s_avg = resultSet.getDouble(7);
				String s_grade = resultSet.getString(8);
				
				//������ �����͸� �ϳ��� ScoreTable��ü�� �־��ֱ�.
				scoreTable = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, s_total, s_avg, s_grade);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepareStatement!=null) {
				//prepareStatement�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				prepareStatement.close();
			}
			if(connection!=null) {
				//connection�� DB�� ����Ǿ����� �� ������ �����ֱ�.
				connection.close();
			}
		}//finally
		
		// �����͸� �޾� ����� ScoreTable ��ü�� �����ֱ�.
		return scoreTable;
	}//searchNameData

}//
