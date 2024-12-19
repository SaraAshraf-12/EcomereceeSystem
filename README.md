package ecommercesystem;
import java.util.Scanner;
public class EcommerceSystem {
    public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    ElectronicProduct E1=new ElectronicProduct("Samsung",1,1,"smartphone",599.9f); 
    ClothingProduct C1=new ClothingProduct("Medium","cotton",2,"T-shirt",19.99f);
    BookProduct B1=new BookProduct("O’Reilly","X Publications",3,"OOP",39.99f);
        System.out.print("Please enter your ID:");
        int ID=Math.abs(input.nextInt());
        System.out.println("Please enter your name:");
        String Name=input.next();
        System.out.print("Please enter your address:");
        String Address=input.next();
    Customer C2=new Customer(ID,Name,Address);
        System.out.print("How many products you want to add to your cart? ");
        int nProducts=input.nextInt();
        for (int i = 0; i < nProducts ; i++) {
             System.out.println("Which product would you like to add?\n1-Smart Phone\n2-T-Shirt\n3-OOP");
        int choosen=input.nextInt();
        switch(choosen){
            case 1:
            Cart.addProduct(E1,i);
            break;
            case 2:
                Cart.addProduct(C1, i);
                break;
            case 3:
                Cart.addProduct(B1, i);
                break;
            default:
                System.out.println("invalid choice!");
                break;
        }//switch  
        }//for
        Cart A=new Cart(nProducts,ID);

        System.out.println("Your total's "+A.calculatePrice()+"$."  + "Would you like to place the order? 1-Yes  2-No");
        int o=input.nextInt();//yes or no
        A.placeOrder(o);
    }//main 
}
package ecommerecesystem;
public class Product {//Super Class to 3 Classes
    protected int productId;
    protected String name;
    protected float price;
    
    //Constructor that ew call in subclasses
    public Product(int productId, String name, float price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
        public int getProductId() {
        return productId;
    }
        
     public void setProductId(int productId) {
        this.productId=Math.abs(productId);
    }
     
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return price;
    }
    
  public void setPrice(float price) {
         this.price =Math.abs(price);
    }
  
}
package ecommerecesystem;
public class ElectronicProduct extends Product {//subclass
     private String brand;
    private int warrantyPeriod;
    
    //Constructor
    public ElectronicProduct(String brand, int warrantyPeriod, int productId, String name, float price) {
        super(productId, name, price);//call super constructor
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
    
    public void setWarrantyPeriod(int warrantyPeriod) {
       this.warrantyPeriod =Math.abs(warrantyPeriod);
    }
    
}
package ecommerecesystem;
public class ClothingProduct extends Product {//subclass
    private String size;
    private String fabric;
    
    //constructor
    public ClothingProduct(String size, String fabric, int productId, String name, float price) {
        super(productId, name, price);//call super constructor
        this.size = size;
        this.fabric = fabric;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getFabric() {
        return fabric;
    }
    
    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
    
}
package ecommerecesystem;
public class BookProduct extends Product {//subClass
    private String author;
    private String publisher;
    
    //Constructor
    public BookProduct(String author, String publisher, int productId, String name, float price) {
        super(productId, name, price);//Call super constructor
        this.author = author;
        this.publisher = publisher;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
}package ecommerecesystem;
public class Customer {
    protected int customerId;
    protected String name;
    protected String address;
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
       this.customerId =Math.abs(customerId); 
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }  
    
}
package ecommerecesystem;
public class Cart {
    protected int customerId;
    protected int nProducts;
    protected Product[] products;
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
           }
    public int getnProducts() {
        return nProducts;
    }
     public void setnProducts(int nProducts) {
        this.nProducts=Math.abs(nProducts);
        products=new Product[nProducts];//Creat Array in memory
    }
    public Product[] getProducts() {//use this in Order class to print the Order
        return products;
    }
    public void setProducts(Product[] products) {//Can remove this becouse we create this array in memory in SetNproductts
        this.products = new Product[nProducts];
    }
    //Methode to add product in the Array
public  void addProduct(Product p){
        for (int i = 0; i <nProducts; i++) {
      if(products[i]==null){
         products[i]=p;
         return;//Exit from All Function not like break
      }}
          System.out.println("the cart is full,can not add more products.");
      }
//Methode to Remove any product from array
public void removeProduct(int tran){
         if (tran >=0&& tran< nProducts) {
            products[tran] = null;
        }
         else{
            System.out.println("cannot remove product.");
         } 
    }
//Methode to calculate the total price of Order
public float calculatePrice(){
       float total=0;
       for (int i = 0; i <products.length; i++) {//products.length=nProducts
           if(products[i]!=null){
           total +=products[i].getPrice();
       } }
       return total;
   }
//Methode to confirm the order
   public void placeOrder(int o){
       switch(o){
           case 1:
               System.out.println("Now, your Order is been Confirmed.");
               break;
           case 2:
               for(int i=0;i<products.length;i++){
                products[i] = null;   
               }
           break;
       } 
 }//methode place order
}
package ecommerecesystem;
public class Order {
    private int customerId, orderId;
    private Product[] products;
    private float totalPrice;
    //int counter;
    
    //Constructor
    public Order(Cart A) {//Associations  
        //counter++;
        this.customerId =A.getCustomerId();
        this.orderId =(int) (Math.random() * 100);
         //this.orderId=Math.abs(counter);
        this.products=A.getProducts();
        this.totalPrice =A.calculatePrice();
    }
    
    //Methode to print name and Price
 public  void printOrderInfo() {
        System.out.println("Here's your order's summary: ");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Total Price:" + totalPrice+"$");
        System.out.println("Ordered Products:");
      for (int i=0;i<products.length;i++) {
            if ( products[i]!= null) {
                System.out.println("name:"+products[i].getName() );
                System.out.println("price:"+products[i].getPrice()+"$");
            }
        }
     System.out.println("total price: "+totalPrice+"$");
 }
}


