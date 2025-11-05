//package aud7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class DNK {
//
//    public static boolean isValidDNA(String dna) {
//        for(int i=0; i<dna.length(); i++) {
//            char nucleotide = dna.charAt(i);
//            if(nucleotide != 'A' && nucleotide != 'C' && nucleotide != 'G' && nucleotide != 'T') {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        OBHT<String,String> table = new OBHT<>(4*N);
//        for(int i=0;i<N;i++) {
//            String name = br.readLine();
//            String dna1 = br.readLine();
//            String dna2 = br.readLine();
//            table.insert(dna1,name);
//            table.insert(dna2,name);
//        }
//
//        String sample1 = br.readLine();
//        String sample2 = br.readLine();
//
//        if(!isValidDNA(sample1) || !isValidDNA(sample2)) {
//            System.out.println("Wrong nucleotides");
//            return;
//        }
//
//        int index1 = table.search(sample1);
//        int index2 = table.search(sample2);
//
//        if(index1!=OBHT.NONE && index2!=OBHT.NONE && index1 == index2) {
//            System.out.println(owner1);
//        } else {
//            System.out.println("Unknown");
//        }
//
//    }
//
//}
