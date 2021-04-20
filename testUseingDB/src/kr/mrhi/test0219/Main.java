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
		
		while(!isExit) { // 메뉴 선택 while문
			System.out.print("\n********************************************************\n"
					+ "1.데이터 조회 2.데이터 입력 3.데이터 삭제 4.데이터 검색 5.데이터 수정 6.프로그램 종료\n"
					+ "********************************************************\n"
					+ "선택: ");
			try {
				number = Integer.parseInt(sc.nextLine()); // (버퍼예방)메뉴 선택
				
			} catch (InputMismatchException e) {
				System.out.println("숫자 입력 요망.");
				sc.next();
				continue;
			} catch (Exception e) {
				System.out.println("다시 입력 요망.");
				sc.next();
				continue;
			}
			switch (number) {
			case INQUIRY: inquiryData(); break; // 데이터 조회하기 
			case ENTRY: addData(); break; //데이터 추가 저장하기
			case DELETION: deleteData(); break; //데이터 삭제하기
			case SEARCH: searchData(); break; // 데이터 검색하기
			case MODIFY: madifyData(); break; // 데이터 수정하기
			case CLOSE: isExit = true; break; // while문 빠져나가기 
			default: System.out.println("다시 입력 요망."); break; 
			}//switch
		}//while
		System.out.println("감사합니다 :) ");
	}//main
	
	
	private static void madifyData() {
		System.out.println();
		
	}


	// 데이터 검색하는 함수
	public static void searchData() {
		ScoreTable scoreTable = null;
		boolean isExit = false, resultValue = false;
		int number =0;
		
		while(!isExit) { // 검색 방법 선택하기
			System.out.print("----------------------\n"
					+ "1.번호검색 2.이름검색 3.종료\n"
					+ "----------------------\n"
					+ "선택: ");
			try {
				number = Integer.parseInt(sc.nextLine()); // (버퍼예방)검색 방법 선택
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요");
				sc.next();
				continue;
			}
			switch (number) {
			case SEARCH_NUM: //학번으로 검색
				System.out.println("검색할 학생 학번을 입력하세요: ");
				String s_num = sc.next();
				if(s_num.length()!=9) {// 학번 9자리가 맞지않을 경우 다시 입력받기
					System.out.println("학번 9자리를 숫자로 입력해주세요");
					continue;
				}
				try {
					scoreTable = DBController.searchNumData(s_num); // DBController클래스와 연결해서 해당데이터 찾기
					if(scoreTable!=null) {
						System.out.println(scoreTable.toString()); // 학생 정보가 있을 때 출력
					}else {
						System.out.println("해당 학생정보가 없습니다."); // 학생 정보가 없을 때 안내 구문
					}//if
				} catch (Exception e) {
					e.printStackTrace();
				}	
				break;
				
			case SEARCH_NAME: // 이름으로 검색
				System.out.println("검색할 학생 이름을 입력하세요: "); // 이름 입력받기
				String s_name = sc.next();
				try {
					scoreTable = DBController.searchNameData(s_name); // DBController클래스와 연결해서 해당데이터 찾기
					if(scoreTable!=null) {
						System.out.println(scoreTable.toString());// 학생 정보가 있을 때 출력
					}else {
						System.out.println("해당 학생정보가 없습니다."); // 학생 정보가 없을 때 안내 구문
					}//if
				} catch (Exception e) {
					e.printStackTrace();
				}	
				break;
				
			case SEARCH_END: isExit = true;  break; //while문 나가기

			default:
				System.out.println("다시 입력해주세요.");
				break;
			}//switch
		}//while
	}//searchData

	//데이터 삭제하는 함수
	public static void deleteData() {
		ScoreTable scoreTable = null;
		boolean resultValue = false;
		boolean isExit = false;
		String s_num = null;
		while(!isExit) {
			System.out.print("삭제할 학생 학번을 입력하세요: "); // 삭제할 정보 입력받기 
			s_num = sc.next();
			if(s_num.length()!=9) { // 학번 9자리가 맞지않을 경우 다시 입력받기
				System.out.println("학번 9자리를 숫자로 입력해주세요");
				continue;
			}
			try {
				scoreTable = DBController.checkData(s_num); // DBController클래스와 연결해서 정보 받아오기
				if(scoreTable!=null &&s_num.equals(scoreTable.getS_num())) { 
					resultValue = DBController.deleteData(s_num);  // 받아온 정보가 NULL값이 아니고 똑같은 정보가 있을 때, DBController연결해서 정보 삭제하기 
				}else {
					System.out.println("해당 학생 정보는 없는 정보입니다."); //받아온 정보에 데이터가 없을 때 안내 구문 출력
					continue;
				}//if
			} catch (SQLException e) {
				e.printStackTrace();
			}//catch
				
			if(resultValue== true) {
				System.out.println("**정상적인 삭제**"); // DBController에서 삭제가 진행이 되었을 때 안내구문 출력
			}else {
				System.out.println("삭제에 실패하였습니다."); // DBController에서 삭제가 진행이 되지않았을 때 안내구문 출력
			}//if
			isExit = true; // while문 빠져나가기
		}//while
	}//deleteData
	
	
	// 데이터 추가 입력하는 함수
	public static void addData() {
		ScoreTable scoreTable = null, st = null;
		boolean isExit = false, resultValue = false , flag = false;
		int s_java=0,s_c=0,s_sql=0;
		
		while(!isExit) {
			System.out.print("추가할 학생 학번을 입력하세요: "); // 추가할 학생 정보 입력받기
			String s_num = sc.next();
			if(s_num.length()!=9) {// 학번 9자리가 맞지않을 경우 다시 입력받기
				System.out.println("학번 9자리를 숫자로 입력해주세요");
				continue;
			}
			try {
				scoreTable = DBController.checkData(s_num); // 중복검사를 위해 DBController 연결해서 기존 자료받아오기 
				if(scoreTable!=null&&s_num.equals(scoreTable.getS_num())) {
					System.out.println("이미 존재하는 학생입니다.");// 받아온 정보의 데이터값이 null값이 아니고 중복된 값이 있을 때 안내구문을 출력.
					continue; // 다시 학생 정보 입력받기위해 돌아가기
				}else {
					//추가될 학생 정보 얻기
					System.out.print("추가할 학생 이름을 입력하세요: ");
					String s_name = sc.next();
						System.out.print("추가할 학생 JAVA점수를 입력하세요: ");
						s_java = correctScore();//점수 범위에 맞게 입력받는 함수를 s_java로 받음
				
						System.out.print("추가할 학생 C언어점수를 입력하세요: ");
						s_c = correctScore();//점수 범위에 맞게 입력받는 함수를 s_c로 받음
					
						System.out.print("추가할 학생 SQL점수를 입력하세요: ");
						s_sql = correctScore();//점수 범위에 맞게 입력받는 함수를 s_sql로 받음
					
					st = new ScoreTable(s_num, s_name, s_java, s_c, s_sql, 0, 0.0, null); //받은 학생 정보 값 ScoreTable객체에 저장하기
				}//if
				
				resultValue = DBController.insertData(st);  // DBController클래스와 연결해서 total,avg,grade값 계산 후 DB에 삽입하기
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(resultValue == true) {
				System.out.println("**정상적인 삽입**");// 정보가 제대로 들어갔을 때 안내 구문 출력
			}else {
				System.out.println("삽입에 실패하였습니다."); // 정보가 제대로 들어가지 못했을 때 안내 구문 출력
			}//if
			
			isExit = true;// while of is Exist문 벗어나기.
		}//while of isExit
	}//addData
	
	//점수입력 받는 함수 범위에 맞게 입력받기
	public static int correctScore() {
		int s_score = 0;
		while(true) {
			s_score = Integer.parseInt(sc.nextLine()); //(버퍼문제 예방) 정수로 점수 입력받기
			
			//입력받은 점수가 100점이 넘거나 0점 미만일 때 다시 입력을 받기.
			if(s_score>100 || s_score<0) {
				System.out.println("점수는 0점~100점의 범위에 맞게 다시 입력해주세요.");
				continue;
			}
			break;
		}
		//제대로 얻은 값을 돌려준다.
		return s_score;
	}//correctScore


	// 저장된 데이터 조회하는 함수
	public static void inquiryData() {
		ArrayList<ScoreTable> list = new ArrayList<ScoreTable>();
		boolean isExit = false;
		int number = 0;
		
		while(!isExit) { // 출력방식 선택하기
			System.out.print("\n-----------------------------------------\n"
					+ "1.기본 출력 2.오름차순 출력 3.내림차순 출력 4.종료\n"
					+ "-----------------------------------------\n"
					+ "선택: ");
			try {
				number = sc.nextInt(); // 숫자가 아닌 문자,특수문자 등을 입력하였을 때 오류 방지하기
				
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요");
				sc.next();
				continue;
			}
			
			switch (number) {
			case PRINT: // 기본 출력하기
				
				try {
					list = DBController.inquiryData(list); // DBController클래스와 연결해서 데이터 받아오기
				}catch (Exception e) {e.printStackTrace();}
				
				if(list.size() != 0) { 
					// 받아온 데이터에 값이 있을 때 하나씩 출력하기.
					for(int i =0; i <list.size();i++) { 
						System.out.println(list.get(i).toString());
					}//for
					list.clear(); // list값이 누적되지않게 초기화해주기.
				}else {
					// 받아온 데이터에 값이 없을 때 안내구문 출력하기.
					System.out.println("출력할 학생 정보가 없습니다.");
				}//if
				
				break;
				
			case PRINT_ASC: // 오름차순으로 출력하기 
				try {
					list = DBController.inquiryDataOrderByAsc(list);  // DBController클래스와 연결해서 오름차순으로 정렬된 정보 받아오기
				}catch (Exception e) {e.printStackTrace();}
				
				if(list.size() != 0) { 
					// 받아온 데이터에 값이 있을 때 하나씩 출력하기.
					for(int i =0; i <list.size();i++) {
						System.out.println(list.get(i).toString());
					}//for
					list.clear(); //list 값이 누적되지않게 초기화해주기.
				}else {
					// 받아온 데이터에 값이 없을 때 안내구문 출력하기.
					System.out.println("출력할 학생 정보가 없습니다.\n");
				}//if
				break;
				
			case PRINT_DESC:
				try {
					list = DBController.inquiryDataOrderByDesc(list);  // DBController클래스와 연결해서 내림차순으로 정렬된 정보 받아오기.
				}catch (Exception e) {e.printStackTrace();}
				if(list.size() != 0) {
					// 받아온 데이터에 값이 있을 때 하나씩 출력하기.
					for(int i =0; i <list.size();i++) {
						System.out.println(list.get(i).toString());
					}//for
					list.clear();  //list 값이 누적되지않게 초기화해주기.
				}else {
					// 받아온 데이터에 값이 없을 때 안내구문 출력하기.
					System.out.println("출력할 학생 정보가 없습니다.\n");
				}//if
				break;
				
			case PRINT_END: isExit = true;  break; // while문 빠져나가기.

			default:
				System.out.println("다시 입력해주세요.\n"); //잘못입력시 안내구문 출력해주기.
				break;
			}//switch
		}//while
	}//inquiryData
}

