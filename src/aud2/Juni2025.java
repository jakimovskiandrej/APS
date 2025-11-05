package aud2;

import java.util.Scanner;

public class Juni2025 {
    public static void main(String[] args) {
        DLL<String> lista = new DLL<>();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] parts = input.split("\\s+");
            String command = parts[0];
            if(command.equals("TYPE")) {
                if(parts.length == 2) {
                    String letter = parts[1];
                    lista.insertLast(letter);
                }
            } else if(command.equals("UNDO")) {
                if(lista.getSize() > 0) {
                    lista.deleteLast();
                }
            } else if(command.equals("SHOW")) {
                System.out.println(lista);
            }
        }
    }
}
