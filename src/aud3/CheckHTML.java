package aud3;

import java.util.*;

public class CheckHTML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayStack<String> stack = new ArrayStack<>(100);
        String[] input = new String[N];
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextLine();
        }
        int flag = 1;
        for (String str : input) {
            if(str.startsWith("<") && str.endsWith(">")) {
                String tagName = str.substring(1, str.length() - 1);
                stack.push(tagName);
            } else if(str.startsWith("</") && str.endsWith(">")) {
                String tagName = str.substring(2, str.length() - 1);
                if(stack.isEmpty()) {
                   flag = 0;
                   break;
                }
                String lastOpen = stack.pop();
                if(!tagName.equals(lastOpen)) {
                    flag = 0;
                    break;
                }
            }
        }
        if(stack.isEmpty()) {
            flag = 1;
        }
        if(flag == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
