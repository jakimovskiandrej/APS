package aud10;

import java.util.ArrayList;
import java.util.List;

public class Edge {

    private int fromVertex, toVertex;
    private int weight;

    public Edge(int from, int to, int weight) {
        this.fromVertex = from;
        this.toVertex = to;
        this.weight = weight;
    }

    public int getFrom() {
        return fromVertex;
    }

    public int getTo() {
        return toVertex;
    }

    public int getWeight() {
        return weight;
    }

}
