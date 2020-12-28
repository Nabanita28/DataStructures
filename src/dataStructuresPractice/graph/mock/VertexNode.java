package dataStructuresPractice.graph.mock;

import java.util.Comparator;

public class VertexNode implements Comparator<VertexNode> {
        public int vertex;
        public int cost;
        public VertexNode(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        public VertexNode(){}

        @Override
        public int compare(VertexNode node1, VertexNode node2){
            if (node1.cost > node2.cost)
                return 1;

            if (node2.cost > node1.cost)
                return -1;

            return 0;
        }
    }
