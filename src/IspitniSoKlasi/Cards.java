package IspitniSoKlasi;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cards
{
    public static void tarotCards(SLL<Card> firstPart,SLL<Card> secondPart)
    {
        SLLNode<Card> dvizi = firstPart.getFirst();
        SLLNode<Card> dvizi2 = secondPart.getFirst();

        secondPart.insertLast(dvizi.element);
        firstPart.delete(dvizi);
        firstPart.insertLast(dvizi2.element);
        secondPart.delete(dvizi2);
        SLLNode<Card> dvizi3 = firstPart.getFirst();
        SLLNode<Card> pom3 = null;
        while(dvizi3!=null)
        {
            if(dvizi3.succ!=null)
            {
                pom3 = dvizi3;
            }
            dvizi3 = dvizi3.succ;
        }
        SLLNode<Card> dvizi4 = secondPart.getFirst();
        SLLNode<Card> pom4 = null;
        int size;
        if(secondPart.length()%2==0)
        {
            size = secondPart.length() / 2;
        }
        else
        {
            size = secondPart.length() / 2 + 1;
        }
        for(int i=0;i<size;i++)
        {
            dvizi4 = dvizi4.succ;
        }
        secondPart.insertBefore(pom3.element,dvizi4);
        firstPart.delete(pom3);
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        SLL<Card> prvDel = new SLL<>();
        SLL<Card> vtorDel = new SLL<>();

        for(int i=0;i<6;i++)
        {
            int id = input.nextInt();
            int rank = input.nextInt();
            Card c1 = new Card(id,rank);
            prvDel.insertLast(c1);
        }
        for(int j=0;j<6;j++)
        {
            int id = input.nextInt();
            int rank = input.nextInt();
            Card c2 = new Card(id,rank);
            vtorDel.insertLast(c2);
        }
        tarotCards(prvDel,vtorDel);
        System.out.println(prvDel.toString());
        System.out.println(vtorDel.toString());
    }
}

class Card
{
    private int id;
    private int rank;

    public Card(int id, int rank)
    {
        this.id=id;
        this.rank=rank;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
