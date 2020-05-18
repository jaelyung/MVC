package com.human.controller;

public interface PersonExecute {
	public void execute();
	public void execute(Object request, Object response);
	public void inputView(Object request, Object response);
	public void logic(Object request, Object response);
	public void outputView(Object request, Object response);
}
