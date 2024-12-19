package ecommercesystem;
    public class ElectronicProduct extends Product {//productId,name,price
   private String brand;
   private int warrantyPeriod;//must be positive or take absolute 

    public ElectronicProduct(String brand, int warrantyPeriod, int productId, String name, float price) {
        super(productId, name, price);
        this.brand = brand;
        this.setWarrantyPeriod(warrantyPeriod);
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
