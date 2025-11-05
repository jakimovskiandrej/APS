package aud3;

import Ispitni.Array;

import java.util.Scanner;

public class Rastenija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }

        ArrayStack<Integer> pesticidi = new ArrayStack<>(100);
        ArrayStack<Integer> denovi = new ArrayStack<>(100);
        int maxDays = 0;
        for(int i = 0; i < N; i++) {
            int days = 0;
            while (!pesticidi.isEmpty() && pesticidi.peek() >= p[i]) {
                pesticidi.pop();
                denovi.pop();
            }
            if(!pesticidi.isEmpty()) {
                days = denovi.peek() + 1;
            }
            pesticidi.push(p[i]);
            denovi.push(days);
            if(days > maxDays) {
                maxDays = days;
            }
        }
        System.out.println(maxDays);
    }
}
