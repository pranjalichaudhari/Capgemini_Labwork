package com.cg.eis.service;

public interface EmployeeService
{
	default void userInput(int id, String name, double salary, String designation)
	{
		
	}
	default void showData()
	{ 
		
	}
	default String FindInsuranceSchema(double sal, String designation)
	{
		return "";
	}
}