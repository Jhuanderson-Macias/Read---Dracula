
public class BTree {
	
	private Node root;
	private int count = 0;
	int totalWordCount = 1;

	
	public void add(String a) {
		if (this.root == null) {
			Node n = new Node();
			n.setData(a);
			System.out.println(a);
			this.root = n;
		} else {
			recAdd(a, this.root);
			
		}
	}
	
	private void recAdd(String a, Node Node) {
		
		if (this.root == null) {
			
			return;
		}
		
		if (a.compareTo(Node.getData()) > 0) {
			if (Node.getLchild() == null) {
				// Add the node here
				System.out.println(a + "Left");
				Node n = new Node();
				n.setData(a);
				Node.setLchild(n);
				
				
			} else {
				recAdd(a, Node.getLchild());
			}
		} else if (a.compareTo(Node.getData())  < 0) {
			// a >= root.getData()...
			if (Node.getRchild() == null) {
				// Add the node here
				System.out.println( a +" Right");
				Node n = new Node();
				n.setData(a);
				Node.setRchild(n);
				
			} else {
				recAdd(a, Node.getRchild());
			}
		}else if (a.compareTo(Node.getData())  == 0) {
			System.out.println(a + "Same");
			Node.setCount(count);
			
			
						
		}
		
	}
	public int SearchString(String a) {
		return search(a, this.root);
	}
	
	public int search(String name, Node root){
		
		
		if (root == null) {
			
			return 0;
		}
		

	        if(root.getData().equals(name)){
	           count = root.getCount();
	        } 
	        			Node Node1 = root.getLchild();
	        			Node Node2 = root.getRchild();
	            		search(name, Node1);
	            		search(name, Node2);
	    return count;
}
	public int totalNumberCalc() {
		return totalNumber(root);
	}
	

	
	public int totalNumber(Node root){
		
		
		if (root == null) {
			
			return 0;
		}
	        			count = count + 1;
	        			Node Node1 = root.getLchild();
	        			Node Node2 = root.getRchild();
	        			totalNumber(Node1);
	        			totalNumber(Node2);
	            		
	            		
	    return count;
}

	public String returnAtTree() {

		if (root == null) {
			
			return "Empty";
		}
		
		return root.getData();
	}
	
	public String mostFrequency() {
		int freq = mostFrequentcalc(root).getCount();
		String word = mostFrequentcalc(root).getData();
		
		return word + " is the most freuqently used word with " + freq + " times"; 
	}
	
	private int lowestFreq = 0;
	private Node mostFrequentcalc(Node root) {
		if (root == null) return root;
		
		if(root.getCount() > lowestFreq)
			lowestFreq = root.getCount(); 
		
		 mostFrequentcalc(root.getLchild());
		 mostFrequentcalc(root.getRchild());

		return root;
	}
	
	public String Deep() {
		return DespestCalc(root, 0);
		
	}
	
	private int deepestlevel = 0;
	private String data;
	public String DespestCalc(Node root, int level) {
		
		if (root != null) {
			
			DespestCalc(root.getLchild(), ++level);
			if (level > deepestlevel) {
				data = root.getData();
				deepestlevel = level;
			}
			
			DespestCalc(root.getRchild(), level);
		}
		return data;
	}

	
	
	public int getDepthB() {
		return getDepth2(root, 0);
	}
	
	private int getDepth2(Node root, int count) {
		if (root == null) return count-1;
		
		int left = getDepth2(root.getLchild(), count+1);
		int right = getDepth2(root.getRchild(), count+1);
		
		if (left > right) {
			return left;
		} else {
			return right;
		}
		
	}

	

	/*
	private void recAdd(Integer a, Node root) {
		
		if (root == null) {
			return;
		}
		
		if (a < root.getData()) {
			if (root.getLchild() == null) {
				// Add the node here
				Node n = new Node();
				n.setData(a);
				root.setLchild(n);
			} else {
				recAdd(a, root.getLchild());
			}
		} else {
			// a >= root.getData()...
			if (root.getRchild() == null) {
				// Add the node here
				Node n = new Node();
				n.setData(a);
				root.setRchild(n);
			} else {
				recAdd(a, root.getRchild());
			}
			
		}
		
	}
	
	public int getDepthB() {
		return getDepth2(root, 0);
	}
	
	private int getDepth2(Node root, int count) {
		if (root == null) return count-1;
		
		int left = getDepth2(root.getLchild(), count+1);
		int right = getDepth2(root.getRchild(), count+1);
		
		if (left > right) {
			return left;
		} else {
			return right;
		}
		
	}
	
	
	private int max;
	public int getDepth() {
		max = 0;
		recDepth(root, 0);
		return max;
	}
	
	private void recDepth(Node root, int counter) {
		if (root == null) return;
		if (counter > max) max = counter;
		recDepth(root.getLchild(), counter+1);
		recDepth(root.getRchild(), counter+1);
	}
	
	public void printPreOrder() {
		String rtn = "";
		rtn = recPrintPreOrder(root, rtn);
		System.out.println(rtn);
	}
	
	private String recPrintPreOrder(Node root, String rtn) {
		if (root == null) {
			return "";
		}
		rtn += root.getData() + " " +
		       recPrintPreOrder(root.getLchild(), rtn) +
		       recPrintPreOrder(root.getRchild(), rtn);

		//rtn += recPrintPreOrder(root.getRchild(), rtn);
		return rtn;
	}
	
	public void printInOrder() {
		recPrintInOrder(root);
		System.out.println();
	}
	
	private void recPrintInOrder(Node root) {
		
		if (root == null) return;
		
		recPrintInOrder(root.getLchild());
		System.out.print(root.getData() + " ");
		recPrintInOrder(root.getRchild());
	}
	
	public void printPostOrder() {
		recPrintPostOrder(root);
		System.out.println();
	}
	
	private void recPrintPostOrder(Node root) {
		if (root == null) return;

		recPrintPostOrder(root.getLchild());
		recPrintPostOrder(root.getRchild());
		System.out.print(root.getData() + " ");
	}
	
	public boolean search(Integer n) {
		return false;
	}
	

 */
public void insertWord(String newItem, Node Node) {
    // Add the word to the binary sort tree to which the
    // global variable "root" refers.  Duplicate entries
    // will be ignored!  All words are converted to lower case.

	if (root == null) {
		return;
	}


  if ( newItem.equals(Node.getData()) ) {
          // The word is already in the tree.  Don't insert
          // another copy.  Just return.
      return;
  }
  if ( newItem.compareTo(Node.getData()) < 0 ) {
           // Since the new item is less than the item in runner,
           // it belongs in the left subtree of runner.  If there
           // is an open space at runner.left, add a node there.
           // Otherwise, advance runner down one level to the left.
     System.out.print("ADDING");
	  if ( root.getLchild()  == null ) {
    	 	Node n = new Node ();
    	 	n.setData(newItem);
    	 	
    	 	Node.setLchild(n);
        // New item has been added to the tree.
     }
     else
    	 insertWord(newItem, Node.getLchild());
  }
  else {
           // Since the new item is greater than or equal to the 
           // item in runner, it belongs in the right subtree of
           // runner.  If there is an open space at runner.right, 
           // add a new node there.  Otherwise, advance runner
           // down one level to the right.
     if ( root.getRchild() == null ) {
    	 	Node n = new Node ();
 	 	n.setData(newItem);
    	 
 	 	Node.setRchild(n); 
          // New item has been added to the tree.
     }
     else
    	 insertWord(newItem, Node.getRchild());
   }
// end while
}
}// end insertWord()

