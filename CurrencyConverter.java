import java.util.Scanner;
public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the currency converter");
          System.out.println("1.USD to Rupee");
System.out.println("2.Rupee to USD");
System.out.println("3.EURO to Rupee");
        System.out.println("4.Rupee to EURO");
        System.out.println("Enter the choice(1 or 2 or 3 or 4)");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.println("Enter the amount in USD");
            double USD=sc.nextDouble();
            double rupee=usdToRupee(USD);
            System.out.println("Converted amount in rupee"+rupee);       
         }
         else if(choice==2){
      System.out.println("Enter the amount in rupee");
      double rupee=sc.nextInt();
      double USD=rupeeToUSD(rupee);
      System.out.println("converted amount in USD"+USD);
         }
         else if(choice ==3){
            System.out.println("Enter the amount in EURO");
            double EURO=sc.nextDouble();
            double rupee=euroToRupee(EURO);
            System.out.println("Converted amount in rupee"+rupee);
         }
         else if(choice==4){
            System.out.println("enter the amount in rupee");
            double rupee=sc.nextDouble();
            double EURO=rupeeToEuro(rupee);
         }
         else{
            System.out.println("Invalid choice. Pleasde select 1 or 2 or 3 or 4");
         }
         sc.close();
 }    
 public static double usdToRupee(double USD){
    return USD*83.47;
 }  
public static double rupeeToUSD(double rupee){
return rupee*0.0119804;
}
public static double euroToRupee(double EURO){
return EURO*89.10;
}

public static double rupeeToEuro(double rupee){
    return rupee*0.0113;
}

        }
