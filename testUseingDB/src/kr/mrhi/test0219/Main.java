package kr.mrhi.test0219;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Connection;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static final int INQUIRY = 1,ENTRY = 2, DELETION = 3, SEARCH = 4, MODIFY=5, CLOSE = 6, SEARCH_NUM =1, SEARCH_NAME = 2, SEARCH_END = 3,
			PRINT = 1, PRINT_ASC = 2, PRINT_DESC = 3, PRINT_END = 4;
	
	public static void main(String[]agrs) {
		boolean isExit = false;
		int number = 0;
		
		while(!isExit) { // �޴� ���� while��
			System.out.print("\n********************************************************\n"
					+ "1.������ ��ȸ 2.������ �Է� 3.������ ���� 4.������ �˻� 5.������ ���� 6.���α׷� ����\n"
					+ "********************************************************\n"
					+ "����: ");
			try {
				number = Integer.parseInt(sc.nextLine()); // (���ۿ���)�޴� ����
				
			} catch (InputMismatchException e) {
				System.out.println("���� �Է� ���.");
				sc.next();
				continue;
			} catch (Exception e) {
				System.out.println("�ٽ� �Է� ���.");
				sc.next();
				continue;
			}
			switch (number) {
			case INQUIRY: inquiryData(); break; // ������ ��ȸ�ϱ� 
			case ENTRY: addData(); break; //������ �߰� �����ϱ�
			case DELETION: deleteData(); break; //������ �����ϱ�
			case SEARCH: searchData(); break; // ������ �˻��ϱ�
			case MODIFY: madifyData(); break; // ������ �����ϱ�
			case CLOSE: isExit = true; break; // while�� ���������� 
			default: System.out.println("�ٽ� �Է� ���."); break; 
			}//switch
		}//while
		System.out.println("�����մϴ� :) ");
	}//main
	
	
	private static void madifyData() {
		System.out.println();
		
	}


	// ������ �˻��ϴ� �Լ�
	public static void searchData() {
		ScoreTable scoreTable = null;
		boolean isExit = false, resultValue = false;
		int number =0;
		
		while(!isExit) { // �˻� ��� �����ϱ�
			System.out.print("----------------------\n"
					+ "1.��ȣ�˻� 2.�̸��˻� 3.����\n"
					+ "----------------------\n"
					+ "����: ");
			try {
				number = Integer.parseInt(sc.nextLine()); // (���ۿ���)�˻� ��� ����
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է����ּ���");
				sc.next();
				continue;
			}
			switch (number) {
			case SEARCH_NUM: //�й����� �˻�
				System.out.println("�˻��� �л� �й��� �Է��ϼ���: ");
				String s_num = sc.next();
				if(s_num.length()!=9) {// �й� 9�ڸ��� �������� ��� �ٽ� �Է¹ޱ�
					System.out.println("�й� 9�ڸ��� ���ڷ� �Է����ּ���");
					continue;
				}
				try {
					scoreTable = DBController.searchNumData(s_num); // DBControllerŬ������ �����ؼ� �ش絥���� ã��
					if(scoreTable!=null) {
						System.out.println(scoreTable.toString()); // �л� ������ ���� �� ���
					}else {
						System.out.println("�ش� �л������� �����ϴ�."); // �л� ������ ���� �� �ȳ� ����
					}//if
				} catch (Exception e) {
					e.printStackTrace();
				}	
				break;
				
			case SEARCH_NAME: // �̸����� �˻�
				System.out.println("�˻��� �л� �̸��� �Է��ϼ���: "); // �̸� �Է¹ޱ�
				String s_name = sc.next();
				try {
					scoreTable = DBController.searchNameData(s_name); // DBControllerŬ������ �����ؼ� �ش絥���� ã��
					if(scoreTable!=null) {
						System.out.println(scoreTable.toString());// �л� ������ ���� �� ���
					}else {
						System.out.println("�ش� �л������� �����ϴ�."); // �л� ������ ���� �� �ȳ� ����
					}//if
				} catch (Exception e) {
					e.printStackTrace();
				}	
				break;
				
			case SEARCH_END: isExit = true;  break; //while�� ������

			default:
				System.out.println("�ٽ� �Է����ּ���.");
				break;
			}//switch
		}//while
	}//searchData

	//������ �����ϴ� �Լ�
	public static void deleteData() {
		ScoreTable scoreTable = null;
		boolean resultValue = false;
		boolean isExit = false;
		String s_num = null;
		while(!isExit) {
			System.out.print("������ �л� �й��� �Է��ϼ���: "); // ������ ���� �Է¹ޱ� 
			s_num = sc.next();
			if(s_num.length()!=9) { // �й� 9�ڸ��� �������� ��� �ٽ� �Է¹ޱ�
				System.out.println("�й� 9�ڸ��� ���ڷ� �Է����ּ���");
				continue;
			}
			try {
				scoreTable = DBController.checkData(s_num); // DBControllerŬ������ �����ؼ� ���� �޾ƿ���
				if(scoreTable!=null &&s_num.equals(scoreTable.getS_num())) { 
					resultValue = DBController.deleteData(s_num);  // �޾ƿ� ������ NULL���� �ƴϰ� �Ȱ��� ������ ���� ��, DBController�����ؼ� ���� �����ϱ� 
				}else {
					System.out.println("�ش� �л� ������ ���� �����Դϴ�."); //�޾ƿ� ������ �����Ͱ� ���� �� �ȳ� ���� ���
					continue;
				}//if
			} catch (SQLException e) {
				e.printStackTrace();
			}//catch
				
			if(resultValue== true) {
				System.out.println("**�������� ����**"); // DBController���� ������ ������ �Ǿ��� �� �ȳ����� ���
			}else {
				System.out.println("������ �����Ͽ����ϴ�."); // DBController���� ������ ������ �����ʾ��� �� �ȳ����� ���
			}//if
			isExit = true; // while�� ����������
		}//while
	}//deleteData
	
	
	// ������ �߰� �Է��ϴ� �Լ�
	public static void addData() {
		ScoreTable scoreTable = null, st = null;
		boolean isExit = false, resultValue = false , flag = false;
		int s_java=0,s_c=0,s_sql=0;
		
		while(!isExit) {
			System.out.print("�߰��� �л� �й��� �Է��ϼ���: "); // �߰��� �л� ���� �Է¹ޱ�
			String s_num = sc.next();
			if(s_num.length()!=9) {// �й� 9�ڸ��� �������� ��� �ٽ� �Է¹ޱ�
				System.out.println("�й� 9�ڸ��� ���ڷ� �Է����ּ���");
				continue;
			}
			try {
				scoreTable = DBController.checkData(s_num); // �ߺ��˻縦 ���� DBController �����ؼ� ���� �ڷ�޾ƿ��� 
				if(scoreTable!=null&&s_num.equals(scoreTable.getS_num())) {
					System.out.println("�̹� �����ϴ� �л��Դϴ�.");// �޾ƿ� ������ �����Ͱ��� null���� �ƴϰ� �ߺ��� ���� ���� �� �ȳ������� ���.
					continue; // �ٽ� �л� ���� �Է¹ޱ����� ���ư���
				}else {
					//�߰��� �л� ���� ���
					System.out.print("�߰��� �л� �̸��� �Է��ϼ���: ");
					String s_name = sc.next();
						System.out.print("�߰��� �л� JAVA������ �Է��ϼ���: ");
						s_java = correctScore();//���� ������ �°� �Է¹޴� �Լ��� s_java�� ����
				
						System.out.print("�߰��� �л� C��������� �Է��ϼ���: ");
						s_c = correctScore();//���� ������ �°� �Է¹޴� �Լ��� s_c�� ����
					
						System.out.print("�߰��� �л� SQL������ �Է��ϼ���: ");
						s_sql = correctScore();//���� ������ �°� �Է¹޴� �Լ��� s_sql�� ����
					
					st = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, 0, 0.0, null); //���� �л� ���� �� ScoreTable��ü�� �����ϱ�
				}//if
				
				resultValue = DBController.insertData(st);  // DBControllerŬ������ �����ؼ� total,avg,grade�� ��� �� DB�� �����ϱ�
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(resultValue == true) {
				System.out.println("**�������� ����**");// ������ ����� ���� �� �ȳ� ���� ���
			}else {
				System.out.println("���Կ� �����Ͽ����ϴ�."); // ������ ����� ���� ������ �� �ȳ� ���� ���
			}//if
			
			isExit = true;// while of is Exist�� �����.
		}//while of isExit
	}//addData
	
	//�����Է� �޴� �Լ� ������ �°� �Է¹ޱ�
	public static int correctScore() {
		int s_score = 0;
		while(true) {
			s_score = Integer.parseInt(sc.nextLine()); //(���۹��� ����) ������ ���� �Է¹ޱ�
			
			//�Է¹��� ������ 100���� �Ѱų� 0�� �̸��� �� �ٽ� �Է��� �ޱ�.
			if(s_score>100 || s_score<0) {
				System.out.println("������ 0��~100���� ������ �°� �ٽ� �Է����ּ���.");
				continue;
			}
			break;
		}
		//����� ���� ���� �����ش�.
		return s_score;
	}//correctScore


	// ����� ������ ��ȸ�ϴ� �Լ�
	public static void inquiryData() {
		ArrayList<ScoreTable> list = new ArrayList<ScoreTable>();
		boolean isExit = false;
		int number = 0;
		
		while(!isExit) { // ��¹�� �����ϱ�
			System.out.print("\n-----------------------------------------\n"
					+ "1.�⺻ ��� 2.�������� ��� 3.�������� ��� 4.����\n"
					+ "-----------------------------------------\n"
					+ "����: ");
			try {
				number = sc.nextInt(); // ���ڰ� �ƴ� ����,Ư������ ���� �Է��Ͽ��� �� ���� �����ϱ�
				
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է����ּ���");
				sc.next();
				continue;
			}
			
			switch (number) {
			case PRINT: // �⺻ ����ϱ�
				
				try {
					list = DBController.inquiryData(list); // DBControllerŬ������ �����ؼ� ������ �޾ƿ���
				}catch (Exception e) {e.printStackTrace();}
				
				if(list.size() != 0) { 
					// �޾ƿ� �����Ϳ� ���� ���� �� �ϳ��� ����ϱ�.
					for(int i =0; i <list.size();i++) { 
						System.out.println(list.get(i).toString());
					}//for
					list.clear(); // list���� ���������ʰ� �ʱ�ȭ���ֱ�.
				}else {
					// �޾ƿ� �����Ϳ� ���� ���� �� �ȳ����� ����ϱ�.
					System.out.println("����� �л� ������ �����ϴ�.");
				}//if
				
				break;
				
			case PRINT_ASC: // ������������ ����ϱ� 
				try {
					list = DBController.inquiryDataOrderByAsc(list);  // DBControllerŬ������ �����ؼ� ������������ ���ĵ� ���� �޾ƿ���
				}catch (Exception e) {e.printStackTrace();}
				
				if(list.size() != 0) { 
					// �޾ƿ� �����Ϳ� ���� ���� �� �ϳ��� ����ϱ�.
					for(int i =0; i <list.size();i++) {
						System.out.println(list.get(i).toString());
					}//for
					list.clear(); //list ���� ���������ʰ� �ʱ�ȭ���ֱ�.
				}else {
					// �޾ƿ� �����Ϳ� ���� ���� �� �ȳ����� ����ϱ�.
					System.out.println("����� �л� ������ �����ϴ�.\n");
				}//if
				break;
				
			case PRINT_DESC:
				try {
					list = DBController.inquiryDataOrderByDesc(list);  // DBControllerŬ������ �����ؼ� ������������ ���ĵ� ���� �޾ƿ���.
				}catch (Exception e) {e.printStackTrace();}
				if(list.size() != 0) {
					// �޾ƿ� �����Ϳ� ���� ���� �� �ϳ��� ����ϱ�.
					for(int i =0; i <list.size();i++) {
						System.out.println(list.get(i).toString());
					}//for
					list.clear();  //list ���� ���������ʰ� �ʱ�ȭ���ֱ�.
				}else {
					// �޾ƿ� �����Ϳ� ���� ���� �� �ȳ����� ����ϱ�.
					System.out.println("����� �л� ������ �����ϴ�.\n");
				}//if
				break;
				
			case PRINT_END: isExit = true;  break; // while�� ����������.

			default:
				System.out.println("�ٽ� �Է����ּ���.\n"); //�߸��Է½� �ȳ����� ������ֱ�.
				break;
			}//switch
		}//while
	}//inquiryData
}

