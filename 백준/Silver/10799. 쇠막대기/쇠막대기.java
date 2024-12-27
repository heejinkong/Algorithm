import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        
        String str = br.readLine();
        int cnt = 0;
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if(str.charAt(i - 1) == '(') {
                    cnt += stack.size();
                } else {
                    cnt += 1;
                }
            }
        }
        System.out.print(cnt);
    }
}