# Shopping_Register
This is a Java Application which stores supershop's products and prices, tracks customer's cart and prints a receipt from Cash Register while customer bills out.

POSmain:
Take threefile names from command line arguments. The first file contains  a  list  of  products and theirprices;  the  second and  third  files  are  lists of  items  in  two shopping carts of two customers.

ShoppingCart: Each of the cart files load a list of items in a shopping cart and store them in this class's object .

CashRegister: POSmain will create a CashRegister object by passing the price list to it. CashRegisterobject  scans  items  in  a  cart  and  print  a  receipt  for each  shopping  cart  one  by  one.  At  last, print  a report for the day.
