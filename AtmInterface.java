import java.util.*;
class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        this.balance=initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposit Successful.New Balance"+balance);
        }
        else{
            System.out.println("invalid amount for deposit");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount <=balance){
            balance-=amount;
            System.out.println("Withdrawl Successful.New balance"+balance);
        }
        else{
            System.out.println("Insufficient amount for withdrawl");
        }
    }
}
class ATM{
    private BankAccount account;
    private Scanner sc;
    public ATM(BankAccount account){
        this.account=account;
        this.sc=new Scanner(System.in);
    }
    public void showMenu(){
        System.out.println("1.CheckBalance");
        System.out.println("2.Deposit");
        System.out.println("3.withdrawl");
        System.out.println("4.Exit");
    }
    public void run(){
        int choice;
        do { 
           showMenu(); 
           System.out.println("Enter your choice:");
           choice=sc.nextInt();
           switch(choice){
            case 1: 
             checkBalance();
                    break;
           case 2:deposit();
           break;
           case 3:
           withdraw();
           break;
           case 4: 
           System.out.println("Thank You for using the ATM");
           break;
           default:
           System.out.println("Invalid choice.please select a valid option");
           }
         }while(choice !=4);
}private void checkBalance(){
    System.out.println("Your current balance is:"+account.getBalance());
}
private void deposit(){
    System.out.println("enter the amount to deposit");
    double amount=sc.nextDouble();
    account.deposit(amount);
}
private void withdraw(){
    System.out.println("Enter the amount to withdraw");
    double amount=sc.nextInt();
    account.withdraw(amount);
}
}
public class AtmInterface {
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!!");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your 4 digit pin:");
        int enteredPin=sc.nextInt();
        BankAccount userAccount=new BankAccount(1000.00);
        ATM atm=new ATM(userAccount);
        atm.run();
    }
}
 