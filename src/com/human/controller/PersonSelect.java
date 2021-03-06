package com.human.controller;

import java.util.ArrayList;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;
import com.human.util.Request;
import com.human.util.Response;

public class PersonSelect implements PersonExecute {

	@Override
	public void execute() {
		PersonDto request=new PersonDto();
		ArrayList<PersonDto> response=new ArrayList<PersonDto>();
		
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
		System.out.println("모든 회원을 출력할 예정입니다.");
		//입력값 없음
	}

	@Override
	public void logic(Request request, Response response) {
		PersonDao dao=new PersonDao();
		response.setArrPersonDto(dao.select());
//		for(PersonDto dto:dao.select()) {
//			((ArrayList<PersonDto>)response).add(dto);
//		}
		//response=dao.select();

	}

	@Override
	public void outputView(Request request, Response response) {
		// TODO Auto-generated method stub
		if(response!=null) {
			ArrayList<PersonDto> dtos=response.getArrPersonDto();
			System.out.println("회원정보는 다음과 같습니다.");
			for(PersonDto dto:dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("회원이 없습니다.");
		}
	}

	

	public void execute(Object request, Object response) {
		inputView(request, response);
		logic(request, response);
		outputView(request, response);
	}


	public void inputView(Object request, Object response) {
		System.out.println("모든 회원을 출력할 예정입니다.");
		//입력값 없음
	}

	public void logic(Object request, Object response) {
		PersonDao dao=new PersonDao();
		
		for(PersonDto dto:dao.select()) {
			((ArrayList<PersonDto>)response).add(dto);
		}
		//response=dao.select();

	}


	public void outputView(Object request, Object response) {
		// TODO Auto-generated method stub
		if(response!=null) {
			ArrayList<PersonDto> dtos=(ArrayList<PersonDto>)response;
			System.out.println("회원정보는 다음과 같습니다.");
			for(PersonDto dto:dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("회원이 없습니다.");
		}
	}

}
