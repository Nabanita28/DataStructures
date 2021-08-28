package dataStructuresPractice.stack;

public class KStacksImplementation {

    static class KStacks{

        int n;
        int k;
        int free;
        int[] next;
        int[] top; //stores the index of the top of each stack
        int[] arr;

        public KStacks(int n, int k){
            this.n = n;
            this.k = k;
            free = 0;

            next = new int[n];
            for(int i=0; i<n; i++){
                next[i] = i+1;
            }
            next[n-1] = -1;

            top = new int[k];
            for(int i=0; i<k; i++){
                top[i] = -1;
            }
            arr = new int[n];
        }

        public boolean isFull(){
            return free == -1;
        }

        public boolean isEmpty(int stackNumber){
            return top[stackNumber] == -1;
        }

        public void push(int item, int stackNumber){

            if(isFull()){
                System.out.println("Stack is empty");
            }

            int i = free;
            arr[i] = item;

            free = next[i];
            next[i] = top[stackNumber];
            top[stackNumber] = i;
        }

        public int pop(int stackNumber){

            if(isEmpty(stackNumber)){
                System.out.println("Stack is empty");
                return -1;
            }

            int i = top[stackNumber];
            top[stackNumber] = next[i];
            //next[i] will hold previous value of free
            next[i] = free;
            free = i;

            return arr[i];
        }
    }

    public static void main(String[] args) {
        KStacks kstacks = new KStacks(10, 3);

        kstacks.push(1, 0);
        kstacks.push(2, 1);
        kstacks.push(3, 2);

        System.out.println("Popped element from stack 2 is " + kstacks.pop(2));
        System.out.println("Popped element from stack 1 is " + kstacks.pop(1));
        System.out.println("Popped element from stack 0 is " + kstacks.pop(0));
    }

}
