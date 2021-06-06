package dataStructuresPractice.math;

public class MinSpeedOnTime {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {

        double hour_temp = hour;
        int n = dist.length;

        if(hour > n-1){
            int speed = 1;
            for(int i=0; i<n; i++){

                double time = Double.valueOf(dist[i])/speed;

                if(i == n-1){
                    hour_temp =  hour_temp - time;
                }else{
                    hour_temp =  hour_temp - Math.ceil(time);
                }


                if(hour_temp >= 0){
                    continue;
                }else{
                    speed++;
                    i=-1;
                    hour_temp = hour;
                }
            }
            return speed;
        }

        return -1;
    }
}
