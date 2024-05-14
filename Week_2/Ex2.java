package Week_2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many quaters you have ?");
        int quaters = sc.nextInt();
        System.out.println("How many dimes you have ?");
        int dimes = sc.nextInt();
        System.out.println("How many nickels you have ?");
        int nickels = sc.nextInt();
        System.out.println("How many pennies you have ?");
        int pennies = sc.nextInt();
        double totalDollars = (quaters * 0.25) + (dimes * 0.1) + (nickels * 0.05) + (pennies * 0.01);
        System.out.println("You have $ " + totalDollars);
    }
}
