package javaPratice;


//sorted array, find the key
//{2, 4, 5 ,6 ,8, 9, 10, 11, 12};
public class JioTest {

    public static void main(String[] args) {
        int[] nums = {2, 4, 5 ,6 ,8};
        int key =  8;

       // System.out.println(search(nums, key));
    }

   /* public static int finaliseBoundry(ArrayIndex arrIndex,  int key){ //5
        int start = 0;
        int end = 1;

        while(arrIndex.getIndex(end) < key){
            int newStart = end+1;// 2
            end = end*2;
        }

        return search(nums, newStart, end, key);
    }*/

    private static int search(int[] nums, int start, int end, int key) {

        while(start <= end){

            int mid = start + (end - start)/2;

            if(nums[mid] == key){
                return mid;
            }else if(nums[mid] > key){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }
        return -1;
    }
}
