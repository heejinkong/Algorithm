import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuffer sb = new StringBuffer();
        boolean check = false; 

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '<') {
                check = true;
                while (!stack.isEmpty()) { 
                    sb.append(stack.pop());
                }
                sb.append(c); 
            } else if (c == '>') { 
                check = false;
                sb.append(c); 
            } else if (check) { 
                sb.append(c); 
            } else { 
                if (c == ' ') { 
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}