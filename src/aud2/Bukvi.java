package aud2;

import java.util.Scanner;

public class Bukvi { //RESHENA

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void removeDuplicates(DLL<String> list) {
        DLLNode<String> dvizi = list.getFirst();

        while (dvizi!=null) {
            DLLNode<String> pom = dvizi.succ;
            while (pom!=null) {
                if(pom.element.equals(dvizi.element)) {
                    list.delete(pom);
                }
                pom = pom.succ;
            }
            if(dvizi.succ == null) {
                break;
            }
            dvizi = dvizi.succ;
        }

    }

    public static void alternateCharacters(DLL<String> list) {
        DLLNode<String> dvizi = list.getFirst();

        while (dvizi.succ!=null) {
            if(isVowel(dvizi.element.charAt(0)) && isVowel(dvizi.succ.element.charAt(0))) {
                list.delete(dvizi.succ);
            } else if(!isVowel(dvizi.element.charAt(0)) && !isVowel(dvizi.succ.element.charAt(0))) {
                list.delete(dvizi.succ);
            }
            else {
                dvizi = dvizi.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split("\\s+");
        DLL<String> list = new DLL<>();
        for (String part : parts) {
            list.insertLast(part);
        }
        removeDuplicates(list);
        alternateCharacters(list);
        System.out.println(list);

    }

}
