package generic_sll;

/*
 * A generic template of linked nodes in a singly-linked list. 
 * The generic type parameter E may be instantiated by a class name,
 * 	e.g., Node<Integer>, Node<String>, 
 * 	so that each reference to E within the Node class is instantiated accordingly.  
 */

public class Node<E> {
	
	private E element;
	private Node<E> next;
	
	public Node(E e, Node<E> n) { 
		element = e; 
		next = n; 
	}
	
	public E getElement() { 
		return element; 
	}
	
	public Node<E> getNext() { 
		return next; 
	}
	
	public void setNext(Node<E> n) { 
		next = n; 
	}
	
	public void setElement(E e) { 
		element = e; 
	}
}