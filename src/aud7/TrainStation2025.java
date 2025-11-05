package aud7;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Station {
    String registerNum;
    String model;
    String operator;

    public Station(String registerNum, String model, String operator) {
        this.registerNum = registerNum;
        this.model = model;
        this.operator = operator;
    }

    public String getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(String registerNum) {
        this.registerNum = registerNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return String.format("%s %s", model, operator);
    }
}

public class TrainStation2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String, ArrayList<Station>> table = new CBHT<>(2*N-1);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String registerNum = parts[0];
            String model = parts[1];
            String operator = parts[2];
            Station station = new Station(registerNum, model, operator);
            SLLNode<MapEntry<String,ArrayList<Station>>> current = table.search(registerNum);
            if(current == null) {
                ArrayList<Station> list = new ArrayList<>();
                list.add(station);
                table.insert(registerNum, list);
            } else {
                ArrayList<Station> list = current.element.value;
                list.add(station);
                table.insert(registerNum, list);
            }
        }
        int W = Integer.parseInt(sc.nextLine());
        String line;
        while (!(line = sc.nextLine()).equals("-1 kraj")) {
            String[] parts = line.split("\\s+");
            int tons = Integer.parseInt(parts[0]);
            String plate = parts[1];
            SLLNode<MapEntry<String, ArrayList<Station>>> current = table.search(plate);
            if (current != null && tons < W) {
                for (Station station : current.element.value) {
                    System.out.println(station.toString());
                }
            }
        }
    }
}
