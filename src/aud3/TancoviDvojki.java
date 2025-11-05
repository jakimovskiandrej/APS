package aud3;

import java.util.Scanner;

public class TancoviDvojki {

    public static void formPairs(String[] candidates) {
        ArrayStack<String> primaryZ = new ArrayStack<>(100);
        ArrayStack<String> primaryM = new ArrayStack<>(100);
        ArrayStack<String> latinoZ = new ArrayStack<>(100);
        ArrayStack<String> latinoM = new ArrayStack<>(100);
        ArrayStack<String> standardZ = new ArrayStack<>(100);
        ArrayStack<String> standardM = new ArrayStack<>(100);
        for(int i = 0; i < candidates.length; i++) {
            char group = candidates[i].charAt(0);
            char gender = candidates[i].charAt(1);
            if(group == 'O') {
                if(gender == 'M') {
                    primaryM.push(candidates[i]);
                } else {
                    primaryZ.push(candidates[i]);
                }
            } else if(group == 'L') {
                if(gender == 'M') {
                    latinoM.push(candidates[i]);
                } else {
                    latinoZ.push(candidates[i]);
                }
            } else if(group == 'S') {
                if(gender == 'M') {
                    standardM.push(candidates[i]);
                } else {
                    standardZ.push(candidates[i]);
                }
            }
        }
        int counter = 0;
        counter+=makePairs(latinoZ,latinoM);
        counter+=makePairs(standardM,standardZ);
        counter+=makePairs(primaryM,primaryZ);
        printMissing(latinoZ,latinoM);
        printMissing(standardZ,standardM);
        printMissing(primaryZ,primaryM);
    }

    public static int makePairs(ArrayStack<String> z, ArrayStack<String> m) {
        int counter = 0;
        while (!z.isEmpty() && !m.isEmpty()) {
            String zeni = z.pop();
            String mazi = m.pop();
            System.out.println(String.format("(%s,%s)", zeni, mazi));
            counter++;
        }
        return counter;
    }

    public static void printMissing(ArrayStack<String> z, ArrayStack<String> m) {
        if(!z.isEmpty() || !m.isEmpty()) {
            while(!z.isEmpty()) {
                System.out.println(z.pop());
            }
            while(!m.isEmpty()) {
                System.out.println(m.pop());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] candidates = new String[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextLine();
        }
        formPairs(candidates);
    }
}
