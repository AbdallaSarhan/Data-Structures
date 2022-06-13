package model;



import tests.Node;

public class ListUtilities<E> {

	public Node<E> reverseOf(Node<E> input) {
		Node<E> copy = null;
		Node<E> temp = null;
		if(input == null) {
			
		}
		else {
			Node<E> current = input;
			while (current != null) {
				if(current.getNext() == null) {
					copy = new Node<E>(current.getElement(), null);
					temp = copy;
					break;
				}
				current = current.getNext();
				
			}
			current = input;
			while(current.getNext() != null) {
				if(current.getNext().getElement() == temp.getElement()) {
					temp.setNext(new Node<E>(current.getElement(), null));
					temp = temp.getNext();
					current = input;
					continue;
				}
				current = current.getNext();
			}
			
			
		}
		
		return copy;
	}
	
	

	public Node<E> copyOf(Node<E> input) {
		Node<E> copy = null;
		Node<E> temp = null;
		Node<E> current = input;
		if(input == null) {
			
		}
		else {
			copy = new Node<E>(current.getElement(), null);
			temp = copy;
			current = current.getNext();
			
			while(current!=null) {
				temp.setNext(new Node<E>(current.getElement(), null));
				temp = temp.getNext();
				current = current.getNext();
			}
			
		}
		return copy;
	}



	public Node<E> removeNthFromEnd(Node<E> input, int i) {
		Node<E> output = input;
		int size = 0;
		Node<E> current = input;
		while(current != null) {
			size++;
			current = current.getNext();
		}
		current = input;
		Node<E> temp = current;
		int position = size - i;	// this is the position of i-1 for the node needed to be deleted
		int count = 0;
		if(position > 0) {
			while(count <= position) {
				if(count == position - 1) {
					temp = current;
					current.setNext(current.getNext().getNext());
					temp.getNext().setNext(null);
				}
				count++;
				current = current.getNext();
			}
		}
		else if(position == 0) {
			temp = current;
			current = current.getNext();
			temp.setNext(null);
			output = current;
		}
		
		
		
		return output;
	}

}

