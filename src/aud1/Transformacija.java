package aud1;

import java.util.Scanner;

class Element {
    private int id;

    public Element(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Transformacija {
    private static void listTransform(SLL<Element> original, SLL<Element> odd, SLL<Element> even) {
        SLLNode<Element> dvizi = original.getFirst();
        while(dvizi!=null)
        {
            if(dvizi.element.getId()%2==0)
            {
                even.insertLast(dvizi.element);
            }
            else
            {
                odd.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        SLL<Element> list = new SLL<Element>();
        SLL<Element> odd = new SLL<Element>();
        SLL<Element> even = new SLL<Element>();

        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            list.insertLast(new Element(n));
        }

        listTransform(list, odd, even);
        System.out.println(odd.toString());
        System.out.println(even.toString());
    }
}
