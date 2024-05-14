package Week_2;

public class Ex1{
    public static void main(String[] args) {
        int firstDie = (int)(Math.random()*6)+1;
        int secondDie = (int)(Math.random()*6)+1;
        int total = firstDie + secondDie;
        System.out.println("the firstDie: "+ firstDie);
        System.out.println("the secondDie: "+ secondDie);
        System.out.println("total die: "+ total);
    }


}
