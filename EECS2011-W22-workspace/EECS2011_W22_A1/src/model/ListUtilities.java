package model;

import tests.Node;

public class ListUtilities {
	


public Node<String> getAllPrefixes(Node<Integer> input, int start, int max) {
	
	Node<String> output = null;
	Node<Integer> temp = input;
	String contents = "[";

	
	for(int i = 0; i < start; i++) {
		if(i < start - 1) {
			contents = contents + temp.getElement().toString() + ", ";
			
		}
		else {
			contents = contents + temp.getElement().toString();
		
		}
		temp = temp.getNext();
	}
	
	output = new Node<>(contents + "]", null);
	Node<String> tempOut = output;
	
	for(int i = start; i < max; i++) {
		contents = contents + ", " + temp.getElement().toString();
		tempOut.setNext(new Node<>(contents + "]", null));
		tempOut = tempOut.getNext();
		temp = temp.getNext();
	}
	
	
	
		return output;
	}



public Node<Integer> getMergedChain(Node<Integer> leftChain, Node<Integer> rightChain) {
	Node<Integer> merged = null;
	Node<Integer> current2 = rightChain;
	Node<Integer> current= leftChain;
	Node<Integer> temp;
	if(leftChain == null && rightChain == null) {
		merged = null;
	}
	else if(leftChain == null || rightChain == null) {
		if (rightChain == null) {
			merged = new Node<Integer>(leftChain.getElement(), null);
			temp = merged;
			current = current.getNext();
			while(current != null) {
				temp.setNext(new Node<>(current.getElement(), null));
				temp = temp.getNext();
				current = current.getNext();
			}
			
		}
		else if (leftChain == null) {
			merged = new Node<Integer>(rightChain.getElement(), null);
			temp = merged;
			current2 = current2.getNext();
			while(current2 != null) {
				temp.setNext(new Node<>(current2.getElement(), null));
				temp = temp.getNext();
				current2 = current2.getNext();
			}
		}
	}
	else {
		if(leftChain.getElement() > rightChain.getElement()) {
			merged = new Node<>(rightChain.getElement(), null);
			temp = merged;
			current2 = current2.getNext();
			
		}
		
		else {
			merged = new Node<>(leftChain.getElement(), null);
			temp = merged;
			current = current.getNext();
		}
		// 1. Create a merged chain that will be put together for the output
		// 2. compare each node in the left chain and right chain
		// 3. whichever is smaller gets inserted first into the merged chain
		// through the temp Node
		
		while(current!=null && current2!=null) {
			if(current.getElement() > current2.getElement() ) {
				temp.setNext(new Node<Integer>(current2.getElement(), null));
				temp = temp.getNext();
				current2 = current2.getNext();
			}
			else {
				temp.setNext(new Node<>(current.getElement(), null));
				temp = temp.getNext();
				current = current.getNext();
			}
			
			
			
		}
		if (current!=null) {
			while (current != null) {
				temp.setNext(new Node<>(current.getElement(), null));
				temp = temp.getNext();
				current = current.getNext();
			}
			
		}
		else if(current2!=null) {
			while(current2 != null) {
				temp.setNext(new Node<>(current2.getElement(), null));
				temp = temp.getNext();
				current2 = current2.getNext();
			}
			
		}
		
	}
	
	
	return merged;
}





public Node<Integer> getInterleavedArithmeticFibonacciSequences(int base, int seperatedBy, int length, int sizeOfFib) {
	Node<Integer> fib = new Node<>(1, null);
	fib.setNext(new Node<>(1, null));
	Node<Integer> fibtemp = fib;
	Integer nextarth = base;
	Integer nextFib = 0;
	Node<Integer> interLeaved = null;
	
	Node<Integer> interLeavedtemp = null;
	
	if(length == 0 && sizeOfFib == 0) {
		interLeaved = null;
	}
	else if(length > 0 && sizeOfFib == 0) {
		interLeaved = new Node<>(base, null);
		interLeavedtemp = interLeaved;
		for (int i = 1; i < length; i++) {
		nextarth = nextarth + seperatedBy;
		interLeavedtemp.setNext(new Node<>(nextarth, null));
		interLeavedtemp = interLeavedtemp.getNext();
		}
	}
	else if(length == 0 && sizeOfFib > 0) {
		if (sizeOfFib == 1) {
			interLeaved = new Node<>(1, null);
		}
		else {
			interLeaved = new Node<>(1, null);
			interLeaved.setNext(new Node<>(1, null));
			interLeavedtemp = interLeaved;
			for(int i = 2; i < sizeOfFib; i++) {
			nextFib =  interLeavedtemp.getElement() + interLeavedtemp.getNext().getElement();
			interLeavedtemp = interLeavedtemp.getNext();
			interLeavedtemp.setNext(new Node<>(nextFib, null));
			}
		}
		
	}
	
	else {
		interLeaved = new Node<>(base, null);
		interLeaved.setNext(new Node<>(1, null));
		interLeavedtemp = interLeaved.getNext();
		for (int i = 1; i < length || i < sizeOfFib; i++) {
			if (i < length) {
				nextarth = nextarth + seperatedBy;
				interLeavedtemp.setNext(new Node<>(nextarth, null));
				interLeavedtemp = interLeavedtemp.getNext();
			}
			if (i < sizeOfFib) {
				if (i < 2) {
					nextFib = 1;
				}
				else {
					nextFib = fibtemp.getElement() + fibtemp.getNext().getElement();
				}
				fibtemp = fibtemp.getNext();
				fibtemp.setNext(new Node<>(nextFib, null));
				interLeavedtemp.setNext(new Node<>(nextFib, null));
				interLeavedtemp = interLeavedtemp.getNext();
			}
		}
	}
	
	
	return interLeaved;
}




/*
 * Calling getGroupedStrings(input, m, n) returns a chain of nodes 
 * 	which groups all elements from the input chain as follows, from left to right:
 * 	Group 1: strings whose lengths are less than m
 *  Group 2: strings whose lengths are greater than or equal to m and less than n
 *  Group 3: strings whose lengths are greater than or equal to n
 * 
 * Requirements:
 * 	- The input and output chains are equally long.
 * 	- Each group in the output chain preserves the order in which its elements appear in the input chain.
 */
public Node<String> getGroupedStrings(Node<String> input, int m, int n) {
	Node<String> groupedStrings = null;
	Node<String> groupedTemp = null;
	Node<String> temp = input;
	while(temp != null) {
		if(temp.getElement().length() < m) {
			groupedStrings = new Node<>(temp.getElement(), null);
			groupedTemp = groupedStrings;
			break;
		}
		temp = temp.getNext();
	}
	temp = input;
	while(temp != null) {
		if(temp.getElement().length() < m && temp.getElement() != groupedTemp.getElement()) {
			groupedTemp.setNext(new Node<>(temp.getElement(), null));
			groupedTemp = groupedTemp.getNext();
			
		}
		
		temp = temp.getNext();
	}
	temp = input;
	while(temp != null) {
		if(temp.getElement().length() >= m && temp.getElement().length() < n && temp.getElement() != groupedTemp.getElement()) {
			groupedTemp.setNext(new Node<>(temp.getElement(), null));
			groupedTemp = groupedTemp.getNext();
					
				}
				
				temp = temp.getNext();
			}
	temp = input;
	while(temp != null) {
		if(temp.getElement().length() >= n && temp.getElement() != groupedTemp.getElement()) {
			groupedTemp.setNext(new Node<>(temp.getElement(), null));
			groupedTemp = groupedTemp.getNext();
					
				}
				
				temp = temp.getNext();
			}
	return groupedStrings;
}


 
	
}
