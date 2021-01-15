/**
 * @author Pranjali Chaudhari
 * Desc - create packages and classes as given below:
a)	com.cg.eis.bean
	In this package, create “Employee” class with different attributes such as id, name, salary, designation, insuranceScheme.
b)	com.cg.eis.service
		This package will contain code for services offered in Employee Insurance System. The service class will have one EmployeeService Interface and its corresponding implementation class.
The services offered by this class are:
i)	Get employee details from user.
ii)	Find the insurance scheme for an employee based on salary and designation.
iii)	Display all the details of an employee.
c)	com.cg.eis.pl
		This package will contain code for getting input from user, produce expected output to the user and invoke services offered by the system. 
 * 
 */
package com.cg.employee.main;
import com.cg.eis.pl.MenuUtil;

public class EmployeeStartup {

	public static void main(String args[]) {
		MenuUtil menuUtil = new MenuUtil();
		MenuUtil.start();
	}	
}
