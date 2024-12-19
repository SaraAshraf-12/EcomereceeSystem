package ecommercesystem;
public class order {
    private  static int customerId;
    private static int orderID;
    private  static Product [] products;
    private static float totalPrice;
    public order(int customerId, float totalPrice, Product[] products) {
        this.customerId = customerId;
        //this.totalPrice = Cart.calculatePrice();
        this.products = new Product [Cart.getnProducts()];
        this.orderID = (int) (Math.random() * 100); //  random orderId 
    }
    public static void PrintInfo(){
     System.out.println("Order ID: " + orderID);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Products:");
        for (int i = 0; i < products.length; i++) {
            if(products[i]!=null){
                System.out.println(Product. getName()+Product.getPrice()+"$");
                
            }
                
            
        }
    }
    
    
    
}
