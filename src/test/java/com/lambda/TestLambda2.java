package com.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * 
 * Lambda 基础语法
 * 
 * 函数式接口：只有一个抽象方法的接口
 * @author Alvin
 *
 */
public class TestLambda2 {

	/*
	 * 1. Java8引入了新的操作符"->" 称为箭头操作符或Lambda操作符
	 *    左侧：Lambda 表达式的参数列表
	 *    右侧：Lambda 表达式中所需执行的功能，称为Lambda体
	 * 
	 * 语法格式一： 无参数、无返回值
	 *            () -> System.out::println("Hello Lambda!");
	 *            
	 * 语法格式二：有一个参数、无返回值
	 *            (x)-> System.out.println(x);
	 * 语法格式三：若只有一个参数、小括号可以省略不写
	 *            x -> System.out.println(x);
	 *            
	 * 语法格式四：有多个参数、有返回值、Lambda体中有多条语句           
	 *            Comparator<Integer> com = (x,y) -> {
	 *				System.out.println("函数式接口");
	 *				return Integer.compare(x, y);
	 *			  };
	 *			  int result = com.compare(1, 2);
	 * 语法格式五：若Lambda体中只有一条语句，大括号和return都可以省略
	 *            Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
	 *            
	 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM通过上下文推断出数据类型，即：类型推断
	 *            (Integer x, Integer y) -> Integer.compare(x,y);
	 * 
	 * 左右遇一 括号省
	 * 左侧推断 类型省
	 * 括号省了 return省
	 * 
	 * 2. Lambda 表达式需要函数式接口的支持
	 *    函数式接口：接口中只有一个抽象方法。
	 *    可以使用注解@FunctionInterface检查接口是否是函数式接口
	 *    即：@FunctionInterface修饰的接口只能有一个抽象方法
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void test1() {
		// jdk 1.7 以前，必须是final（在同级的匿名内部类中被调用）
		// jdk 1.8 之后，隐藏了final，本质没有变
		int num = 0; 
		
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Hello World!" + num);
			}
		};
		r.run();
		System.out.println("------------------------");
		Runnable r1 = () -> System.out.println("Hello Lambda!" + num);
		r1.run();
	}
	
	@Test
	public void test2() {
		// Consumer<String> con = (x) -> System.out.println(x);
		Consumer<String> con = x -> System.out.println(x);
		con.accept("A string !");
	}
	
	@Test
	public void test3() {
		/*
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		*/
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		int result = com.compare(1, 2);
		System.out.println(result);
	}
	
	@Test
	public void test5() {
		// 类型推断（等号后面没有指定类型）
		String[] strs = {"aaa","bbb","ccc"};
		/*
		String[] strs;
		strs = {"aaa","bbb","ccc"};
		*/
		List<String> list = new ArrayList<>();
		// Java8
		show(new HashMap<>());
	}
	
	public void show(Map<String, Integer> map) {}
	
	// 需求：对一个数进行运算
	
	@Test
	public void test6() {
		// 平方
		Integer integer = operation(100, (x) -> x * x);
		// 加10
		Integer integer1 = operation(100 , x -> x + 10);
		
		System.out.println(integer + "\n" + integer1);
		
	}
	
	public Integer operation(Integer num, MyFun mf) {
		return mf.getValue(num);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
