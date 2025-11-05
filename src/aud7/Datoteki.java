package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Datoteki {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, ArrayList<String>> table = new CBHT<>(2*N);
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            insertFile(input,table);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] parts = line.split("", 2);
            String cmd = parts[0];
            String fileLine = parts[1];
            switch(cmd) {
                case "add":
                    insertFile(fileLine,table);
                    break;
                case "delete":
                    deleteFile(fileLine,table);
                    break;
                case "find":
                    System.out.println(findFile(fileLine, table));
                    break;
            }
        }
        String content = br.readLine();
        SLLNode<MapEntry<String,ArrayList<String>>> current = table.search(content);
        if(content != null) {
            for (String path : current.element.value) {
                System.out.println(path + " ");
            }
        }
    }

    private static String findFile(String fileLine, CBHT<String, ArrayList<String>> table) {
        int idxOpen = fileLine.indexOf('(');
        int idxClose = fileLine.indexOf(')');
        String content = fileLine.substring(idxOpen + 1, idxClose);
        String filePath = fileLine.substring(0, idxOpen).trim();

        SLLNode<MapEntry<String, ArrayList<String>>> node = table.search(content);
        if (node != null && node.element.value.contains(filePath)) {
            return "true";
        }
        return "false";
    }

    private static void deleteFile(String fileLine, CBHT<String, ArrayList<String>> table) {
        int indexOpen = fileLine.indexOf('(');
        int indexClose = fileLine.indexOf(')');
        String content = fileLine.substring(indexOpen+1,indexClose);
        String filePath = fileLine.substring(0, indexOpen).trim();
        SLLNode<MapEntry<String,ArrayList<String>>> current = table.search(content);
        if(current == null) {
            System.out.println("nono");
        } else {
            ArrayList<String> paths = current.element.value;
            paths.remove(filePath);
            if(paths.isEmpty()) {
                table.delete(content);
            }
        }
    }

    private static void insertFile(String input, CBHT<String, ArrayList<String>> table) {
        int indexOpen = input.indexOf('(');
        int indexClose = input.indexOf(')');
        String content = input.substring(indexOpen+1,indexClose);
        String filePath = input.substring(0, indexOpen).trim();
        SLLNode<MapEntry<String,ArrayList<String>>> current = table.search(content);
        if(current == null) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add(filePath);
            table.insert(content,paths);
        } else {
            ArrayList<String> paths = current.element.value;
            if(!paths.contains(filePath)) {
                paths.add(filePath);
            }
        }
    }
}
