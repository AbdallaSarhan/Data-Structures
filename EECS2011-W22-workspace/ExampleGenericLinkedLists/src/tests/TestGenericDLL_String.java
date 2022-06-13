package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import generic_dll.DoublyLinkedList;
import generic_dll.Node; 

public class TestGenericDLL_String {
	
	@Test
	public void test_String_DLL_Empty_List() {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		assertTrue(list.getSize() == 0);
		assertTrue(list.getFirst() == null);
		assertTrue(list.getLast() == null);
	}

	@Test
	public void test_String_DLL_Insert_Front_End() {
		DoublyLinkedList<String> list = new DoublyLinkedList<>(); 
		list.addFirst("Mark");
		list.addFirst("Alan");
		
		assertTrue(list.getSize() == 2);
		assertEquals("Alan", list.getFirst().getElement());
		assertEquals("Mark", list.getFirst().getNext().getElement()); 
		
		list = new DoublyLinkedList<>(); 
		list.addLast("Mark");
		list.addLast("Alan");
		
		assertTrue(list.getSize() == 2);
		assertEquals("Alan", list.getLast().getElement());
		assertEquals("Mark", list.getLast().getPrev().getElement()); 
	}
	
	@Test
	public void test_String_DLL_addAt() {
		DoublyLinkedList<String> list = new DoublyLinkedList<>(); 
		list.addAt(0, "Alan");
		list.addAt(1, "Tom");
		list.addAt(1, "Mark");
		
		assertTrue(list.getSize() == 3);
		assertEquals("Alan", list.getFirst().getElement());
		assertEquals("Mark", list.getFirst().getNext().getElement()); 
		assertEquals("Tom", list.getFirst().getNext().getNext().getElement()); 
	}
	
	@Test
	public void test_String_DLL_Remove_Front_End() {
		DoublyLinkedList<String> list = new DoublyLinkedList<>(); 
		list.addFirst("Mark");
		list.addFirst("Alan"); 
		list.removeFirst();
		list.removeFirst(); 
		assertTrue(list.getSize() == 0);
		
		list = new DoublyLinkedList<>(); 
		list.addFirst("Mark");
		list.addFirst("Alan");
		list.removeLast();
		list.removeLast(); 
		assertTrue(list.getSize() == 0);
	}
	
	@Test
	public void test_String_DLL_removeAt() {
		DoublyLinkedList<String> list = new DoublyLinkedList<>(); 
		list.addFirst("Mark");
		list.addFirst("Alan"); 
		list.addFirst("Tom"); 
		assertTrue(list.getSize() == 3);
		list.removeAt(1);
		assertTrue(list.getSize() == 2);
		list.removeAt(0); 
		assertTrue(list.getSize() == 1);
		list.removeAt(0); 
		assertTrue(list.getSize() == 0);
	}
	
	@Test
	public void test_String_DLL_getNodeAt() {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		Node<String> header = list.getNodeAt(-1);
		Node<String> trailer = list.getNodeAt(list.getSize());
		
		assertNull(header.getPrev());
		assertNull(header.getElement());
		assertNull(trailer.getNext());
		assertNull(trailer.getElement());
		assertTrue(header == trailer.getPrev());
		assertTrue(trailer == header.getNext());
		
		list.addFirst("Mark");
		list.addFirst("Alan");
		assertTrue(list.getSize() == 2);
		
		header = list.getNodeAt(-1);
		Node<String> first = list.getNodeAt(0);
		Node<String> second = list.getNodeAt(1);
		trailer = list.getNodeAt(list.getSize());
		
		assertTrue(header.getPrev() == null && header.getNext() == first);
		assertTrue(first.getPrev() == header && first.getNext() == second);
		assertTrue(second.getPrev() == first && second.getNext() == trailer);
		assertTrue(trailer.getPrev() == second && trailer.getNext() == null);
		
		assertNull(header.getElement());
		assertEquals("Alan", first.getElement());
		assertEquals("Mark", second.getElement());
		assertNull(trailer.getElement());
	}
	
	@Test
	public void test_String_DLL_insertBefore() {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		Node<String> header = list.getNodeAt(-1);
		Node<String> trailer = list.getNodeAt(list.getSize());
		
		assertNull(header.getPrev());
		assertNull(header.getElement());
		assertNull(trailer.getNext());
		assertNull(trailer.getElement());
		assertTrue(header == trailer.getPrev());
		assertTrue(trailer == header.getNext());
		
		list.addFirst("Mark");
		list.addFirst("Alan");
		list.addFirst("Abdi");
		assertTrue(list.getSize() == 3);
		
		list.insertBefore(trailer, "matt");
		assertEquals("matt", trailer.getPrev().getElement());
		list.addAt(0, "Alan");
		list.insertBefore(list.getNodeAt(2), "mario");
		assertEquals("mario", list.getNodeAt(2).getPrev().getElement());
	}
}
