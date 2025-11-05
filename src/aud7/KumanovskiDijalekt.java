package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class KumanovskiDijalekt {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String,String> table = new CBHT<>(2 * N);

        String rechnik[]=new String[N];
        for(int i=0;i<N;i++){
            rechnik[i]=br.readLine();
        }

        for (String s : rechnik) {
            String[] split = s.split("\\s+");
            table.insert(split[0],split[1]);
        }

        String tekst=br.readLine();

        String[] words = tekst.split("\\s+");

        if(N==0) {
            System.out.println(tekst);
            return;
        }

        for(int i=0;i<words.length;i++){
            String key;
            boolean flag1 = false;
            boolean flag2 = false;
            char last = words[i].charAt(words[i].length()-1);
            if(last == '.' || last == ',' || last == '!' || last == '?') {
                flag1 = true;
                key = words[i].substring(0, words[i].length()-1);
            } else {
                key = words[i];
            }

            if(Character.isUpperCase(key.charAt(0))) {
                key = key.toLowerCase();
                flag2 = true;
            }

            SLLNode<MapEntry<String,String>> search = table.search(key);

            if(search!=null) {
                String value = search.element.value;

                if(flag1) {
                    value+=tekst;
                }
                if(flag2) {
                    value = Character.toUpperCase(value.charAt(0)) + value.substring(1);
                }
                words[i] = value;
            }
        }

        for (String word : words) {
            System.out.printf("%s ", word);
        }

    }
}
