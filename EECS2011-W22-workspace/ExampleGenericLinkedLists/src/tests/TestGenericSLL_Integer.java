package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import generic_sll.Node;
import generic_sll.SinglyLinkedList;

/*
 * Tests on a generic SLL whose generic type parameter is instantiated as Integer.
 */

public class TestGenericSLL_Integer {
	@Test
	public void test_ChainOfIntegerNodes_Approach_01() {
		Node<Integer> n3 = new Node<>(68, null); // alternatively: Node<Integer> n3 = new Node<Integer>(68, null);
		Node<Integer> n2 = new Node<>(46, n3);
		Node<Integer> n1 = new Node<>(23, n2);
		
		assertTrue(n1.getNext() == n2);
		assertTrue(n2.getNext() == n3);
		assertTrue(n1.getNext().getNext() == n3);
		assertTrue(n3.getNext() == null);
		assertTrue(n2.getNext().getNext() == null);
		assertTrue(n1.getNext().getNext().getNext() == null);
		
		assertTrue(23 == n1.getElement());
		assertTrue(46 == n2.getElement());
		assertTrue(46 == n1.getNext().getElement());
		assertTrue(68 == n3.getElement());
		assertTrue(68 == n2.getNext().getElement());
		assertTrue(68 == n1.getNext().getNext().getElement());
	}
	
	@Test
	public void test_ChainOfIntegerNodes_Approach_02() {
		Node<Integer> n1 = new Node<>(23, null);
		Node<Integer> n2 = new Node<>(46, null);
		Node<Integer> n3 = new Node<>(68, null);
		n1.setNext(n2);
		n2.setNext(n3);
		
		assertTrue(n1.getNext() == n2);
		assertTrue(n2.getNext() == n3);
		assertTrue(n1.getNext().getNext() == n3);
		assertTrue(n3.getNext() == null);
		assertTrue(n2.getNext().getNext() == null);
		assertTrue(n1.getNext().getNext().getNext() == null);
		
		assertTrue(23 == n1.getElement());
		assertTrue(46 == n2.getElement());
		assertTrue(46 == n1.getNext().getElement());
		assertTrue(68 == n3.getElement());
		assertTrue(68 == n2.getNext().getElement());
		assertTrue(68 == n1.getNext().getNext().getElement());
	}
	
	/*
	 * Setting the head of a SLL to a chain of node.
	 */
	@Test
	public void test_Integer_SLL_01() {
		Node<Integer> n3 = new Node<>(68, null);
		Node<Integer> n2 = new Node<>(46, n3);
		Node<Integer> n1 = new Node<>(23, n2);
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.setHead(n1);
		
		assertTrue(n3 == list.getTail());
		assertSame(n3, list.getTail());
		
		assertTrue(list.getSize() == 3);
		assertTrue(23 == list.getFirst().getElement());
		assertTrue(46 == list.getFirst().getNext().getElement());
		assertTrue(68 == list.getFirst().getNext().getNext().getElement());
	}
	
	/*
	 * Gradually adding elements to a list by invoking SLL methods. 
	 * Exercise: contrast how the same SLL can be constructed using test_Integer_SLL_01 vs. test_Integer_SLL_02.
	 */
	@Test
	public void test_Integer_SLL_02() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertTrue(list.getSize() == 0);
		assertTrue(list.getFirst() == null);
		
		list.addFirst(68);
		list.addFirst(46);
		list.addFirst(23);
		assertTrue(list.getSize() == 3);
		assertTrue(23 == list.getFirst().getElement());
		assertTrue(46 == list.getFirst().getNext().getElement());
		assertTrue(68 == list.getFirst().getNext().getNext().getElement());
	}
	
	@Test
	public void test_Integer_SLL_addAt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertTrue(list.getSize() == 0);
		assertTrue(list.getFirst() == null);
		
		list.addFirst(68);
		list.addFirst(46);
		list.addFirst(23);
		assertTrue(list.getSize() == 3);
		
		list.addAt(0, 31); 
		list.addAt(2, 20);
		assertTrue(list.getSize() == 5);
		list.addAt(list.getSize(), 34);
		assertTrue(list.getSize() == 6);
		assertTrue(31 == list.getNodeAt(0).getElement());
		assertTrue(23 == list.getNodeAt(1).getElement());
		assertTrue(20 == list.getNodeAt(2).getElement());
		assertTrue(46 == list.getNodeAt(3).getElement());
		assertTrue(68 == list.getNodeAt(4).getElement());
		assertTrue(34 == list.getNodeAt(5).getElement());
	}
	
	@Test
	public void test_Integer_SLL_removeLast() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertTrue(list.getSize() == 0);
		assertTrue(list.getFirst() == null);
		
		list.addFirst(68);
		list.addFirst(46);
		list.addFirst(23);
		assertTrue(list.getSize() == 3);
		
		list.removeLast();
		assertTrue(list.getSize() == 2);
		assertTrue(23 == list.getNodeAt(0).getElement());
		assertTrue(46 == list.getNodeAt(1).getElement());
		
		list.removeLast();
		assertTrue(list.getSize() == 1);
		assertTrue(23 == list.getNodeAt(0).getElement());
		
		list.removeLast();
		assertTrue(list.getSize() == 0);
		assertNull(list.getFirst());
	}
}
