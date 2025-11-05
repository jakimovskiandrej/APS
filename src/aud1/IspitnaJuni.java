package aud1;

import java.util.Scanner;

public class IspitnaJuni {
    public static void putWordsTogether(SLL<String> list)
    {
        SLLNode<String> dvizi = list.getFirst();
        SLL<String> result = new SLL<>();
        String s = "";

        while(dvizi!=null)
        {
            if(dvizi.element.equals(","))
            {
                result.insertLast(s);
                s = "";
                dvizi = dvizi.succ;
            }
            s+=dvizi.element;
            if(dvizi.succ==null)
            {
                result.insertLast(s);
            }
            dvizi = dvizi.succ;
        }

        System.out.println(result);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        SLL<String> list = new SLL<>();
        for(int i=0;i<s.length();i++){
            if(!Character.isWhitespace(s.charAt(i))){
                list.insertLast(String.valueOf(s.charAt(i)));
            }
        }
        putWordsTogether(list);
    }
}
