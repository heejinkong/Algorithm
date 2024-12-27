import java.util.*;
import java.io.*;

public class Main{
      public static void main(String[] args) throws IOException {
        Deque<Integer> q = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            if(word.startsWith("push_front")) {
                int num = Integer.parseInt(word.split(" ")[1]);
                q.addFirst(num);
            } else if (word.startsWith("push_back")) {
                int num = Integer.parseInt(word.split(" ")[1]);
                q.addLast(num);
            } else if (word.startsWith("pop_front")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.removeFirst());
                }
            } else if (word.startsWith("pop_back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.removeLast());
                }
            } else if (word.equals("size")) {
                System.out.println(q.size());
            } else if(word.equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(word.equals("back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekLast());
                }
            } else if(word.equals("front")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekFirst());
                }
            }
        }
    }
}
