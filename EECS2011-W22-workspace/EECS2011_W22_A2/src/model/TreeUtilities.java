package model;



import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {
	
	private int count;
	private SLLNode<Integer> numbers = null;
	private SLLNode<Integer> nodes = null;

	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> root, int lowerBound, int upperBound) {
		count = 0;
		
		preorder(root);
		
		sort(numbers);
		SLLNode<Integer> output = numbers;
		
		for(int i =1; i<lowerBound; i++) {
			output = output.getNext();
		}
		SLLNode<Integer> temp = output;
		for(int j=lowerBound; j<upperBound; j++) {
			
			
				temp = temp.getNext();	
			
			
		}
		temp.setNext(null);
		
		
		
		return output;
	}
	
	public void sort(SLLNode<Integer> head) {
		SLLNode<Integer> current = head;
		SLLNode<Integer> index = null;
		int temp;
			
					while (current != null) {
		            // Node index will point to node next to
		            // current
		            index = current.getNext();
		            
		            while (index != null) {
		                // If current node's data is greater
		                // than index's node data, swap the data
		                // between them
		                if (current.getElement() > index.getElement()) {
		                	temp = current.getElement();
		                	current.setElement(index.getElement());
		                	index.setElement(temp);
		                 
		                }
		        
		
		                index = index.getNext();
		            }
		            
		            current = current.getNext();
		            
		}
		
	
	}
	
	

	public void preorder(TreeNode<Integer> node){
		if(node != null) {
			SLLNode<TreeNode<Integer>> tracker = node.getChildren();
			if(count == 0) {
				numbers = new SLLNode<>(node.getElement(), null);
				nodes = numbers;
				count++;
				while(tracker!=null) {
					//System.out.println(childtracker.getElement().getElement());
					nodes.setNext(new SLLNode<>(tracker.getElement().getElement(), null));
					nodes = nodes.getNext();
					tracker = tracker.getNext();
					}
					
				//System.out.println(node.getElement());
			}
			else {
				while(tracker!=null) {
				//System.out.println(childtracker.getElement().getElement());
				nodes.setNext(new SLLNode<>(tracker.getElement().getElement(), null));
				nodes = nodes.getNext();
				tracker = tracker.getNext();
				}
				
			}	
			tracker = node.getChildren();
			while(tracker!=null) {
			preorder(tracker.getElement());
			tracker = tracker.getNext();
			}
		}
		
	}

	public TreeNode<String> getStats(TreeNode<Integer> head) {
		int desc = descendants(head, 0);
		int sum = sum(head, 0);
		TreeNode<String> output = new TreeNode<>(String.format("Number of descendants: %d; Sum of descendants: %d", desc, sum));
		SLLNode<TreeNode<Integer>> tracker = head.getChildren();
		while(tracker!=null) {
			getStats(tracker.getElement());
			TreeNode<String> child = getStats(tracker.getElement());
			child.setParent(output);
			output.addChild(child);
			tracker = tracker.getNext();
			}
		return output;
	}
	
	
	public int descendants(TreeNode<Integer> node, int nod) {
		
		if(node != null) {
			SLLNode<TreeNode<Integer>> tracker = node.getChildren();
			nod++;
			tracker = node.getChildren();
			while(tracker!=null) {
			nod = nod + descendants(tracker.getElement(), 0);
			   
			tracker = tracker.getNext();
			}
		}
		
		
		return nod;
	}
	
	public int sum(TreeNode<Integer> node, int total) {
		
		if(node != null) {
			SLLNode<TreeNode<Integer>> tracker = node.getChildren();
			total = total + node.getElement();
			tracker = node.getChildren();
			while(tracker!=null) {
			total = total + sum(tracker.getElement(), 0);
			   
			tracker = tracker.getNext();
			}
		}
		
		
		return total;
	}
	
	
	
	
	
}



