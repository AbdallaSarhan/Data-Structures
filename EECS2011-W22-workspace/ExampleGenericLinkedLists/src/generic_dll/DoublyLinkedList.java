package generic_dll;

public class DoublyLinkedList<E> {
	
	private Node<E> header;
	private Node<E> trailer;
	private int size;

	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, null, null);
		header.setNext(trailer);
		trailer.setPrev(header);
	}

	public Node<E> getFirst() {
		return size == 0 ? null : header.getNext();
	}
	
	public Node<E> getLast() {
		return size == 0 ? null : trailer.getPrev();
	}

	public boolean isEmpty() {
		return 
				this.header.getNext() == trailer && 
				this.trailer.getPrev() == header;
	}

	public int getSize() {
		return size;
	}
	
	/*
	 *  i == -1 means to retrieve the header node.
	 *  i == getSize() means to retrieve the trailer node.
	 */
	public Node<E> getNodeAt(int i) { 
		if(i < -1 || i > getSize()) {
			throw new IllegalArgumentException("Invalid index: " + i);
		}
		else {
			Node<E> current = header;
			for(int j = -1; j < i; j ++) {
				current = current.getNext();
			}
			return current;
		}
	}

	private void addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newNode = new Node<>(e, pred, succ);
		pred.setNext(newNode);
		succ.setPrev(newNode);
		size ++; 
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	public void addAt(int i, E e) {
		if (i < 0 || i > size) { 
			throw new IllegalArgumentException("Invalid index: " + i);
		}
		else { 
			Node<E> succ = getNodeAt(i);
			Node<E> pred = succ.getPrev(); 
			addBetween(e, pred, succ);
		} 
	}

	private void remove(Node<E> node) {
		Node<E> pred = node.getPrev();
		Node<E> succ = node.getNext();
		pred.setNext(succ);
		succ.setPrev(pred);
		node.setNext(null);
		node.setPrev(null);
		size --; 
	}

	public void removeFirst() {
		if (size == 0) { 
			throw new IllegalArgumentException("List is empty.");
		}
		else { 
			remove(header.getNext()); 
		} 
	}

	public void removeLast() {
		if (size == 0) { 
			throw new IllegalArgumentException("List is empty.");
		}
		else { 
			remove(trailer.getPrev()); 
		} 
	}
	
	public void removeAt(int i) {
		if (i < 0 || i >= size) { 
			throw new IllegalArgumentException("Invalid index: " + i);
		}
		else { 
			Node<E> node = getNodeAt(i);  
			remove(node);
		} 
	}
	
	/*
	 * Exercises:
	 * 	+ void insertBefore(Node n, E e) 
	 * 	+ void insertAfter(Node n, E e) 
	 * 	+ void removeBefore(Node n)
	 *  + void removeAfter(Node n)
	 */
	public void insertBefore(Node<E> node, E e){
		Node<E> temp = node.getPrev();
		Node<E> newNode = new Node<E>(e, temp, node);
		temp.setNext(newNode);
		node.setPrev(newNode);
		size++;
	//	Node<E> pred = temp.getPrev();
	//	Node<E> succ = temp.getNext();
		
		
		}
}