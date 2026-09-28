package Week3.BT_LapTrinh;

import java.util.List;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3){
        int sum1=0, sum2=0, sum3=0;
        for(int x1:h1){
            sum1+=x1;
        }
        for(int x2:h2){
            sum2+=x2;
        }
        for(int x3:h3){
            sum3+=x3;
        }
        int i1=0,i2=0,i3=0;
        while(!(sum1==sum2 && sum1==sum3)){
            if(sum1 >= sum2 && sum1 >= sum3){
                sum1-=h1.get(i1);
                i1++;
            }
            else if(sum2 >= sum1 && sum2 >= sum3){
                sum2-=h2.get(i2);
                i2++;
            }
            else{
                sum3-=h3.get(i3);
                i3++;
            }
        }
        return sum1;
    }
}
