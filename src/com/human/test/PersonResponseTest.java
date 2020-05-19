package com.human.test;

import com.human.controller.PersonDelete;
import com.human.controller.PersonExecute;
import com.human.controller.PersonInsert;
import com.human.controller.PersonSelect;
import com.human.controller.PersonUpdate;
import com.human.util.Request;
import com.human.util.Response;

public class PersonResponseTest {

	public static void main(String[] args) {
		int select=3;
		PersonExecute pe=null;
		Response response = new Response();
		Request request = new Request();
		
		switch(select) {
		case 0:
			pe=new PersonInsert();
			break;
		case 1:
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
		pe.execute(request, response);
//		pe.execute();

	}

}
