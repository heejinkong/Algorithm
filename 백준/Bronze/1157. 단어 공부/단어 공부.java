import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        String[] strArr = str.toLowerCase().split("");
        
        for(int i = 0; i < strArr.length; i++) {
            if(map.containsKey(strArr[i])) {
                map.put(strArr[i], map.get(strArr[i]) + 1);
            } else {
                map.put(strArr[i], 1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        int cnt = 0; 
        String answer = "";
        
        for(String key : map.keySet()){
            if(max < map.get(key)) {
                max = map.get(key);
            }
        }
        
        for(String key : map.keySet()) {
            if(max == map.get(key)) {
                answer = key;
                cnt++;
            }
        } 
        
        if(cnt > 1) {
            System.out.println("?");
        }  else {
            System.out.println(answer.toUpperCase());
        }
    }
}
