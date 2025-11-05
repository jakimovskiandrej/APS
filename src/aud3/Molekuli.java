package aud3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Molekuli {

    public static String napraviMolekula(ArrayQueue<String> input) {
        ArrayStack<String> hydrogen = new ArrayStack<>(100);
        ArrayStack<String> oxygen = new ArrayStack<>(100);
        int counter = 0;
        String s;
        StringBuilder sb = new StringBuilder();
        while (!input.isEmpty()) {
            s = input.dequeue();
            if(s.equals("H")) {
                hydrogen.push(s);
            } else if(s.equals("O")) {
                oxygen.push(s);
            }
        }
        while (!oxygen.isEmpty()) {
            if (!hydrogen.isEmpty()) {
                hydrogen.pop();
                if(!hydrogen.isEmpty()) {
                    hydrogen.pop();
                    oxygen.pop();
                    counter++;
                } else {
                    hydrogen.push("H");
                    break;
                }
            } else {
                break;
            }
        }
        while(!hydrogen.isEmpty()) {
            hydrogen.pop();
        }
        while(!oxygen.isEmpty()) {
            oxygen.pop();
        }
        sb.append(counter).append('\n').append('H').append('\n').append('O');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vlez = new String[1000];
        vlez = br.readLine().split(" ");
        ArrayQueue<String> atomi = new ArrayQueue<String>(1000);
        for(int i = 0; i < vlez.length; i++) {
            atomi.enqueue(vlez[i]);
        }
        System.out.println(napraviMolekula(atomi));
    }
}
