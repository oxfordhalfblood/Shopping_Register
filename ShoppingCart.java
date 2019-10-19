
/*
 * CSIT111 Assignment 3 
 * Student name:   Brody Brown
 * Student user ID:  bb879 
 * Student number:  6116310
 */  

import java.util.Scanner;
import java.io.*;
import static java.lang.Math.pow;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
        
	//private Product[] items= new Product[100];
	List<Product> itemlist = new ArrayList<Product>();
	private int total_items;
	private int totalcarts;
	
	public void addItem(Product item)
	{
		//System.out.println("totalitem=: " + total_items);
		
		if(total_items ==0)
		{
			totalcarts++;
			//totalcust++;
			//System.out.println("item is now 0 so" + totalcarts);
		}
		
		 total_items++;

		itemlist.add(item);
		//items[total_items-1]= item;
	}
	
	public int getTotalitems()
	{
		 return total_items;
	}
	
	public int getTotalcarts()
	{
		return totalcarts;
	}
	
	
	
	public List<Product> getItems(){
        return itemlist;
    }
	
	public List<Product> unloadAllItems() { 
	
		//totalcarts--;
		List<Product>  newItems = new ArrayList<Product>();
		
        for(int i=0; i<total_items; i++){
			
			newItems.add(itemlist.get(i));
			
		}
		
		total_items=0;
		
	return newItems; 
	}
	

}
    
   
