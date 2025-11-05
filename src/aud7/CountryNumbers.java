//package aud7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Number {
//
//    int number;
//    String country;
//
//    public Number(int number, String country) {
//        this.number = number;
//        this.country = country;
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//}
//
//public class CountryNumbers {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        OBHT<Integer,String> table = new OBHT<>(2*N);
//        for(int i=0;i<N;i++) {
//            String[] parts = br.readLine().split(" ");
//            int number = Integer.parseInt(parts[0]);
//            String country = parts[1];
//            table.insert(number,country);
//        }
//        String telephoneNumber = br.readLine();
//        if(telephoneNumber.startsWith("+")) {
//            telephoneNumber = telephoneNumber.substring(1);
//            String code = "";
//            if(telephoneNumber.charAt(0) == '1') {
//                code = telephoneNumber.substring(0,1);
//            } else if (telephoneNumber.charAt(0) == '2'){
//                code = telephoneNumber.substring(0,2);
//            } else if (telephoneNumber.charAt(0) == '3') {
//                code = telephoneNumber.substring(0,3);
//            }
//            int codeInt = Integer.parseInt(code);
//            String country = table.search(codeInt);
//            if(country!=null) {
//                System.out.println(country);
//            } else {
//                System.out.println("Invalid code");
//            }
//        } else {
//            System.out.println("Invalid telephone number");
//        }
//    }
//}
