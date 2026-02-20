package code;
public class TheFloodGame { 
    private Node root;
    public TheFloodGame(int length, int width) {
    //width is the horizontal dimension
    //length is the vertical dimension
        //********Creating the first node**************
        int count = 1;
        root = new Node((int)(Math.random()*6+1));
        Node temp;
        Node column_marker = root;
        Node row_marker = root; 
        //*********************************************
        
        //*****Creating the rest of the top row********
        for(int x = 0; x <width-1; x++) {
            temp = new Node((int)(Math.random()*6+1));
            temp.setLeft(column_marker);
            column_marker.setRight(temp);
            column_marker = temp;
        }
        //*********************************************
        for(int q = 0; q < length-1; q++) {
            //**********Making the first node in the row***
            temp = new Node((int)(Math.random()*6+1));
            row_marker.setDown(temp);
            temp.setUp(row_marker);
            row_marker = temp;
            column_marker = temp;
            //*********************************************
            
            //*********Making the rest of the row**********
            for(int x = 0; x < width-1; x++) {
                temp = new Node((int)(Math.random()*6+1));
                temp.setLeft(column_marker);
                column_marker.setRight(temp);
                temp.setUp(cm.getUp().getRight());
                temp.getUp().setDown(temp);
                column_marker = temp;
            }
            //*********************************************
        }

    }
    
    public void display() {
        Node temp = root;
        Node row_marker = root;
        
        while(temp != null) {
            while(temp != null) {
                if(temp.getData() < 10)
                    System.out.print(temp.getData() + "   ");
                else if(temp.getData() < 100)
                    System.out.print(temp.getData() + "  ");
                else
                    System.out.print(temp.getData() + " ");
                temp = temp.getRight();
            }
           
            System.out.println();
            temp = rm.getDown();
            row_marker = temp;
        }  
    }
    
    public void flood(int newNumber) {
    	flood(root, newNumber);
    }
    
    public void flood(Node n, int newNumber) {
    	int oldNumber = n.getData();
    	n.setData(newNumber);
    	
    	if(n.getUp()!=null && n.getUp().getData()==oldNumber)
    		flood(n.getUp(), newNumber);
    	
    	if(n.getRight()!=null && n.getRight().getData()==oldNumber)
    		flood(n.getRight(), newNumber);
    	
    	if(n.getDown()!=null && n.getDown().getData()==oldNumber)
    		flood(n.getDown(), newNumber);
    	
    	if(n.getLeft()!=null && n.getLeft().getData()==oldNumber)
    		flood(n.getLeft(), newNumber);
    	
    }
    
    public boolean check(int number) {
    	return check(root, number);
    }
   
    public boolean check(Node n, int number) {
    	int oldNumber = n.getData();
    	Node temp = root;
        Node row_marker = root;
        
        while(temp != null) {
            while(temp != null) {
                if(temp.getData() !=oldNumber)
                	return false;
                
                temp = temp.getRight();  
            }
           
            temp = row_marker.getDown();
            row_marker = temp;
        }
        return true;
    }
}





  
























	
