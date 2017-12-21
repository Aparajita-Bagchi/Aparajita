
package codebooks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Codebooks {

    
    public static void main(String[] args) {
        int ATM_PIN = 7567;
        int Codebook_Pin = 8251;
        int sum = ATM_PIN + Codebook_Pin;
        if(sum>=10000){
            sum = sum%10000;
        }
        System.out.println("sum :" + sum);
        int sum_arr[] = new int[4];
        sum_arr[0] = sum/1000;
        sum_arr[1] = (sum/100)%10;
        sum_arr[2] = (sum/10)%10;
        sum_arr[3] = (sum%10);
        //System.out.println("array sum :" + sum_arr[0] + sum_arr[1] + sum_arr[2] + sum_arr[3]);
           
        System.out.println();
        String str = "0123456789";
        int n = str.length();
        String prefix = "";
        List<Integer> codes = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        int i,j,count;
        for(count=0;count<30;count++){
            Collections.shuffle(codes);
            String p = toFlatString(codes); 
            Long code = Long.parseLong(p);
            //System.out.println("actual number:" + code);
            int a[] = new int[10];
            a[9]= (int)(code%10);
            a[8]= (int)((code%100)/10);
            a[7]= (int)((code%1000)/100);
            a[6] = (int)((code%10000)/1000);
            a[5] = (int)((code%100000)/10000);
            a[4] = (int)((code%1000000)/100000);
            a[3] = (int)((code%10000000)/1000000);
            a[2] = (int)((code%100000000)/10000000);
            a[1] = (int)((code%1000000000)/100000000);
            if(code < 1000000000){
                a[0] = 0;
            }
            a[0] = (int) (code/1000000000);
           //System.out.println("code array : " +a[0]+ a[1] + a[2]+a[3]+a[4]+a[5]+a[6]+a[7]+a[8]+a[9]);
           int auth_final[] = new int[4];
           for(i=0;i<4;i++){
               for(j=0;j<10;j++){
                   if(sum_arr[i] == a[j]){
                       if(j<5){
                       auth_final[i] = a[j+5];
                       }
                       else{
                           auth_final[i] = a[j-5];
                       }
                   }
               }
           }
           System.out.println("final authentication code :"+auth_final[0] +auth_final[1]+auth_final[2]+auth_final[3] );
           //System.out.println();
            
        }
        
    }
    
private static String toFlatString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(i);
        return sb.toString();
    }
}
