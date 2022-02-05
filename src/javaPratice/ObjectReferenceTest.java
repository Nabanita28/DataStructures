package javaPratice;

public class ObjectReferenceTest {
        public static void main(String[ ] args){
            ObjectReferenceTest obj = new ObjectReferenceTest( );
            obj.start( );
        }
        void start( ){
            int [] P= new int[]{3, 5, 4};
            int[] Z = P;
            int[] Y = P;
            int [ ] Q= method(Z);
            int [ ] Q1= method(Y);
            System.out.print (P[0] + P[1] + P[2]+":");
            System.out.print (Q[0] + Q[1] + Q[2]);
        }

    int [ ] method(int [ ] R){
            R[1]=3;
            return R;
        }
    }
