package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<Integer,String> table = new CBHT<>(N);

        table.insert(100,"Andrej");
        table.insert(123,"Andrej");
        table.insert(456,"Andrej");
        table.insert(345,"Andrej");
        table.insert(222,"Andrej");

        table.delete(100);

        System.out.println(table);

    }

}
