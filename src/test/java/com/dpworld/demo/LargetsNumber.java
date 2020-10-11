package com.dpworld.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class LargetsNumber {

	List<Integer> storeAllNumbers = new ArrayList<>();
	public static void main(String[] args) {
		LargetsNumber obj = new LargetsNumber();
		for(int i=0;i<=1000;i++) {
			obj.store(i); //here assuming random number we are storing
		}
		for(int i=0;i<10; i++) {
			System.out.println(obj.getLargest());
		}
		
	}
	
	private void store(Integer n) {
		storeAllNumbers.add(n);
	}
	
	private Integer getLargest() {
		Collections.sort(storeAllNumbers);
		Integer largeNum = 0; 
		ListIterator<Integer> li = storeAllNumbers.listIterator(storeAllNumbers.size());

		while(li.hasPrevious()) {
			largeNum = li.previous();
			li.remove();
			break;
		}
		System.out.println("removed the biggest number..."+largeNum);
		return largeNum;
	}

}
