import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class Parser {
	private String FileName = " ";
	BTree tree = new BTree();
	
	
	
	public void openText() {
		this.FileName = "345.txt";
		int count = 0;
		int count2 = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.FileName));
			String line;
			
		    while ((line = reader.readLine()) != null)
		    {
		    		count = count + 1;
		    		//System.out.println(count);
		    		if(line.length() == 0) {
		    			continue;
		    		}
		    		line = removePunc(line);
		    		if (line.length() == 0){
		    			continue;		    		}
		    		String[] y = addToTree(line);
		    		//System.out.println(line);
		    		
		    		for(int p = 0; p < y.length; p++) {
		    		//	System.out.println(count);
		    			tree.add(y[p]);
		    			
		    			System.out.println(count++ + "    " + y[p]);
		    			System.out.println(y[p]);
		    		}
		    		
		    		count2++;
		    } 
		    reader.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//tree.printPreOrder();
		System.out.println(tree.SearchString("transylvania"));
		System.out.println(tree.SearchString("harker"));
		System.out.println(tree.SearchString("renfield"));
		System.out.println(tree.SearchString("vampire"));
		System.out.println(tree.SearchString("expostulate"));
		System.out.println(tree.getDepthB() );
		System.out.println(tree.totalNumberCalc());
		System.out.println(tree.returnAtTree());
		System.out.println(tree.Deep());
		System.out.println(tree.mostFrequency());
		System.out.println(count++);
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public String removePunc(String Line) {
        String newLine = Line.replaceAll("[^a-zA-Z0-9\\s]+","");
        newLine = newLine.toLowerCase();
        return newLine;
    }
    
    public String[] addToTree(String line) {
    		String[] arrayOfString = line.trim().split("[\\s\\t\\n]+"); 	
    		return arrayOfString;
    }
}


