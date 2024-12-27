import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < T; i++) {
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            
            for(char c : str.toCharArray()) {
                if(c=='(') {
                    stack.push(')');
                } else if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    isValid = false;
                }
            }
            
            if(isValid && stack.isEmpty()) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
