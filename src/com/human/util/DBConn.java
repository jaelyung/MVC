package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DBConn {
	//.getInstance()
	//new DBConn(); 작업을 하지 못하게, 객체를 한번만 생성할 수 있게하기
	private DBConn() {} //외부에서 생성 불가능 내부에서 한번만 생성하게 함
	private static Connection dbConn=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	private static Scanner sc=new Scanner(System.in);
	
	public static ResultSet statementQuery(String sql) {
		try {
			if(st==null) {
				st=dbConn.createStatement();
			}
			//4.ResultSet 얻어오기 (요청한 실행결과물)
			rs=st.executeQuery(sql);			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int statementUpdate(String sql) {
		int resultValue=0;
		
		//dbConn=DBConn.getInstance();
//		DBConn.getInstance();
		try {
			if(st==null) {
				st=dbConn.createStatement();
			}
			//프로그램에서는 auto commit 기본값
			resultValue=st.executeUpdate(sql);
//			if(n==1) {//n은 변경된 개수
//				System.out.println("정상동작");
//			}else {
//				System.out.println("비정상동작");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			DBConn.dbClose();
		}
		return resultValue;
	}
	//insert, select ...  DB를 반복적으로 열고 닫는 작업을 코드로 작성
	public static Connection getInstance() {
		if(dbConn==null) {//객체가 아예 없으면
			try {
				//1.사용할 데이터베이스  드라이브 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩완료");
				//2.해당 데이터베이스에 접속 url, user, pw
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="human";
				String pw="human";
				dbConn=DriverManager.getConnection(url, user, pw);
				System.out.println("데이터베이스 접속성공");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();//Statement를 먼저 닫는다
			if(dbConn!=null) dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs=null;
			st=null;
			dbConn=null;
		}
	}
	
	public static int inputInt() {
		System.out.print("정수입력>>");
		return Integer.parseInt(sc.nextLine());		
	}
	public static double inputDouble() {
		System.out.print("실수입력>>");
		return Double.parseDouble(sc.nextLine());
	}
	public static String inputString() {
		System.out.print("문자열입력>>");
		return sc.nextLine();
	}
	public static Date inputDate() {//입력받은 문자열을 시간으로 변경
		Date returnValue=null;
		SimpleDateFormat transFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.print("날짜입력(yyyy-mm-dd hh24:mi:ss)>>");
		String inputString=sc.nextLine();
		
		try {
			returnValue=transFormat.parse(inputString);//문자열을 시간객체로 변경
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public static String dateToString(Date d) {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(d);
	}
	
	
	
	
	
}
