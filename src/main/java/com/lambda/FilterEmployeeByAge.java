package com.lambda;

public class FilterEmployeeByAge implements MyPredicate<Employee> {


	public boolean test(Employee t) {
		return t.getAge() >= 35;
	}

}
