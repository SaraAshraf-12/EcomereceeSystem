package ecommercesystem;
   public class Product {//Super class
   private int productId;//must be positiveor take abs
   private static String name;
   private  static float price;//must be positive or take absolute

    public Product(int productId, String name, float price) {
        this.setProductId(productId) ;
        this.name = name;
        this.setPrice(price);
    }
   

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId=Math.abs(productId);
    }
    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  static float getPrice() {
        return price;
    }

    public void setPrice(float price) {
         this.price =Math.abs(price);
    }
   
    
    
} 

