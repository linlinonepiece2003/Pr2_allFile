package Week_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex5 {
    public static int calculateTotalPrice(String inputFile) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String firstLine = br.readLine().trim();
        String[] firstLineParts= firstLine.split(" ");
        int N = Integer.parseInt(firstLineParts[0]);
        int M = Integer.parseInt(firstLineParts[1]);
        int totalPrice =0;
        for (int i =0; i < M; i++){
            String line = br.readLine().trim();
            String[] parts = line.split(" ");
            int price = Integer.parseInt(parts[0]);
            int quantity = Integer.parseInt(parts[1]);
            totalPrice += price * quantity;
        }
        return totalPrice;
    }
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\DELL\\IdeaProjects\\project1\\src\\Week_2\\input.txt";
        try {
            int totalPrice = calculateTotalPrice(inputFile);
            System.out.println("Total price: "+ totalPrice);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
