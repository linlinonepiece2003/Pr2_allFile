package Week_1;
import java.util.Scanner;
// ask a username then greet by user with uppercase
public class ex2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String username;
        String uppercase;
        System.out.println("Please enter your name");
        username = sc.nextLine();
        uppercase = username.toUpperCase();
        System.out.println("Hello "+ uppercase+ " ,nice to meet you");
    }
}
