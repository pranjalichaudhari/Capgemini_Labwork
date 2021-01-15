import java.util.Scanner;

import com.cg.customexception.InvalidAgeException;
import com.cg.customexception.InvalidNameException;
import com.cg.eis.exception.EmployeeException;

public class Employee {

	 static void validateAge(int age)throws InvalidAgeException{  
	     if(age<15)  
	      throw new InvalidAgeException("Invalid Age");  
	     else  
	      System.out.println("Age Is Valid");  
	   }  
	 
	 static void validateName(String firstName, String lastName)throws InvalidNameException{
		 
		 if(firstName.isBlank() || lastName.isBlank())
		 {
			 throw new InvalidNameException("Name Cannot Be Blank");
		 }
		 else
			 System.out.println("Valid Name");
	 }
	 
	 
	 static void validateSalary(float salary)throws EmployeeException{
		 
		 if(salary <3000)
		 {
			 throw new EmployeeException("Salary cannot be less than 3000");
		 }
		 else
			 System.out.println("Valid Salary");
		 
	 }
	 
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String fname,lname;
		int age;
		float salary;
		System.out.println("Enter first and last name : ");
		fname = sc.next();
		lname = sc.nextLine();
		System.out.println("Enter your age : ");
		age = sc.nextInt();
		System.out.println("Enter Salary : ");
		salary = sc.nextFloat();
		try
		{
			validateName(fname,lname);
			validateAge(age);
			validateSalary(salary);
			
		}
		catch(InvalidNameException in){
			System.out.println(in.getMessage());
			
		}
		catch(InvalidAgeException ia) {
			System.out.println(ia.getMessage());
		}
		catch(EmployeeException is) {
			System.out.println(is.getMessage());
		}
		
	}
}
