package com.chensheng.jdk8.demo;

import java.util.HashMap;
import java.util.Map;

public class JDK8Map {

	public static void main(String[] args) {

//		compute();
//		putIfAbsent();
//		computeIfPresent();
		computeIfAbsent();
	}

	/**
	 * put返回旧值，如果没有则返回null
	 */
	public void put() {
		// put返回旧值，如果没有则返回null
		Map<String, String> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		String v = map.put("b", "v"); // 输出 B
		System.out.println(v);
		String v1 = map.put("c", "v");
		System.out.println(v1); // 输出：NULL
	}

	/**
	 * putIfAbsent 如果key不存在，则将新值进Map集合。返回key原有的值
	 */
	public static void putIfAbsent() {
		Map<String,Object> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		Object c1 = map.putIfAbsent("c", "C");
		System.out.println(c1);
	
		Object d1 = map.putIfAbsent("c", "D");
		System.out.println(d1);
		
		
	}
	
	
	/**
	 * compute：将remappingFunction返回的结果添加进Map集合，并返回作为返回值
	 * remappingFunction 有俩个参数，分别是key和value。key和compute方法第一个参数保持一致。
	 * 如果Map集合中没有key，value则为null。
	 */
	public static void compute() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		String val = map.compute("b", (k, v) -> {
			System.out.println(k);
			System.out.println(v);
			return "v";
		}); // 输出 v
		System.out.println(val);
		String v1 = map.compute("c", (k, v) -> {
			System.out.println(k);
			System.out.println(v);
			return "v";}); // 输出 v
		System.out.println(v1);
	}
	
	
	/**
	 * computeIfPresent 如果key存在,执行remappingFunction方法。
	 */
	public static void computeIfPresent() {
		Map<String,Object> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		Object result = map.computeIfPresent("b", (k, v) -> {
			System.out.println(k);
			System.out.println(v);
			return "v";
		});
		System.out.println(result);
		result = map.computeIfPresent("c", (k,v) -> {
			System.out.println(k);
			System.out.println(v);
			return "v";
		});
		System.out.println(result);
	}

	/**
	 * computeIfAbsent 如果key不存在，执行remappingFunction方法。
	 * 并将remappingFunction方法返回值作为computeIfAbsent方法返回值
	 */
	public static void computeIfAbsent() {
		Map<String,Object> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		Object result = map.computeIfAbsent("b", k -> "v");
		System.out.println(result);
		result = map.computeIfAbsent("c", (k) -> {System.out.print(k); return "v";});
		System.out.println(result);
	}
}
