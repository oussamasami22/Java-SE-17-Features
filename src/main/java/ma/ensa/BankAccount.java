package ma.ensa;

import ma.ensa.Interfaces.InterestStrategy;

public class BankAccount {
    String owner;
    double balance;
    public BankAccount(String owner, double balance){
        this.balance = balance;
        this.owner =owner;
    }
    double applyInterest(InterestStrategy strategy) {
        return balance + strategy.calculateInterest(balance);
    }

    @Override
   public String toString(){
        return owner + " - Balance: $" + balance;
    }
}
