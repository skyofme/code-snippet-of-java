package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 
 * Lambda 初体验
 * 
 * @author Alvin
 *
 */
public class TestLambda {

	// 原来的匿名内部类
	@Test
	public void test1() {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		TreeSet<Integer> set = new TreeSet<>(comparator);
	}
	
	// Lambda 表达式
	@Test
	public void test2() {
		Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
		TreeSet<Integer> set = new TreeSet<>(comparator);
	}
	
	// 需求：获取员工年龄大于35的员工信息
	List<Employee> employees = Arrays.asList(
			new Employee("zs",23,9999.99),
			new Employee("ls",33,8888.88),
			new Employee("ww",43,5555.55),
			new Employee("zl",53,4444.44),
			new Employee("tq",63,3333.33)
	);
	
	@Test
	public void test3() {
		List<Employee> list = filterEmployees(employees);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	public List<Employee> filterEmployees(List<Employee> list) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (employee.getAge() >= 35) {
				emps.add(employee);
			}
		}
		return emps;
	}
	
	// 需求：获取员工工资大于5000的员工信息
	public List<Employee> filterEmployees2(List<Employee> list) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (employee.getSalary() > 5000) {
				emps.add(employee);
			}
		}
		return emps;
	}
	
	// 优化方式1：使用设计模式,策略设计模式
	
	@Test 
	public void test4() {
		// 传入的匿名对象就是一个策略，策略的类实现接口
		List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		System.out.println("----------------------------------");
		
		List<Employee> list2 = filterEmployee(employees, new FilterEmployeeBySalary());
		
		for (Employee employee : list2) {
			System.out.println(employee);
		}
		
		System.out.println("----------------------------------");
	}
	
	
	public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
		
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (mp.test(employee)) {
				emps.add(employee);
			}
		}
		return emps;
	}
	
	// 优化方式2： 匿名内部类
	
	@Test
	public void test5() {
		List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
			
			@Override
			public boolean test(Employee t) {
				return t.getSalary() <= 5000;
			}
		});
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	// 优化方式3：不用实现接口的 lambda 表达式
	
	@Test
	public void test6() {
		// (e) 对应filterEmployee
		List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() <= 5000);
		
		list.forEach(System.out::println);
	}
	
	// 优化方式4：不用接口的Stream API
	
	@Test
	public void test7() {
		employees.stream()
				 .filter((e) -> e.getSalary() >= 5000)
				 .limit(2)
				 .forEach(System.out::println);
		System.out.println("--------------------------------------");
		
		employees.stream()
				 .map(Employee::getName)
				 .forEach(System.out::println);
	}
	
}
