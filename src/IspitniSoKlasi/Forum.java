package IspitniSoKlasi;

import java.util.Scanner;

class Discussion {
    private int id;
    private int popularity;
    private int users;

    public Discussion(int id, int popularity, int users) {
        this.id = id;
        this.popularity = popularity;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Forum {

    // TODO: implement function
    public static void forum(SLL<Discussion> health, SLL<Discussion> finance)
    {
        SLLNode<Discussion> dvizi = finance.getFirst();
        SLLNode<Discussion> pom1 = null;
        SLLNode<Discussion> pom2 = null;
        int min = 9999;
        while(dvizi!=null)
        {
            int minImportance = 0;
            minImportance = dvizi.element.getPopularity() * dvizi.element.getUsers();
            if(minImportance < min)
            {
                min = minImportance;
                pom1 = dvizi;
                pom2 = pom1;
            }
            dvizi = dvizi.succ;
        }
        finance.delete(pom1);

        SLLNode<Discussion> dvizi2 = health.getFirst();
        SLLNode<Discussion> pom3 = null;
        SLLNode<Discussion> pom4 = null;
        int max = 0;
        while(dvizi2!=null)
        {
            int maxImportance = 0;
            maxImportance = dvizi2.element.getPopularity() * dvizi2.element.getUsers();
            if(maxImportance > max)
            {
                max = maxImportance;
                pom3 = dvizi2;
                pom4 = pom3;
            }
            dvizi2 = dvizi2.succ;
        }
        finance.insertLast(pom4.element);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numHealth = Integer.parseInt(scanner.nextLine());
        int numFinance = Integer.parseInt(scanner.nextLine());

        SLL<Discussion> health = new SLL<Discussion>();
        SLL<Discussion> finance = new SLL<Discussion>();

        for (int i = 0; i < numHealth; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            health.insertLast(new Discussion(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < numFinance; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            finance.insertLast(new Discussion(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        forum(health, finance);
        System.out.println(health.toString());
        System.out.println(finance.toString());
    }
}
