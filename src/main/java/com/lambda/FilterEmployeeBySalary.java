package com.lambda;

public class FilterEmployeeBySalary implements MyPredicate<Employee> {


	public boolean test(Employee t) {
		return t.getSalary() > 5000;
	}

}
