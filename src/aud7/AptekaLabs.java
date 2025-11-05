package aud7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Lek {
    String ime;
    int pozLista;
    int cena;
    int kolicina;

    public String getIme() {                return ime;                 }
    public void setIme(String ime) {        this.ime = ime;	            }
    public int getCena() {      		    return cena;	            }
    public void setCena(int cena) {		    this.cena = cena;           }
    public int getKolicina() {  		    return kolicina;	        }
    public void setKolicina(int kolicina) { this.kolicina = kolicina;	}
    public int getPozLista() {      		return pozLista;        	}

    public Lek(String ime, int pozLista, int cena, int kolicina) {
        this.ime = ime.toUpperCase();
        this.pozLista = pozLista;
        this.cena = cena;
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        if(pozLista==1) return ime+"\n"+"POZ\n"+cena+"\n"+kolicina;
        else return ime+"\n"+"NEG\n"+cena+"\n"+kolicina;
    }
}
//ACEROLA 0 100 1000
public class AptekaLabs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String,Lek> map = new CBHT<String, Lek>(2*N-1);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String ime = parts[0];
            int pozLista = Integer.parseInt(parts[1]);
            int cena = Integer.parseInt(parts[2]);
            int kolicina = Integer.parseInt(parts[3]);
            Lek lek = new Lek(ime,pozLista,cena,kolicina);
            map.insert(ime,lek);
        }
        String result = sc.nextLine().toUpperCase();
        while(!result.equals("KRAJ")) {
            String[] parts = result.split("\\s+");
            int kolicina = Integer.parseInt(sc.nextLine());
            SLLNode<MapEntry<String,Lek>> current = map.search(result);
            if(current == null) {
                System.out.println("Nema takov lek");
                result = sc.nextLine().toUpperCase();
            } else if(current.element.value.getIme().equals(result)) {
                System.out.println(current.element.value.toString());
                if(current.element.value.getKolicina() < kolicina) {
                    System.out.println("Nema dovolno lekovi");
                } else {
                    int old = current.element.value.getKolicina();
                    current.element.value.setKolicina(old - kolicina);
                    map.insert(result,current.element.value);
                    System.out.println("Napravena naracka");
                }
            } else {
                result = sc.nextLine();
            }
        }
    }
}
