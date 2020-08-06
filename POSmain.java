/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/


import java.util.Scanner;
import java.io.*;
import static java.lang.Math.pow;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Collections;


public class POSmain
{

	public static void main(String[] args) throws IOException {

		FileInputStream file1=new FileInputStream(args[0]); //prices
		FileInputStream file2=new FileInputStream(args[1]); //cart1
		FileInputStream file3=new FileInputStream(args[2]);  //cart2

		Scanner sc1 = new Scanner(file1);
		Scanner sc2 = new Scanner(file2);
		Scanner sc3 = new Scanner(file3);
	  
		List<Product> prodlist = new ArrayList<Product>();
				
		DecimalFormat df2= new DecimalFormat("#.##");
		
		/* DataInputStream in = new DataInputStream(file1);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		 */

		
		while (sc1.hasNextLine())   {

			 String line = sc1.nextLine();
			 String[] tokens = line.split("\\s+");
				
			 String fitem = tokens[0];
			 Double fprice = Double.parseDouble(tokens[1]);
		   
			Product obj = new Product(fitem,fprice);
			prodlist.add(obj);
		
		
			/* for(Product p : prodlist)
			{
					
				System.out.println( "Arraylist : "+ p.displaylist());

			}  */ 
			
            
		}
		
		//Collections.sort(prodlist);
			
       sc1.close();
	   
	   // Create a ShoppingCart object
		ShoppingCart cart1 = new ShoppingCart();
	   
	   while (sc2.hasNextLine())   {

			 String line = sc2.nextLine();
			 String[] token = line.split("\\s+");
			 String word = token[0];
			 
			 for(int i=0; i<prodlist.size(); i++)
			{
				Product prod=prodlist.get(i);
	
				if( word.equals(prod.getName()))
				{
					cart1.addItem(prodlist.get(i));
					break;

				}
			}
			 
			/* for(int i=0; i<prodlist.size(); i++)
			{
				
				//System.out.println(item.getName());
				System.out.println(prodlist.contains(line));
				Product prod=prodlist.get(i);
				
				if(line.equals(prod.getName()))
				{
					int ind = i;
					System.out.println(i);
					/* System.out.println("index"+prodlist.indexOf(item));
					int ind=prodlist.indexOf(item); 
					break;

				}
			} 
			*/
			 
			 //int i=getIndexbyname(line, prodlist);
			 //System.out.println("indexsec "+i);
			 //cart1.addItem(prodlist.get(i));
	  
			// Add items to the shopping cart
			//for(int i=0; i< prodlist.size(); i++){
				//System.out.println( prodlist.get(i).displaylist());
				
				//int ind=prodlist.indexOf(line);

				//cart1.addItem(line);
				
		//	}
			

			/* Product obj = new Product(fitem,fprice);
			prodlist.add(obj);
		
			for(Product p : prodlist)
			{
					
					System.out.println( p.displaylist());

			} */
            
		}
		
		
		System.out.println(cart1.getTotalcarts() + " customer(s) in checking out with " + cart1.getTotalitems() + " items");	
		sc2.close();
	   
	   
	   // Create a ShoppingCart object
		ShoppingCart cart2 = new ShoppingCart();
	   
	   while (sc3.hasNextLine())   {

			 String line = sc3.nextLine();
			 String[] token = line.split("\\s+");
			 String word = token[0];
			
			 for(int i=0; i<prodlist.size(); i++)
			{
				Product prod=prodlist.get(i);
	
				if( word.equals(prod.getName()))
				{
					cart2.addItem(prodlist.get(i));
					break;

				}
			}
			 
			 
			 
	
            
		}
		
		sc3.close();
		
		//System.out.println("Scan all items in the shopping cart");
		
		// ~~~~~~~~~~~~~~~~ CART1 ~~~~~~~~~~~~~~~~~~~

		// Create a CashRegister object
		CashRegister register = new CashRegister(prodlist);
		List<Product> itemlist=cart1.unloadAllItems();
		register.scanAllItems(itemlist);
		register.printreceipt(cart1);

// ~~~~~~~~~~~~~~~~ CART2 ~~~~~~~~~~~~~~~~~~~
		
		
		System.out.println(cart2.getTotalcarts()+ " customer(s) in checking out with " + cart2.getTotalitems() + " items");
		
		register.scanAllItems(cart2.unloadAllItems());
		register.printreceipt(cart2);
		
		
		
		System.out.println("Total purchase:  $" + df2.format(register.gettotalsale()));
		//System.out.println("Total items:  " + register.getTotal());
		
		int totalcust=cart1.getTotalcarts()+cart2.getTotalcarts();
/* 		System.out.println("No of customers "+ totalcust);
 */		
		register.printreport();
		
	}
     
	  /*
	   ShoppingCart obj=new ShoppingCart();
	  
	    DataInputStream in = new DataInputStream(file2);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;

        
	  
	  */
	  

	 


	
	
	/* public static int getIndexbyname(String prodname, List<Product> prodlist)
	{
		for(Product item : prodlist)
		{
			if( prodname.equals(item.getName()))
				return prodlist.indexOf(item);
		}
		
		return -1;
	}
	 */
	



}

//javac POSmain.java
//java POSmain prices.txt cart1.txt cart2.txt
