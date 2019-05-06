package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tours.Controladora;
import tours.Nodo;

class MainTest {

	Controladora main;
	
	void stage1() {
		main=new Controladora();
	}
	
	void stage2() {
		
	}
	
	@Test
	void testReverse() {
		stage1();
		ArrayList<Nodo> arr=new ArrayList<>();
		arr.add(new Nodo(1,5));
		arr.add(new Nodo(6,4));
		arr.add(new Nodo(2,8));
		arr.add(new Nodo(10,3));
		Nodo a=new Nodo(10,3);
		Nodo b=new Nodo(1,5);
		arr=main.reverseArrayList(arr);		
		assertEquals(a.toString(), arr.get(0).toString());
		assertNotEquals(a.toString(), arr.get(1).toString());
		assertNotEquals(b.toString(), arr.get(2).toString());
		assertEquals(b.toString(), arr.get(3).toString());
	}
	
	@Test
	void testReverse2() {
		stage1();
		ArrayList<Nodo> arr=new ArrayList<>();
		arr.add(new Nodo(1,5));
		arr=main.reverseArrayList(arr);
		assertEquals(1, arr.size());
	}

}
