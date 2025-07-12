package ma.ensa;

import ma.ensa.Interfaces.InterestStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
                new BankAccount("oussama ",22300),
                new BankAccount("sami", 40000),
                new BankAccount("ayoub", 4000)
        );
        Supplier<InterestStrategy> fixedStrategySupplier  =() -> balance -> balance * 0.5;
        Predicate<BankAccount> isVIP =  b -> b.balance >=10000;
        Function<BankAccount, Double> interestCalculator =
                acc -> fixedStrategySupplier.get().calculateInterest(acc.balance);
        Consumer<BankAccount> printInterest = acc -> {
            double interestOwner = interestCalculator.apply(acc);
            System.out.println(acc.owner + "will recieve $" +interestOwner+ " as interest.");
        };
        System.out.println("🏦 Processing VIP Accounts:\n");
        accounts.parallelStream()
                .filter(isVIP)
                .peek(printInterest)
                .map(acc -> acc.applyInterest(fixedStrategySupplier.get()))
                .forEach(newBalance -> System.out.println("New Balance: $" + newBalance + "\n"));

    }

    }
