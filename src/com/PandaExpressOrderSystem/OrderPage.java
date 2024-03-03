package com.PandaExpressOrderSystem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderPage {
    
    static List<Entre> entreList = new ArrayList<>();
    static List<Entre> customerOrdered = new ArrayList<>();
    
    public static void main(String[] args) {
        initEntre();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            try {
                int num = scanner.nextInt();
                switch (num){
                    case 1:
                        while (true) {
                            showEntreMenu();
                            try {
                                int id = scanner.nextInt();
                                if(id == 0){
                                    break;
                                }else if(id != 0 && id != 1 && id != 2 && id != 3){
                                    System.out.println("Please enter a correct number!");
                                }else{
                                    Entre entreOrdered = entreList.get(id -1);
                                    System.out.println("You have ordered " + entreOrdered.getEntreName());
                                    customerOrdered.add(entreOrdered);
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a correct number!");
                                scanner.next();
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            showCart();
                            System.out.print("Please enter 0 to go back: ");
                            try {
                                int id = scanner.nextInt();
                                if (id == 0){
                                    break;
                                }else{
                                    System.out.println("Please enter a correct number!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a correct number!");
                                scanner.next();
                            }
                        }
                        break;
                    case 3:
                        checkOut();
                        return;
                }
                System.out.println("Please enter a correct number!");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a correct number!");
                scanner.next();
            }
        }

    }

    public static void initEntre(){
        Entre entre1 = new Entre(1, "Beijing Beef", 4.99);
        Entre entre2 = new Entre(2, "Kungpao Chicken", 4.99);
        Entre entre3 = new Entre(3, "Honey Walnut Shrimp", 4.99 + 1.5);

        entreList.add(entre1);
        entreList.add(entre2);
        entreList.add(entre3);
    }

    public static void showMenu(){
        System.out.println("------- Panda Express -------");
        System.out.printf("%-15s %s%n", "1", "Menu");
        System.out.printf("%-15s %s%n", "2", "Cart");
        System.out.printf("%-15s %s%n", "3", "Checkout");
        System.out.print("Please enter a number: ");
    }

    public static void showEntreMenu(){
        System.out.println("------- Panda Express -------");
        entreList.forEach(s -> {
            String output = String.format("%-5s %-25s $%5.2f", s.getId(), s.getEntreName(), s.getPrice());
            System.out.println(output);
        });
        System.out.print("Please enter an entre number, or enter 0 to go back: ");
    }

    public static void showCart(){
        Map<String, Integer> cartEntreAndNum = new HashMap<>();     //to store entre and num
        String orderedEntreToString = customerOrdered.toString();   //ordered entres toString to compare
        String cartBB = "Beijing Beef";     //keywords
        String cartKC = "Kungpao Chicken";
        String cartHWS = "Honey Walnut Shrimp";
        String[] cartEntreAll = {cartBB, cartKC, cartHWS};      //put keywords in list
        for (int i = 0; i < cartEntreAll.length; i++) {     //find if keywords are there one by one
            int count = 0;
            Pattern pattern = Pattern.compile(cartEntreAll[i]);     //keyword
            Matcher matcher = pattern.matcher(orderedEntreToString);        //text to be discovered
            while (matcher.find()){     //if the keyword is found
                count++;        //its number +1
                cartEntreAndNum.put(cartEntreAll[i], count);        //also put it to Map, found another, write again
            }
        }
        System.out.println("------- Your Cart -------");
        System.out.println("You have ordered: ");
        Set<String> strings = cartEntreAndNum.keySet();
        for(String str : strings){
            Integer value = cartEntreAndNum.get(str);
            String formattedString = String.format("%-30s x%d", str, value);
            System.out.println(formattedString);
        }
    }

    public static void checkOut(){
        int sum = 0;
        for (Entre s : customerOrdered) {
            double price = s.getPrice();
            sum += price;
        }
        System.out.println("You have paid " + sum + " dollars");
    }

}