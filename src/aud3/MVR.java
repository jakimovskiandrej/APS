package aud3;

import java.util.Scanner;

class Gragjanin {
    String imePrezime;
    int lKarta;
    int pasos;
    int vozacka;

    public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
        this.imePrezime = imePrezime;
        this.lKarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public int getlKarta() {
        return lKarta;
    }

    public int getPasos() {
        return pasos;
    }

    public int getVozacka() {
        return vozacka;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());
        ArrayQueue<String> lkQueue = new ArrayQueue<>(100);
        ArrayQueue<String> pasosQueue = new ArrayQueue<>(100);
        ArrayQueue<String> vozackaQueue = new ArrayQueue<>(100);
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            if(lKarta == 1) {
                lkQueue.enqueue(imePrezime);
            }
            else if(pasos == 1) {
                pasosQueue.enqueue(imePrezime);
            }
            else if(vozacka == 1) {
                vozackaQueue.enqueue(imePrezime);
            }
        }
        while(!lkQueue.isEmpty()) {
            String imePrezime = lkQueue.dequeue();
            System.out.println(imePrezime);
        }
        while(!pasosQueue.isEmpty()) {
            String imePrezime = pasosQueue.dequeue();
            System.out.println(imePrezime);
        }
        while(!vozackaQueue.isEmpty()) {
            String imePrezime = vozackaQueue.dequeue();
            System.out.println(imePrezime);
        }
    }
}
