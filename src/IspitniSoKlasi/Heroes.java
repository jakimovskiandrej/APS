//package IspitniSoKlasi;
//
//import java.util.Scanner;
//
//public class Heroes
//{
//
//    public static void startHeroesGame(SLL<Card> firstFriendCards, SLL<Card> secondFriendCards)
//    {
//        SLLNode<Card> dvizi = firstFriendCards.getFirst();
//        SLLNode<Card> pom1 = null;
//        int max = 0;
//        while(dvizi!=null)
//        {
//            int maxImportance = 0;
//            maxImportance = dvizi.element.getPower() * dvizi.element.getNumAttacks();
//            if(maxImportance>max)
//            {
//                max = maxImportance;
//                pom1 = dvizi;
//            }
//            dvizi = dvizi.succ;
//        }
//
//        SLLNode<Card> dvizi2 = secondFriendCards.getFirst();
//        SLLNode<Card> pom2 = null;
//        int counter = 0;
//        while(dvizi2 != null)
//        {
//            if(counter==2)
//            {
//                pom2 = dvizi2;
//                break;
//            }
//            dvizi2 = dvizi2.succ;
//            counter++;
//        }
//        firstFriendCards.delete(pom1);
//        secondFriendCards.insertAfter(pom1.element, pom2);
//    }
//    public static void main(String[] args)
//    {
//        SLL<Card> prv = new SLL<>();
//        SLL<Card> vtor = new SLL<>();
//        Scanner scanner = new Scanner(System.in);
//        for(int i=0;i<6;i++)
//        {
//            int id = scanner.nextInt();
//            int power = scanner.nextInt();
//            int numAttacks = scanner.nextInt();
//            Card c1 = new Card(id,power,numAttacks);
//            prv.insertLast(c1);
//        }
//        for(int j=0;j<6;j++)
//        {
//            int id = scanner.nextInt();
//            int power = scanner.nextInt();
//            int numAttacks = scanner.nextInt();
//            Card c1 = new Card(id,power,numAttacks);
//            vtor.insertLast(c1);
//        }
//        startHeroesGame(prv,vtor);
//        System.out.println(prv.toString());
//        System.out.println(vtor.toString());
//
//    }
//}
////class Card
////{
////    int id;
////    int power;
////    int numAttacks;
////
////    public Card(int id, int power, int numAttacks)
////    {
////        this.id = id;
////        this.power = power;
////        this.numAttacks = numAttacks;
////    }
////
////    public int getId() {
////        return id;
////    }
////
////    public int getPower() {
////        return power;
////    }
////
////    public int getNumAttacks() {
////        return numAttacks;
////    }
////
////    @Override
////    public String toString() {
////        return String.valueOf(id);
////    }
////}
