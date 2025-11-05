package aud3;

import java.util.Scanner;

public class Vozovi {
    public static void main(String[] args) {
        ArrayStack<Integer> starVoz = new ArrayStack<>(100);
        ArrayStack<Integer> novVoz = new ArrayStack<>(100);
        ArrayQueue<Integer> shina = new ArrayQueue<>(100);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        for (int i = 0; i < n; i++) {
            int wagon = sc.nextInt();
            starVoz.push(wagon);
        }
        while(!starVoz.isEmpty()) {
            int wagon = starVoz.pop();
            if(wagon == 0) {
                continue;
            }
            shina.enqueue(wagon);
            int round = shina.size();
            while (round-- > 0) {
                int current = shina.dequeue();
                if(novVoz.isEmpty() || current <= novVoz.peek()) {
                    novVoz.push(current);
                } else {
                    shina.enqueue(current);
                }
            }
            while(!novVoz.isEmpty()) {
                int current = novVoz.pop();
                System.out.println(current + "");
            }
        }
    }
}
