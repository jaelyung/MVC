package com.human.controller;

import com.human.util.Request;
import com.human.util.Response;

public interface PersonExecute {
	public void execute();
	public void execute(Request request, Response response);
	public void inputView(Request request, Response response);
	public void logic(Request request, Response response);
	public void outputView(Request request, Response response);
//	public void execute(Object request, Object response);
//	public void inputView(Object request, Object response);
//	public void logic(Object request, Object response);
//	public void outputView(Object request, Object response);
}
