package ma.ensa;

import ma.ensa.Interfaces.InterestStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
                new BankAccount("oussama ",2300),
                new BankAccount("sami", 4000),
                new BankAccount("ayoub", 4000)
        );
        Supplier<InterestStrategy> fixedStrategySupplier  =() -> balance -> balance * 0.5;
        Predicate<BankAccount> isVIP =  b -> b.balance >=10000;
        Function<BankAccount, Double> interestCalculator =
                acc -> fixedStrategySupplier.get().calculateInterest(acc.balance);

    }

    }
