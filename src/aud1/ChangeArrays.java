package aud1;

import java.util.*;

public class ChangeArrays<E>{
    public void compareAndChangeArrays(ArrayList<E> niza1, ArrayList<E> niza2)
    {
        if(niza1.size() != niza2.size())
        {
            System.out.println("Nizite ne se so ista golemina");
        }

        int size = niza1.size();
        int i = 0;
        while(i < size)
        {
            if(niza1.get(i).equals(niza2.get(i)))
            {
                niza1.remove(i);
                niza2.remove(i);
                size--;
            }
            else
            {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> niza3 = new ArrayList<Integer>(3);
        niza3.add(1);
        niza3.add(2);
        niza3.add(3);

        ArrayList<Integer> niza4 = new ArrayList<Integer>(3);
        niza4.add(4);
        niza4.add(2);
        niza4.add(5);

        System.out.println("Nizite pred primenuvanje na funkcijata");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());

        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
        pom2.compareAndChangeArrays(niza3,niza4);

        System.out.println("Nizite po primenuvanje na funkcijata");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());
    }
}
