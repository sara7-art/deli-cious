Deli-cious is a Java console application that allows customers to create and customize sandwich orders. The application demonstrates Object-Oriented Programming (OOP) principles while simulating a real Point of Sale system for a sandwich shop.

Customers can:

Create custom sandwiches
Order signature sandwiches
Add drinks and chips
Customize toppings
View order details and pricing
Checkout and save receipts

Customers can create sandwiches with:

Sizes: 4", 8", 12"
Bread Types:
White
Wheat
Rye
Wrap

Toasted option
Premium Toppings
Meats
Steak
Ham
Salami
Roast Beef
Chicken
Bacon

Extra meat is available for an additional charge.

Cheeses
American
Provolone
Cheddar
Swiss

Extra cheese is available for an additional charge.

Regular Toppings
Lettuce
Peppers
Onions
Tomatoes
Jalapenos
Cucumbers
Pickles
Guacamole
Mushrooms

Drinks
Small
Medium
Large

Chips
Single size available

Signature Sandwiches
*BLT
8" White Bread
Bacon
Cheddar
Lettuce
Tomato
Toasted

*Philly Cheese Steak
8" White Bread
Steak
American Cheese
Peppers
Toasted
OOP Concepts Used
Encapsulation

Private fields are used throughout the application with getters and setters to protect data.

Examples:

Product
Sandwich
Drink
Chips
Topping

Several classes inherit from parent classes.

Examples:

Sandwich extends Product
Drink extends Product
Chips extends Product
BLT extends Sandwich
PhillyCheeseSteak extends Sandwich

The application uses the Priceable interface to define pricing behavior.

#Polymorphism
Orders store different product types using: ArrayList<Product>
This allows Sandwich, Drink, and Chips objects to be treated as Product objects.

#Abstraction
The Product class is abstract and serves as the foundation for all products.

Project Structure

|______________
com.pluralsight:
________

model( Priceable.java, Product.java, Topping.java, Sandwich.java, Drink.java, Chips.java, Order.java)

________

ui (HomeScreen.java, OrderScreen.java)
 
_________

service (CheckoutService.java)

_________

signature (BLT.java, PhillyCheeseSteak.java)

________

Program.java

#Receipt
Receipts are automatically saved when an order is confirmed.

Receipt files are stored in:

receipts/

Example:

receipts/
// 20260528-154403.txt
// 20260528-153951.txt

Each receipt file name is generated using the current date and time.

How to Run
Open the project in IntelliJ IDEA.
Run Program.java.
Select menu options.
Create an order.
Proceed to checkout.
Confirm the order.
Receipt will be saved automatically.
