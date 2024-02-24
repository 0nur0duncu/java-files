import java.util.*;
public class deneme {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        int n = arr.length;
        //seçmeli sıralama
        //-----------------------------------------------

        /*for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++)
                if(arr[j]<arr[min]) min = j;
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }*/

        
        //------------------------------------------------
        //kabarcık sıralama
        //------------------------------------------------

        /*for(int i=0;i<n-1;i++)
            for(int j=0;j<n-i-1;j++)
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }*/
        
        
        //------------------------------------------------
        //eklemeli sıralama
        //------------------------------------------------
        
        /*for(int i=1;i<n;++i){
            int key = arr[i];
            int j= i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }*/

        for(int i:arr) System.out.println(i);
    }
}