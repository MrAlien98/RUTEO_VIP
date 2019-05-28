package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tours.Savings;
import tours.Node;

class MainTest {

	Savings main;
	
	void stage1() {
		main=new Savings();
	}
	
	void stage2() {
		
	}
	
	@Test
	void testReverse() {
		stage1();
		ArrayList<Node> arr=new ArrayList<>();
		arr.add(new Node(1,5, 'A'));
		arr.add(new Node(6,4, 'B'));
		arr.add(new Node(2,8, 'C'));
		arr.add(new Node(10,3, 'D'));
		Node a=new Node(10,3, 'E');
		Node b=new Node(1,5, 'F');
		arr=main.reverseArrayList(arr);		
		assertEquals(a.toString(), arr.get(0).toString());
		assertNotEquals(a.toString(), arr.get(1).toString());
		assertNotEquals(b.toString(), arr.get(2).toString());
		assertEquals(b.toString(), arr.get(3).toString());
	}
	
	@Test
	void testReverse2() {
		stage1();
		ArrayList<Node> arr=new ArrayList<>();
		arr.add(new Node(1,5, 'A'));
		arr=main.reverseArrayList(arr);
		assertEquals(1, arr.size());
	}

}
