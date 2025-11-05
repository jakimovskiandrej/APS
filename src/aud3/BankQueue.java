package aud3;

public class BankQueue {
    public static void main(String[] args) {
        ArrayQueue<String> red = new ArrayQueue<>(100);

        red.enqueue("Ивана");
        red.enqueue("Мартин");
        red.enqueue("Ана");

        while (!red.isEmpty()) {
            String klient = red.dequeue();
            System.out.println("Услужен клиент: " + klient);
        }
    }
}
