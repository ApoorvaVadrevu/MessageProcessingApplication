package messages;
import java.io.*;
import java.util.*;
import java.util.Map.*;
class Message2
{
     public void process2(){
    	
  
      try{
    	  // Creating 2 hashmaps for reading product as key and quantity,price as values
    	  
 HashMap<String,Integer> map=new HashMap<String,Integer>();
 HashMap<String,Integer> map1=new HashMap<String,Integer>(); 
 // Creating arraylists for reading Adjust and Product
 ArrayList<Adjust> list1=new ArrayList<Adjust>();
 ArrayList<Product> list=new ArrayList<Product>();	 
	  Integer count=0;
	  Integer count1=0;
	  //Reading Input file
	        File file=new File("src/messages/data.txt");

	        Scanner s=new Scanner(file);

	        while(s.hasNextLine()){

	           String t=s.nextLine();
	            String[] w=t.split(",");
	            count++;

	            Product p=new Product(w[0],Integer.parseInt(w[1]),Integer.parseInt(w[2]));
	            list.add(p);
            
         if(map.get(w[0]) != null)

        {

            map.put(w[0],(map.get(w[0])+Integer.parseInt(w[1])));

        }

        else{

            map.put(w[0],Integer.parseInt(w[1]));

        }

     if(map1.get(w[0]) != null)

        {
                map1.put(w[0],(map1.get(w[0])+Integer.parseInt(w[2])));
        }
     else{

             map1.put(w[0],Integer.parseInt(w[2]));
}
}
	        //Reading the data for performing adjustments operation 
	        File file1=new File("src/messages/adjustments.txt");

	        Scanner s1=new Scanner(file1);

	    // Calculating number of occurances of each product and the total price they were sold at     
      while(s1.hasNextLine()){

          String t1=s1.nextLine();
           String[] w1=t1.split(",");
           count++;
           Adjust p1=new Adjust(w1[0],w1[1],Integer.parseInt(w1[2]));
           list1.add(p1);
      }
        Set<Entry<String,Integer>> hashSet=map.entrySet(); 
        Set<Entry<String,Integer>> hashSet1=map1.entrySet(); 
        for(Entry entry:hashSet ) {           

            System.out.println(entry.getKey()+" has " +entry.getValue()+ "number of occurances");  
            System.out.println();
        }
        
        for(Entry entry1:hashSet1 ) {           

            System.out.println(entry1.getKey()+" were sold at a total price of "+entry1.getValue());     
            System.out.println();
        
        }
        
        int c=0;
     
        Set<Entry<String,Integer>> hashSet3=map.entrySet(); 
     int price=0;
     int quantity=0;
System.out.println("Adjustment report after the 50 occurances");
        for(Adjust test: list1)
		   {
        	c=0;
	               // Performing the adjustment operations - Add,Subtract,Multiply 	
	                		for(Product k:list){
	                		//Set<Entry<String,Integer>> hashSet2=map1.entrySet(); 
	    	                //for(Entry entry2:hashSet2 ) {
	    	                	for(Entry entry3:hashSet3){
	    	                		if(test.task.equals("add"))
	    		    	        	{
	                	if( test.product.equals(k.p_name)&&test.product.equals(entry3.getKey())&&c==0)
	                	{c=1;
	                		//price=(int) entry2.getValue();
	                		quantity=(int) entry3.getValue();
	                	System.out.println(entry3.getKey()+" New Adjusted Price: "+((k.p_price*quantity)+test.value));
	                	}
	    	                	}
	                }
	    	        	}
	                		for(Product k:list){
		                		//Set<Entry<String,Integer>> hashSet2=map1.entrySet(); 
		    	                //for(Entry entry2:hashSet2 ) {
		    	                	for(Entry entry3:hashSet3){
		    	                		if(test.task.equals("subtract"))
		    		    	        	{
		                	if( test.product.equals(k.p_name)&&test.product.equals(entry3.getKey())&&c==0)
		                	{c=1;
		                		
		                		quantity=(int) entry3.getValue();
		                	System.out.println(entry3.getKey()+" New Adjusted Price: "+((k.p_price*quantity)-test.value));
		                	}
		    	                	}
		                }
		    	        	}
	                		
	                		for(Product k:list){
		                		
		    	                	for(Entry entry3:hashSet3){
		    	                		if(test.task.equals("multiply"))
		    		    	        	{
		                	if( test.product.equals(k.p_name)&&test.product.equals(entry3.getKey())&&c==0)
		                	{c=1;
		                		
		                		quantity=(int) entry3.getValue();
		                		
		                	System.out.println(entry3.getKey()+" New Adjusted Price: "+((k.p_price*quantity)*test.value));
		                	}
		    	                	}
		                }
		    	        	}

	        		
		   }

      }
catch(FileNotFoundException f){

	        System.out.println("File not Found");
	    }

     }
}
   
	 

