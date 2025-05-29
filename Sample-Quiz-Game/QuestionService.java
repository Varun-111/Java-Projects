import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    String selection[] = new String[5];
    public QuestionService() {
        questions[0] = new Question(1, "size of int",  new String[]{"2", "6", "4", "8"}, "4");
        questions[1] = new Question(2, "size of char", new String[]{"1", "2", "4", "8"}, "1");
        questions[2] = new Question(3, "size of float", new String[]{"2", "4", "8", "16"}, "4");
        questions[3] = new Question(4, "size of double", new String[]{"2", "4", "8", "16"}, "8");
        questions[4] = new Question(5, "size of long", new String[]{"2", "4", "8", "16"}, "8");
    }

    public void playQuiz(){

        int i = 0;
        for(Question q : questions){
            System.out.println("Question No. : " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println("Options: ");    
            for(String option : q.getOptions()){
                System.out.println(option);
            }
            System.out.print("Select your option: ");
            Scanner sc = new Scanner(System.in);  
            selection[i] = sc.nextLine();
            i++;

        }

        for(String s: selection){
            System.out.println("You selected: " + s);
        }
    }

    public void printScore() {
        int score = 0;
        for(int i = 0; i < questions.length; i++) {
            Question que = questions[i];
            String ans = que.getAnswer();
            String userAns = selection[i];
            if(ans.equals(userAns)) {
                score++;
            }
        }
        System.out.println("Your score is: " + score + "/" + questions.length);
    }   
}
