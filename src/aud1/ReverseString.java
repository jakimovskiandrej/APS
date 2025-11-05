package aud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    private static SLL<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();

        String line = br.readLine();
        String parts[] = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        int fromIndex = Integer.parseInt(br.readLine());
        int toIndex = Integer.parseInt(br.readLine());

        SLLNode<Integer> node=list.getFirst();
        SLLNode<Integer> nodeFrom=null;
        SLLNode<Integer> nodeTo=null;


        while(fromIndex+1<=toIndex)
        {
            node = list.getFirst();
            for(int i=0;i<list.size();i++)
            {
                if(node!=null)
                {
                    if(i!=0)
                    {
                        node = node.succ;
                    }
                    if(i==fromIndex)
                    {
                        nodeFrom = node;
                    }
                    if(i==toIndex)
                    {
                        nodeTo = node;
                    }
                }
            }

            if(nodeFrom!=null)
            {
                list.insertAfter(nodeFrom.element,nodeTo);
            }
            if(nodeTo!=null)
            {
                list.insertAfter(nodeTo.element,nodeFrom);
            }
            list.delete(nodeFrom);
            list.delete(nodeTo);
            fromIndex++;
            toIndex--;
        }
        System.out.println(list);
    }

}
