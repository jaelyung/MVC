package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class PersonInsert implements PersonExecute {
	@Override
	public void execute() {
		PersonDto request=new PersonDto();
		ArrayList<Integer> response=new ArrayList<Integer>();
		
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}
	@Override
	public void execute(Request request, Response response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}
	@Override
	public void inputView(Request request, Response response) {
		System.out.println("회원정보를 입력하세요");
		System.out.println("no 입력");
		int no=DBConn.inputInt();
		
		System.out.println("name 입력");
		String name=DBConn.inputString();
		
		System.out.println("height 입력");
		Double height=DBConn.inputDouble();
		
		System.out.println("birth 입력");
		Date birth=DBConn.inputDate();
		
		System.out.println("regist 입력");
		Date regist=DBConn.inputDate();
		
		PersonDto dto=new PersonDto();
		
		//new로 생성하면 안됨
		dto.setNo(no);
		dto.setName(name);
		dto.setHeight(height);
		dto.setBirth(birth);
		dto.setRegist(regist);
		
		request.setPersonDto(dto);
	}
	@Override
	public void logic(Request request, Response response) {
		
		PersonDto dto=request.getPersonDto();
		//insert
		PersonDao dao=new PersonDao();
		int i=dao.insert(dto);
//		ArrayList<Integer> r=(ArrayList<Integer>)response;
//		r.add(new Integer(i));
		
		response.setResultValue(i);
		
	}
	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue());
	}
	
	public void execute(Object request, Object response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}
	
	public void inputView(Object request, Object response) {
		System.out.println("회원정보를 입력하세요");
		System.out.println("no 입력");
		int no=DBConn.inputInt();
		
		System.out.println("name 입력");
		String name=DBConn.inputString();
		
		System.out.println("height 입력");
		Double height=DBConn.inputDouble();
		
		System.out.println("birth 입력");
		Date birth=DBConn.inputDate();
		
		System.out.println("regist 입력");
		Date regist=DBConn.inputDate();
		
		PersonDto dto=(PersonDto) request;
		//new로 생성하면 안됨
		dto.setNo(no);
		dto.setName(name);
		dto.setHeight(height);
		dto.setBirth(birth);
		dto.setRegist(regist);
	}
	
	public void logic(Object request, Object response) {
		PersonDto dto=(PersonDto) request;
		//insert
		PersonDao dao=new PersonDao();
		int i=dao.insert(dto);
//		ArrayList<Integer> r=(ArrayList<Integer>)response;
//		r.add(new Integer(i));
		
		((ArrayList<Integer>)response).add(new Integer(i));
		//((Integer) response)=dao.insert(dto);
		
	}
	
	public void outputView(Object request, Object response) {
		System.out.println(((ArrayList<Integer>)response).get(0));
	}
}
