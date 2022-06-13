package generic_dll;

/*
 * A generic template of linked nodes in a doubly-linked list. 
 * The generic type parameter E may be instantiated by a class name,
 * 	e.g., Node<Integer>, Node<String>, 
 * 	so that each reference to E within the Node class is instantiated accordingly.  
 */

public class Node<E> {
	
	private E element;
	private Node<E> next;
	private Node<E> prev;
	
	public Node(E e, Node<E> p, Node<E> n) { 
		element = e;
		prev = p;
		next = n; 
	}
	
	public E getElement() { 
		return element; 
	}
	
	public void setElement(E e) { 
		element = e; 
	}
	
	public Node<E> getPrev() { 
		return prev; 
	}
	
	public void setPrev(Node<E> n) {
		prev = n;
	}
	
	public Node<E> getNext() { 
		return next; 
	}
	
	public void setNext(Node<E> n) { 
		next = n; 
	} 
}