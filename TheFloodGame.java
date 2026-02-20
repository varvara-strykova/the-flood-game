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
        Node cm = root;
        //cm = column marker
        Node rm = root;
        //rm = row marker
        //*********************************************
        
        //*****Creating the rest of the top row********
        for(int x = 0; x <width-1; x++) {
            temp = new Node((int)(Math.random()*6+1));
            temp.setLeft(cm);
            cm.setRight(temp);
            cm = temp;
        }
        //*********************************************
    
        for(int q = 0; q < length-1; q++) {
            //**********Making the first node in the row***
            temp = new Node((int)(Math.random()*6+1));
            rm.setDown(temp);
            temp.setUp(rm);
            rm = temp;
            cm = temp;
            //*********************************************
            
            //*********Making the rest of the row**********
            for(int x = 0; x < width-1; x++) {
                temp = new Node((int)(Math.random()*6+1));
                temp.setLeft(cm);
                cm.setRight(temp);
                temp.setUp(cm.getUp().getRight());
                temp.getUp().setDown(temp);
                cm = temp;
            }
            //*********************************************
        }

    }
    
    public void display() {
        Node temp = root;
        Node rm = root;
        
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
            rm = temp;
            
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
        Node rm = root;
        
        while(temp != null) {
            while(temp != null) {
                if(temp.getData() !=oldNumber)
                	return false;
                
                temp = temp.getRight();  
            }
           
            temp = rm.getDown();
            rm = temp;
        }
        return true;
    }
}





  























	