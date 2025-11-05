package aud3;

import java.io.*;
import java.util.*;

public class CheckXML {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid = 1;

        ArrayStack<String> stack = new ArrayStack<>(100);

        for (String str : redovi) {
            if (str.startsWith("[/")) {
                String tagName = str.substring(2, str.length() - 1);
                if (stack.isEmpty()) {
                    valid = 0;
                    break;
                }
                String lastOpen = stack.pop();
                if (!tagName.equals(lastOpen)) {
                    valid = 0;
                    break;
                }
            } else if (str.startsWith("[") && str.endsWith("]")) {
                String tagName = str.substring(1, str.length() - 1);
                stack.push(tagName);
            }
        }

        if (!stack.isEmpty()) {
            valid = 0;
        }

        System.out.println(valid);

        br.close();
    }
}