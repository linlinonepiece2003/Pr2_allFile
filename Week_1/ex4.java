package Week_1;

public class ex4 {
    /**
     2 * This class implements a simple program that
     3 * will compute the amount of interest that is
     4 * earned on 17,000 invested at an interest
     5 * rate of 0.07 for one year. The interest and
     6 * the value of the investment after one year are
     7 * printed to standard output.
     8 */

 public static void main(String[] args) {
             /* Declare the variables. */
     double principal;
             double rate;
             double interest;
             /* Do the computations. */
     principal = 17000;
             rate = 0.07;
             interest = principal * rate;
             principal = principal + interest;
             /* Output the results. */
             System.out.print("The interest earned is ");
            System.out.println(interest);
             System.out.print("The value of the investment after one year is ");
                     System.out.println(principal);
            } // end of main()
 } // end of class Interest

// a, It still run because the type is double so that it still true
//b, It not work because the when assign new value in result code it become double type so that it no longer
//right way to store like that. To fix we cast the new assign to integer. like this    principal = (int) (principal + interest);