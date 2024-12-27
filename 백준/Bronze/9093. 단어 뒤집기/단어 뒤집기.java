import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < T; i++) {
            String word = sc.nextLine();
            String[] wordArr = word.split(" ");
            StringBuilder answer = new StringBuilder();

            for(String s : wordArr) {
                Stack<String> stack = new Stack<>();

                for(char c : s.toCharArray()) {
                    stack.push(String.valueOf(c));
                }

                while (!stack.isEmpty()) {
                    answer.append(stack.pop());
                }

                answer.append(" ");
            }
            System.out.println(answer.toString().trim());
        }
    }
}
