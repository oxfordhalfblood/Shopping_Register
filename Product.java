/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/


import java.util.Scanner;
import java.io.*;
import static java.lang.Math.pow;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


    public class Product /*implements Comparable<Product>*/{
        
        private String name;
    	private double price;
    	private int productID;
    	private static int total=0;


      Product(String item, double price) {
        
          this.name=item;
          this.price=price;
          //System.out.println("Constructor of  class."+ item +" "+price);
          this.total=total+1;
          this.productID = total;
		  //System.out.println("prodid :"+ productID + " total "+ total);
      }
	  
	   public String getName(){
		//System.out.println("getname: "+name);
		return name;
    	}
    	
    	public double getPrice(){
    		return price;
    	}
    	
    	public void changePrice(double newPrice){
    		price = newPrice;
    	}
    	
    	public int getProductID(){
			//System.out.println("from function: "+productID);
    		return productID;
    	}
    	
    	public int getTotal(){
    		return total;
    	}
		
		public String displaylist()
		{
			return this.name + " "+this.price+" "+this.total;
		}
		
		/* @Override
		public int compareTo(Product compareprod) {
        String comparename=compareprod.getName();
        // For Ascending order
        return this.studentage-compareage;
		return name-comparename;

        // For Descending order do like this 
         return name.compareTo(comparename);
    } */
	  
    }
    
   
