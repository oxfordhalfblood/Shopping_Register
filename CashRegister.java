/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

 */  

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import static java.lang.Math.pow;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;


public class CashRegister{

	private int totalItems;
	private double totalSale ;
	private double totalsubtotal;
	private double totalofcart;
	private int size;
	private int customerCount;
    private HashMap<String, Integer> productsSold=new HashMap<String, Integer>();
	
	List<Integer> productIDs = new ArrayList<Integer>();  //this will give quantity
	List<Double> productprices = new ArrayList<Double>();  // this will give subtotal
	
	List<Product> products= new ArrayList<Product>();
	List<Product> cartproducts= new ArrayList<Product>();
	List<String> names= new ArrayList<String>();
	
			DecimalFormat df2= new DecimalFormat("#.##");

	
	 CashRegister(List <Product> p)
	 {
		 this.products=p;
		 this.size=p.size();
		 
		 for(int i=0; i<size+1; i++)
		 {
			 this.productIDs.add(i,0);
			 //System.out.println("size "+size);
			 this.productprices.add(i,0.0);
			 this.names.add(i,"");
		 }
	 }

	public void scanProduct(Product item){
		
		this.totalsubtotal  += item.getPrice();
		//System.out.println("now totalsale:"+ totalSale);
		this.totalItems++;
		
		int id=item.getProductID();
		//System.out.println(item.getName()+ " is: "+ id );
		int sum=productIDs.get(id);  //0
		//System.out.println(sum);   //0.0
		double oldprice=productprices.get(id);
		//System.out.println(oldprice);
		double newprice=item.getPrice();
		//System.out.println(newprice);
		
		this.productIDs.set(id,sum+1);  //1, 1; 2,1 . 2,2, 
		//System.out.println("id: "+ id + ", sum= " +(sum+1)); 
		this.productprices.set(id,oldprice+newprice);
		//System.out.println("product quantity: "+ productIDs.get(id) + ", newprice added "+ (oldprice+newprice));
		this.names.add(id,item.getName());
		
		//this.productID[item.getproductID()]++;
		//this.productprices[item.getproductID()]=item.getprice();
		
	}
	
	public double getPurchase(){
		double a=this.totalsubtotal;
		this.totalSale+=this.totalsubtotal;
		this.totalsubtotal=0;
		return a;
	}
	
	public double gettotalsale()
	{
		return this.totalSale;
	}
	
	public int getTotal(){
		
		return this.totalItems;
	}
	
	public void scanAllItems(List<Product> itemlist)
	{
		this.cartproducts=itemlist;
		
		for(Product t : itemlist)
		{		
			scanProduct(t);
		}  
	}
	
	
	
	public void printreceipt(ShoppingCart cart)
	{
		//System.out.println( "One customer is checking out ...");
	    System.out.println( "=====================================");
        System.out.println("Product     Price   Qty     Subtotal");
        System.out.println( "-------------------------------------");
		
		 List<Product> purchaseItems = cart.getItems();
         List<Product> cartproducts = new ArrayList<>(); 
        Set<Product> set = new HashSet<>(purchaseItems);  			// Finding Unique Items In Cart
        cartproducts.addAll(set);
		
		for(Product item : cartproducts)
		{
			//System.out.println(p.getProductID()); 				// gives all the product ids
			
			String pname=item.getName();
			double unitprice=item.getPrice();
			int qty=productIDs.get(item.getProductID());
			double subtotal= productprices.get(item.getProductID());
			
			System.out.println(pname + "         " +"$" + unitprice+"       " +qty + "       " + "$"+ subtotal); // gives quantity
			
		
			//if (productsSold.containsKey(item)){
			productsSold.put(item.getName(), qty);
			//productsSold.put("ghd", 2);

           // } else {
             //   productsSold.put(item.getName(), qty);
           // }
	
		}
		
		//System.out.print("total of subtotal " + getPurchase());
		
       // System.out.println( "Bed" + "         " + "$" + "       " + "2" + "       " + "$"     );
       
        System.out.println( "   -------------------------");
        System.out.println("         Total             "+ df2.format(getPurchase()));
        System.out.println( "=====================================");
		customerCount++;
	}
	
	public void sortbykey()
	{
		ArrayList<String> sortedKeys = new ArrayList<String>(productsSold.keySet()); 
		
		Collections.sort(sortedKeys);
		
	}
	
	public void printreport()
	{
		
        System.out.println("Report for the day");
        System.out.println( "=====================================");
        System.out.println("Number of Customers: " + customerCount);
        //print("Total Sale: $" + df.format(totalSale));
        System.out.println("List of products sold:");
        System.out.println( "-------------------------");
        System.out.println("Product Qty");
        System.out.println( "-------------------------");
		
		ArrayList<String> sortedKeys = new ArrayList<String>(productsSold.keySet()); 
		
		Collections.sort(sortedKeys);
		
        for (String key : sortedKeys) 
		{
            System.out.println(key + " " + productsSold.get(key));
        }

	}
	
	
	
}   
   
