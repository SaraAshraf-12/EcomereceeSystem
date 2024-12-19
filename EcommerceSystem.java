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
