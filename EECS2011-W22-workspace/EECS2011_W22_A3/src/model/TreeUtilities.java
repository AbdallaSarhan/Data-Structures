package model;

import tests.Expression;
import tests.SLLNode;
import tests.TreeNode;
import tests.Operand;
import tests.Operator;

public class TreeUtilities<E> {
	

	 private SLLNode<TreeNode<E>> stack;
	 
	public TreeNode<E> getInfixTree(SLLNode<E> expression) {
		SLLNode<E> current = expression;
		TreeNode<E> operator = null;
		// push numbers onto the stack
		// when found an expression, make that the head of the treeNode and then make the 2 numbers popped from the stack the children
		// then for the next expression found, you make that the root and make the others the children
		
		while (current != null){
			if(current.getElement() instanceof Operand) {
				push(new TreeNode<>(current.getElement()));
				if(current.getNext() == null) {
				//	operator = new TreeNode<>(current.getElement());
				}
			}
			else if(current.getElement() instanceof Operator) {
			operator = new TreeNode<>(current.getElement());
			TreeNode<E> child1 = pop();
			TreeNode<E> child2 = pop();
			
			operator.addChild(child2);
			operator.addChild(child1);
			child1.setParent(operator);
			child2.setParent(operator);
			push(operator);
			}
			current = current.getNext();
		}
		
		
		
		return stack.getElement();
		
	}
	
	
	
	public void push(TreeNode<E> node) {
		if(stack == null) {
			stack = new SLLNode<TreeNode<E>>(node, null);
		}
		else {
		SLLNode<TreeNode<E>> head = new SLLNode<TreeNode<E>>(node, null);
		head.setNext(stack);
		stack = head;
		}
		
	}
	
	
	public TreeNode<E> pop(){
	//if(stack == null) {
//		return null;
//	}
	SLLNode<TreeNode<E>> element = stack;
	if(stack.getNext()== null) {
		stack = null;
	}
	else {
		stack = stack.getNext();
	}
		element.setNext(null);
		return element.getElement();
	}

	
	
	//private int count = 0;

	public String getInfixSequence(SLLNode<E> expression) {
			
		TreeNode<E> tree = getInfixTree(expression);
				
		
		
		
		return inOrderTraversal(tree);
	}
	
	private String inOrderTraversal(TreeNode<E> tree) {
		
		
		String expressions = "";
		
	
	
	if(tree.getChildren() == null) {
		if(tree.getElement() instanceof Operand) {
		expressions += ((Operand) tree.getElement()).getValue();
		}
		else if(tree.getElement() instanceof Operator) {
			expressions += ((Operator) tree.getElement()).getOperator();
		}
		
	}
	else {
		expressions += "(";
		SLLNode<TreeNode<E>> tracker = tree.getChildren();
		while(tracker != null) {
			expressions += inOrderTraversal(tracker.getElement());
			tracker = tracker.getNext();
			if(tracker == null) {
				expressions +=")";
			}
			else {
				if(tree.getElement() instanceof Operand) {
					expressions += " " + ((Operand) tree.getElement()).getValue() + " ";
					}
					else if(tree.getElement() instanceof Operator) {
						expressions += " " + ((Operator) tree.getElement()).getOperator() + " ";
					}
			}
			
		}
		
	}
	
	
	return expressions;
	}
	
	
	


}
