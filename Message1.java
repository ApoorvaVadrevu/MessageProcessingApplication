package messages;
import java.util.*;
import java.io.*;

class Message1{

public void process(){

	ArrayList<Product> list=new ArrayList<Product>();
	 
	  Integer count=0;
	  Integer count1=0;
	 try {
		// reading the input file
	        File file=new File("src/messages/data.txt");

	        Scanner s=new Scanner(file);

	        while(s.hasNextLine()){

	           String t=s.nextLine();
	            String[] w=t.split(",");
	        count1=count++;
//writing the inputs into list
	            Product p=new Product(w[0],Integer.parseInt(w[1]),Integer.parseInt(w[2]));
	            list.add(p);
              }
	      
             for(Product q: list)
	            		   {
            	
            	//printing the details of each sale
	            		System.out.println("Product Name:" +q.p_name + " Product Quantity: " + q.p_quantity + "  Price of each item sold:"+q.p_price); 
	            		System.out.println();
	            		   
	            		   }
             // pausing the application after receiving the inputs
             if(count1==50)
             {
            	 System.out.println("APPLICATION PAUSED logging all the 50 messages received");
            	
             }

}

 catch(FileNotFoundException f){

	        System.out.println("File not Found");
	    }
}
}