package com.filix.view;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.Dependent;

@ManagedBean(name = "testView", eager = true)
@Dependent
public class TestView {
	public String last_name="upadhya";
	public TestView() {

	}
	public void saveData()
	{
    System.out.println("I am in " + last_name );	
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
}
