package com.programOfJava;

import java.util.ArrayList;
import java.util.List;

public class ReverseArraylist {

	public List<Integer> reverseList(List<Integer> list) {
		System.out.println("Original List : " + list);
		for(int i = 0; i < list.size()/2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(list.size() - i -1));
			list.set(list.size() -i - 1, temp);
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		ReverseArraylist objArraylist = new ReverseArraylist();
		list = objArraylist.reverseList(list);
		System.out.println("Reversed List: " + list);
	}
}
