package com.human.controller;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;
import com.human.util.Request;
import com.human.util.Response;

public class PersonUpdate implements PersonExecute {
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
		System.out.println("변경할 회원 번호와 이름을 입력하세요");
		System.out.println("no 입력");
		int no=DBConn.inputInt();
		
		System.out.println("name 입력");
		String name=DBConn.inputString();
		PersonDto dto=new PersonDto();
		
		dto.setNo(no);
		dto.setName(name);
		
		request.setPersonDto(dto);
	}

	@Override
	public void logic(Request request, Response response) {
		PersonDto dto=request.getPersonDto();
		//insert
		PersonDao dao=new PersonDao();
		int i=dao.update(dto.getName(), dto.getNo());
		response.setResultValue(i);
	}

	@Override
	public void outputView(Request request, Response response) {
	
		System.out.println(request.getPersonDto().getNo()
				+"번 데이터의 이름을 "
				+request.getPersonDto().getName()+"으로 "
				+response.getResultValue()+"개 변경하였습니다.");

	}

	
	public void execute(Object request, Object response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	
	public void inputView(Object request, Object response) {
		System.out.println("변경할 회원 번호와 이름을 입력하세요");
		System.out.println("no 입력");
		int no=DBConn.inputInt();
		
		System.out.println("name 입력");
		String name=DBConn.inputString();
		
		PersonDto dto=(PersonDto) request;
		dto.setNo(no);
		dto.setName(name);
		
	}

	
	public void logic(Object request, Object response) {
		PersonDto dto=(PersonDto) request;
		//insert
		PersonDao dao=new PersonDao();
		int i=dao.update(dto.getName(), dto.getNo());
		((ArrayList<Integer>)response).add(new Integer(i));
	}

	
	public void outputView(Object request, Object response) {
		System.out.println(((PersonDto)request).getNo()
				+"번 데이터의 이름을 "
				+((PersonDto)request).getName()+"으로 "
				+((ArrayList<Integer>)response).get(0)+"개 변경하였습니다.");

	}
}
