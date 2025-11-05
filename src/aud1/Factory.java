package aud1;

import java.util.Scanner;

class Order {
    private int id;
    private int product;
    private int priority;

    public Order(int id, int product, int priority) {
        this.id = id;
        this.product = product;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.valueOf(id)
                ;
    }
}


public class Factory {

    //todo: complete function
    public static void orders(SLL<Order> active, SLL<Order> shipping) {
        SLLNode<Order> dvizi = active.getFirst();
        SLLNode<Order> max = active.getFirst();
//        while(dvizi!=null) {
//            if(dvizi.element.getPriority()) {
//                shipping.insertLast(dvizi.element);
//                max = dvizi;
//            }
//            dvizi = dvizi.succ;
//        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numActive = Integer.parseInt(scanner.nextLine());
        int numShipping = Integer.parseInt(scanner.nextLine());

        SLL<Order> active = new SLL<Order>();
        SLL<Order> shipping = new SLL<Order>();

        for (int i = 0; i < numActive; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            active.insertLast(new Order(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < numShipping; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            shipping.insertLast(new Order(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        orders(active, shipping);
        System.out.println(active.toString());
        System.out.println(shipping.toString());
    }
}