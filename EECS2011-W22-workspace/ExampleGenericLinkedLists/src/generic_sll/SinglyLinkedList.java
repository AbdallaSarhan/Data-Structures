package generic_sll;

public class SinglyLinkedList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;

	public SinglyLinkedList() {
		/* 
		 * Creates an empty list:
		 * 	+ head has the default value null.
		 * 	+ tail has the default value null.
		 * 	+ size has the default value 0.
		 */
	}

	public Node<E> getFirst() {
		return head;
	}
	
	public Node<E> getLast() {
		return tail;
	}

	public void setHead(Node<E> n) {
		head = n;
	}

	public int getSize() {
		int size = 0;
		Node<E> current = head;
		while(current != null) { /* loop exists when current == null */
			size ++;
			current = current.getNext();
		}
		return size; 
	}

	public Node<E> getTail() { 
		Node<E> current = head;
		Node<E> tail = null;
		while (current != null) {   
			tail = current;
			current = current.getNext();
		}
		return tail;
	}

	public void addFirst(E e) {
		head = new Node<>(e, head); // alternatively: head = new Node<E>(e, head); 
		// The above line is equivalent to the following 3 lines:
		//		Node nn = new Node(e, null);
		//		nn.setNext(head);
		//		head = nn;
		if(size == 0) {
			tail = head;
		}
		size ++;
	} 
	
	/*
	 * Exercises: 
	 * 	 + void removeFirst()
	 * 	 + void addLast(E e)
	 */

	public Node<E> getNodeAt (int i) {
		int size = this.getSize(); // a more efficient implementation is to make `size` an attribute.
		if (i < 0 || i >= size) { 
			throw new IllegalArgumentException("Invalid Index"); 
		}
		else {
			int index = 0; 
			Node<E> current = head;
			while (index < i) { /* exit when index == i */
				index ++;
				/* current is set to node at index i 
				 * last iteration: index incremented from i - 1 to i
				 */
				current = current.getNext();
			} 
			return current; 
		} 
	}

	public void addAt (int i, E e) {  
		if (i < 0 || i > size) { 
			throw new IllegalArgumentException("Invalid Index.");
		} 
		else { 
			if (i == 0) { 
				addFirst(e); 
			} 
			else {
				Node<E> nodeBefore = getNodeAt(i - 1);
				Node<E> newNode = new Node<E>(e, nodeBefore.getNext()); // alternatively: Node<E> newNode = new Node<>(e, nodeBefore.getNext())
				nodeBefore.setNext(newNode);
				size ++;
			} 
		} 
	}

	public void removeFirst () {
		if (size == 0) { /* error */ }
		else if (size == 1) {
			head = null; 
			tail = null;
			size --; 
		}
		else {
			Node<E> oldHead = head;
			head = oldHead.getNext();
			oldHead.setNext(null); 
			size --; 
		}
	}

	public void removeLast () { 
		if (size == 0) {
			throw new IllegalArgumentException("Empty List.");
		} 
		else if (size == 1) {
			removeFirst();
		} 
		else {
			Node<E> secondLastNode = getNodeAt(size - 2);
			secondLastNode.setNext(null); 
			tail = secondLastNode;
			size --;
		} 
	}  
	
	/*
	 * Exercises: 
	 * 	+ void insertAfter(Node n, E e) 
	 * 	+ void insertBefore(Node n, E e)
	 * 	+ void removeAt(int i)
	 */
}