package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PM10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String,ArrayList<Double>> hashtable = new OBHT<>(2*N);
        for(int i=1;i<=N;i++) {
            String s = br.readLine();
            String[] parts = s.split(" ");
            String municipality = parts[0];
            String pm10 = parts[1];
            ArrayList<Double> list = new ArrayList<>();
            if(hashtable.search(municipality) == -1) {
                list.add(Double.parseDouble(pm10));
                hashtable.insert(municipality,list);
            } else {
                list = hashtable.getBucket(hashtable.search(municipality)).value;
                list.add(Double.parseDouble(pm10));
                hashtable.insert(municipality,list);
            }
        }
        String neighbourhood = br.readLine();
        ArrayList<Double> current = hashtable.getBucket(hashtable.search(neighbourhood)).value;
        double sum = 0;
        if(!current.isEmpty()) {
            for(int i=1;i<current.size();i++) {
                sum += current.get(i);
            }
            System.out.printf("%.2f\n%n",sum/current.size());
        } else {
            System.out.println("No info");
        }

    }
}
