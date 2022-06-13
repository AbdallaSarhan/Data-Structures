package model;

import tests.SLLNode;

import tests.TreeNode;

public class TreeUtilities<S> {

	public TreeNode<S> copyOf(TreeNode<S> node) {
		
		
	 TreeNode<S> copy = new TreeNode<>(node.getElement());
			
	
		SLLNode<TreeNode<S>> tracker = node.getChildren();
	
			
			while(tracker!=null) {
				TreeNode<S> child = copyOf(tracker.getElement());
				child.setParent(copy);
				copy.addChild(child);
				tracker = tracker.getNext();
				}
		
		
		return copy;
		
	}

	
	private SLLNode<TreeNode<S>> nodes;
	
	
	public SLLNode<TreeNode<S>> getPreOrderSeq(TreeNode<S> node) {
		
		SLLNode<TreeNode<S>> numbers = new SLLNode<>(node, null);
			
			if(node != null) {
			SLLNode<TreeNode<S>> tracker = node.getChildren();
			nodes = numbers;
				
				while(tracker!=null) {
					
					nodes.setNext(getPreOrderSeq(tracker.getElement()));
				
					
					while(nodes.getNext() != null) {
					nodes = nodes.getNext();
					}
					tracker = tracker.getNext();
					}
				
				
				
		}	
		
		return numbers;
	}
}
	
