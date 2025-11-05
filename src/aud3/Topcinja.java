package aud3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Topcinja {

    public static String ponistiTopcinja(List<String> lista) {
        ArrayStack<String> redBallsStack = new ArrayStack<>(100);
        ArrayStack<String> blueBallsStack = new ArrayStack<>(100);
        ArrayStack<String> greenBallsStack = new ArrayStack<>(100);
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for(int i=0;i<lista.size();i++) {
            String s = lista.get(i);
            if(s.charAt(0) == 'R') {
                if(!redBallsStack.isEmpty()) {
                    if(redBallsStack.peek().equals(s)) {
                        redBallsStack.push(s);
                    } else {
                        redBallsStack.pop();
                    }
                } else {
                    redBallsStack.push(s);
                }
            }
            if(s.charAt(0) == 'B') {
                if(!blueBallsStack.isEmpty()) {
                    if(blueBallsStack.peek().equals(s)) {
                        blueBallsStack.push(s);
                    } else {
                        blueBallsStack.pop();
                    }
                } else {
                    blueBallsStack.push(s);
                }
            }
            if(s.charAt(0) == 'G') {
                if (!greenBallsStack.isEmpty()) {
                    if (greenBallsStack.peek().equals(s)) {
                        greenBallsStack.push(s);
                    } else {
                        greenBallsStack.pop();
                    }
                } else {
                    greenBallsStack.push(s);
                }
            }
        }
        while (!redBallsStack.isEmpty()) {
            counter++;
            if(redBallsStack.pop().charAt(1) == '+') {
                result.append("R-");
            } else {
                result.append("R+");
            }
        }
        while (!blueBallsStack.isEmpty()) {
            counter++;
            if(blueBallsStack.pop().charAt(1) == '+') {
                result.append("B-");
            } else {
                result.append("B+");
            }
        }
        while (!greenBallsStack.isEmpty()) {
            counter++;
            if(greenBallsStack.pop().charAt(1) == '+') {
                result.append("G-");
            } else {
                result.append("G+");
            }
        }
        System.out.println(counter);
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vlez[] = new String[100];
        vlez = br.readLine().split(" ");

        List<String> topcinja = new LinkedList<String>();
        for (int i = 0; i < vlez.length; i++) {
            topcinja.add(vlez[i]);
        }
        System.out.println(ponistiTopcinja(topcinja));
    }
}
