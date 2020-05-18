package com.human.test;

import java.util.ArrayList;
import java.util.Date;

import com.human.dao.PersonDao;
import com.human.dto.PersonDto;

public class PersonDtoTest {

	public static void main(String[] args) {
		//insert
//		PersonDao dao=new PersonDao();
//		PersonDto dto=new PersonDto();
//		dto.setNo(20);
//		dto.setName("kim");
//		dto.setHeight(111.11);
//		dto.setBirth(new Date());
//		dto.setRegist(new Date());
//		
//		int result=dao.insert(dto);
//		System.out.println(result);
		
		//update
//		PersonDao dao=new PersonDao();
//		dao.update("hong", 20);
		
		//delete
//		PersonDao dao=new PersonDao();
//		int result=dao.delete(20);
//		System.out.println(result);
		
		//select
		PersonDao dao=new PersonDao();
		ArrayList<PersonDto> dtos=dao.select();
		for(PersonDto dto:dtos) {
			System.out.println(dto);
		}
		
		
		
	}

}
