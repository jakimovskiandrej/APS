package Ispitni;

import java.util.Scanner;

public class AddElements {
//    public static int[] addAverage(Array<Integer> arr)
//    {
//
//    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Array<Integer> arr = new Array<>(N);
        for(int i=0;i<N;i++)
        {
            arr.insertLast(input.nextInt());
        }
        System.out.println(arr);
    }
}
