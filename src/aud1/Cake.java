package aud1;

import java.util.Scanner;

class Cakes {
    private String ime;
    private int cena;

    public Cakes(String ime, int cena)
    {
        this.ime = ime;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public int getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return String.valueOf(ime);
    }
}

public class Cake {

    public static void removeCakes(SLL<Cakes> cakes) {
        SLLNode<Cakes> dvizi = cakes.getFirst();
        int sum = 0;
        while (dvizi != null) {
            sum+=dvizi.element.getCena();
            dvizi = dvizi.succ;
        }

        dvizi = cakes.getFirst();
        double avg = (double) sum / cakes.size();
        while (dvizi!=null) {
            if(dvizi.element.getCena() > avg) {
                cakes.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Cakes> torta = new SLL<>();
        for(int i=0;i<n;i++)
        {
            String ime = input.next();
            int cena = input.nextInt();
            Cakes c1 = new Cakes(ime,cena);
            torta.insertLast(c1);
        }
        removeCakes(torta);
        System.out.println(torta.toString());
    }


}
