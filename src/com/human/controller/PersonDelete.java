package com.human.controller;

import java.util.ArrayList;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.DBConn;

public class PersonDelete implements PersonExecute {

	@Override
	public void execute() {
		PersonDto request=new PersonDto();
		ArrayList<Integer> response=new ArrayList<Integer>();
		
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}

	@Override
	public void execute(Object request, Object response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);

	}

	@Override
	public void inputView(Object request, Object response) {
		System.out.println("변경할 회원 번호와 이름을 입력하세요");
		System.out.println("no 입력");
		int no=DBConn.inputInt();
		
		PersonDto dto=(PersonDto) request;
		dto.setNo(no);
	}

	@Override
	public void logic(Object request, Object response) {
		PersonDto dto=(PersonDto) request;
		//insert
		PersonDao dao=new PersonDao();
		int i=dao.delete(dto.getNo());
		((ArrayList<Integer>)response).add(new Integer(i));

	}

	@Override
	public void outputView(Object request, Object response) {
		System.out.println(((PersonDto)request).getNo()
				+"번 데이터를 "
				+((ArrayList<Integer>)response).get(0)+"개 삭제하였습니다.");

	}

}
