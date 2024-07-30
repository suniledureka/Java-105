package com.dassault.services;

public class Largest {
	public int findLargest(int[] data) {
		//int lar = 0;
		int lar = data[0];
		for(int i=1; i<data.length; i++) {
			if(data[i] > lar) {
				lar = data[i];
			}
		}
		return lar;
	}
}
