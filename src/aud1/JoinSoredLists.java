package aud1;

public class JoinSoredLists<E extends Comparable<E>>{
    public SLL<E> join(SLL<E> list1, SLL<E> list2){
        SLL<E> result = new SLL<>();
        SLLNode<E> jazol1 = list1.getFirst();
        SLLNode<E> jazol2 = list2.getFirst();

        while(jazol1!=null && jazol2!=null){
            if(jazol1.element.compareTo(jazol2.element)<0)
            {
                result.insertLast(jazol1.element);
                jazol1 = jazol1.succ;
            }
            else
            {
                result.insertLast(jazol2.element);
                jazol2 = jazol2.succ;
            }
        }

        if(jazol1!=null)
        {
            while(jazol1!=null)
            {
                result.insertLast(jazol1.element);
                jazol1 = jazol1.succ;
            }

        }
        if(jazol2!=null)
        {
            while(jazol2!=null)
            {
                result.insertLast(jazol2.element);
                jazol2 = jazol2.succ;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SLL<String> list1 = new SLL<>();
        list1.insertLast("Ana");
        list1.insertLast("Bojana");
        list1.insertLast("Dejan");

        SLL<String> list2 = new SLL<>();
        list2.insertLast("Andrijana");
        list2.insertLast("Biljana");
        list2.insertLast("Darko");

        JoinSoredLists<String> js = new JoinSoredLists<String>();
        System.out.println(js.join(list1, list2));
    }
}
