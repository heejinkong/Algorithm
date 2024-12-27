import java.util.*;

public class Main{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String st = sc.next();
            int answer = 0;

            if (st.equals("push")) {
                int num = sc.nextInt();
                stack.push(num);
            } else if (st.equals("pop")) {
                if (stack.isEmpty()) {
                    answer = -1;
                } else {
                    answer = stack.pop();
                }
                System.out.println(answer);
            } else if (st.equals("size")) {
                answer = stack.size();
                System.out.println(answer);
            } else if (st.equals("empty")) {
                answer = stack.isEmpty() ? 1 : 0;
                System.out.println(answer);
            } else if (st.equals("top")) {
                if (stack.isEmpty()) {
                    answer = -1;
                } else {
                    answer = stack.peek();
                }
                System.out.println(answer);

            }

        }
    }
}