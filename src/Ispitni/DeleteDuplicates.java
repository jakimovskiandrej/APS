package Ispitni;

import java.util.Scanner;
import java.util.*;

public class DeleteDuplicates {
    public static void duplicates(Array<Integer> arr)
    {
        for(int i=0;i<arr.getSize();i++)
        {
            for(int j=0;j<arr.getSize();j++)
            {
                if(Objects.equals(arr.get(i), arr.get(j)))
                {
                    arr.delete(i);
                    arr.delete(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int N = input.nextInt();
        Array<Integer> arr = new Array<>(N);
        for(int i=0;i<N;i++)
        {
            System.out.println(arr.toString());
        }
        duplicates(arr);
    }
}
