package aud7;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class FacultyEnrollment {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String,Double> candidates = new OBHT<String,Double>(2*N);
        String input;
        for(int i=0;i<N;i++) {
            input = br.readLine();
            String[] parts = input.split(" ");
            candidates.insert(parts[0],Double.parseDouble(parts[1]));
        }
        int M = Integer.parseInt(br.readLine());
        OBHT<String,Double> gradeBook = new OBHT<String,Double>(2*M);
        for(int i=0;i<M;i++) {
            input = br.readLine();
            String[] parts = input.split(" ");
            gradeBook.insert(parts[0],Double.parseDouble(parts[1]));
        }
        String PIN = br.readLine();

    }

}
