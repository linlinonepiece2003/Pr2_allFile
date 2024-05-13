package Week_1;
import java.util.Scanner;
public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" How many eggs you have ?");
        int eggs = sc.nextInt();

        int gross = eggs / 144;
        int dozeneggs = (eggs % 144) / 12;
        int leftover = (eggs % 144) % 12;
        System.out.print("Your number of eggs is " + gross + " gross, " + dozeneggs + " dozen, and " + leftover
                + " since " + eggs + " is equal to " + gross * 144 + " + " + dozeneggs * 12 + " + " + leftover);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int eggs ;
//        while(true){
//        System.out.println(" How many eggs you have ?");
//        try {
//             eggs = sc.nextInt();
//            break;
//        }catch (Exception e){
//            System.out.println("Invalid input. Please enter an integer number of eggs.");
//            sc.nextLine();
//        }
//        }
//        int gross = eggs / 144;
//        int dozeneggs = (eggs % 144) / 12;
//        int leftover = (eggs % 144) % 12;
//        System.out.print("Your number of eggs is " + gross + " gross, " + dozeneggs + " dozen, and " + leftover
//                + " since " + eggs + " is equal to " + gross * 144 + " + " + dozeneggs * 12 + " + " + leftover);
//    }
  }

