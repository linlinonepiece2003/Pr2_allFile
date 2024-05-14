package Week_2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {
    public static void main(String[] args) {
        String file = "C:\\Users\\DELL\\IdeaProjects\\project1\\src\\Week_2\\testdata.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String studentname = br.readLine();
            //read the score
            int totalScore =0;
            for (int i=0; i<3; i++){
                int score = Integer.parseInt(br.readLine());
                totalScore += score;
            }
            double averageScore = (double)totalScore/3;
            System.out.println("Student name : "+ studentname);
            System.out.println("Average score: "+ averageScore);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
