package ma.ensa;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPredicate {

 static class Person{
     String name ;
     int age;
     String email;
     public Person(String name,int age , String email){
         this.name = name;
         this.age = age;
         this.email = email;

     }

     @Override
     public String toString(){
         return name + "(" +age+ ") -" +email;
     }

 }
    public static void main(String[] args) {

        // Liste de personnes
        List<Person> people = Arrays.asList(
                new Person("Ahmed", 22, "ahmed@gmail.com"),
                new Person("Amina", 17, "amina@gmail.com"),
                new Person("Ali", 30, "ali@"),
                new Person("Khalid", 25, "khalid@gmail.com"),
                new Person("Amal", 19, "amal@gmail.com")
        );
        Predicate<Person> isAdult = p -> p.age >=18;
        Predicate<Person> startWithA = p -> p.name.startsWith("A");
        Predicate<Person> isValidEmail = p -> p.email.contains("@");

        List<Person> filtredPerson = people.stream()
                .filter(startWithA.and(isAdult.and(isValidEmail)))
                .collect(Collectors.toList());

        System.out.println(filtredPerson);
    }

}


