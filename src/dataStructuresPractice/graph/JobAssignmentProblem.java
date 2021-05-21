package dataStructuresPractice.graph;

public class JobAssignmentProblem {
    public static void main(String[] args) {

    }
 static int N = 4;
    class Node{
        // stores parent node of current node
        // helps in tracing path when answer is found
        Node parent;

        // contains cost for ancestors nodes
        // including current node
        int pathCost;

        // contains least promising cost
        int cost;

        // contain worker number
        int workerID;

        // contains Job ID
        int jobID;

        // Boolean array assigned will contains
        // info about available jobs
        boolean[] assigned = new boolean[N];

        Node(int person, int job, boolean[] assigned, Node parent){

            for(int i=0; i<N; i++){
                this.assigned[i] = false;
            }
            this.assigned[job] = true;
            this.parent = parent;
            this.workerID = person;
            this.jobID = job;
        }
    }
}
