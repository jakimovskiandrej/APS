package aud4;

import java.util.Arrays;
import java.util.Scanner;

public class LDS {

    private static int najdolgaOpagackaSekvenca(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for(int j=0;j<i;j++){
                if(a[i] < a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int flag = 1;
        for(int i=0;i<n;i++){
            flag = Math.max(flag, dp[i]);
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
