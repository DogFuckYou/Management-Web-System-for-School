package com.ahnieh.action;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestDemo {
	public static void main(String[] args) {
		String path = "/stu/a/b///Query.do";
		String sub = path.substring(path.lastIndexOf('/')+1, path.lastIndexOf('.')).toLowerCase();
		System.out.println(sub);
	}
}
