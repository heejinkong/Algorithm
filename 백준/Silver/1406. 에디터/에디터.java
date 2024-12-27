import java.util.*;

public class Main{
    public static void main(String[] args) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Scanner sc = new Scanner(System.in);


        String word = sc.nextLine();
        for (char c : word.toCharArray()) {
            stack1.push(c);
        }


        int M = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < M; i++) {
            String command = sc.next();
            if (command.equals("P")) {
                char ch = sc.next().charAt(0); // 추가 문자 읽기
                stack1.push(ch);
            } else if (command.equals("L")) {
                if (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            } else if (command.equals("D")) {
                if (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            } else if (command.equals("B")) {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }


        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        StringBuilder result = new StringBuilder();
        while (!stack2.isEmpty()) {
            result.append(stack2.pop());
        }


        System.out.println(result);
    }
}