package com.dassault.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LargestTest {
	/*
	private static Largest larObj;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("--- inside setUp() ---");
		larObj = new Largest();
	}
	
	@AfterAll
	public static void destroy() {
		larObj = null;
		System.out.println("--- inside destroy() ---");
	}
	*/
	@Test
	void testFindLargest() {
		int[] data = {12,85,46,92,13,54,6};
		Largest larObj = new Largest();
		int expected = 92;
		int actual = larObj.findLargest(data);
		assertEquals(expected, actual);
	}

	@Test
	void testFindLargest1() {
		int[] data = {-12,-85,-46,-92,-13,-54,-6};
		Largest larObj = new Largest();
		int expected = -6;
		int actual = larObj.findLargest(data);
		assertEquals(expected, actual);
	}	
	
	@Test
	void testFindLargest2() {
		int[] data = {};
		Largest larObj = new Largest();		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> larObj.findLargest(data));
	}	
}
