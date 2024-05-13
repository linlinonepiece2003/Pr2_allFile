package Week_1;

public class Example {
    static int gcd(int a, int b){
        while (a != b){
            if ( a>b) a = a-b;
            else b = b - a;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(" The output is gcd of two number: " + gcd(9,2));
    }
}
