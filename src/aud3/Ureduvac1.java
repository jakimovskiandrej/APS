package aud3;

import Ispitni.Array;

import java.util.Scanner;
//TYPE X – додава карактер X на крајот од текстот.
//
//BACKSPACE – го брише последниот карактер (ако има).
//
//SHOW – го прикажува моменталниот текст.
public class Ureduvac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayStack<Character> stack = new ArrayStack<>(100);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            String command = parts[0];
            if(command.startsWith("TYPE")) {
                Character letter = parts[1].charAt(0);
                sb.append(letter);
                stack.push(letter);
            } else if(command.equals("BACKSPACE")) {
                if(!stack.isEmpty()) {
                    sb.append(stack.pop());
                    sb.setLength(stack.size());
                }
            } else if(command.equals("SHOW")) {
                System.out.println(sb.toString());
            }
        }
    }
}
