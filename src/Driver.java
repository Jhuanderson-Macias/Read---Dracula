
public class Driver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
		
	}
	
	public void doIt() {
		BTree tree = new BTree();
		/*
		BTree tree = new BTree();
	
		tree.add(50);
		tree.add(2);
		tree.add(75);
		tree.add(4);
		tree.add(60);
		tree.add(100);
		tree.add(3);
		tree.add(6);
		
		tree.printPreOrder();
		tree.printInOrder();
		tree.printPostOrder();
		System.out.println(tree.getDepth());
		System.out.println(tree.getDepthB());
		*/
		
		Parser parse = new Parser();
		parse.openText();
		//tree.add("boy");
		//tree.add("boy");
		//tree.add("boy");
		//tree.add("asam");
		//tree.add("jam");
		//tree.add("zoo");
		//System.out.println(tree.SearchString("boy"));

		
	}

}
