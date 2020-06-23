package com.telusko.demoproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Alien {
	
	private int age;
	private Computer com;
	
	
	

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Age assigned");
		this.age = age;
	}

	

	public void code()
	{
		System.out.println("I am coding...");
		com.compile();
	}
}
