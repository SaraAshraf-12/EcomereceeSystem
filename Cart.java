package ecommercesystem;

public class Cart {
    
 private int customerId;
 private  static int nProducts;       
  private static  Product [] products;

    public Cart( int nProducts,int customerId) {
        this.setCustomerId(customerId);
       this.setnProducts(nProducts);
       this.products =  new Product[nProducts];
      

    }
  

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
           }

    public static int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts=Math.abs(nProducts);
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    public static void addProduct(Product p,int index){//0
        if(index >= nProducts){//0>=3
           System.out.println("Cart is full, cannot add more products.");
            
          }
          else{
        products[index]=p;
        }
      }
    public void removeProduct(int index){
         if (index < 0 || index >= nProducts) {
            System.out.println("Invalid index, cannot remove product.");
            
        }
         else{
        products[index] = null;

         }
    }
   public float calculatePrice(){
       float total=0;
       for (int i = 0; i <products.length; i++) {//products.length=nProducts
           if(products[i]!=null){
           total +=products[i].getPrice();
       } }
       return total;
   }
   public void placeOrder(int o){
       switch(o){
           case 1:
               System.out.println("Here's your order's summary");
               order.PrintInfo();
               break;
           case 2:
               for(int i=0;i<products.length;i++){
                products[i] = null;   
               }
           break;
       } 
   }//methode place order
   
 
 
 
}
