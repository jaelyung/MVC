package com.human.test;

import java.util.ArrayList;

import com.human.controller.PersonDelete;
import com.human.controller.PersonExecute;
import com.human.controller.PersonInsert;
import com.human.controller.PersonSelect;
import com.human.controller.PersonUpdate;
import com.human.dto.PersonDto;

public class PersonControllerTest {

	public static void main(String[] args) {
		
//		PersonInsert pi=new PersonInsert();
//		PersonUpdate pu=new PersonUpdate();
//		PersonDto request=new PersonDto();
//		ArrayList<Integer> response=new ArrayList<Integer>();
//		
//		pu.execute(request, response);

		int select=3;
		PersonExecute pe=null;
		
//		Object request=new PersonDto();
//		ArrayList<Integer> response=new ArrayList<Integer>();
		switch(select) {
		case 0:
//			request=new PersonDto();
//			response=new ArrayList<Integer>();
			pe=new PersonInsert();
			break;
		case 1:
//			request=new PersonDto();
//			response=new ArrayList<Integer>();
			pe=new PersonUpdate();
			break;
		case 2:
			pe=new PersonDelete();
			break;
		case 3:
			pe=new PersonSelect();
			break;
		default:
			break;
		}
//		pe.execute(request, response);
		pe.execute();
	}

}
