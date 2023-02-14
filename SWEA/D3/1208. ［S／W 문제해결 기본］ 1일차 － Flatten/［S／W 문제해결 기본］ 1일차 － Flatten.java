import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t = 1; t <= 10; t++){
            int dump = sc.nextInt();
            int[] arr = new int[100];
            for(int i = 0; i < 100; i++){
                arr[i] = sc.nextInt();
            }
            arr = bubble(arr);
            while(dump > 0){
                if(arr[99] - arr[0] <= 1) break;
                arr[99]--;
                arr[0]++;
                dump--;
                arr = bubble(arr);
            }
            System.out.printf("#%d %d\n", t, arr[99] - arr[0]);
        }
    }

    static int[] bubble(int[] arr){
        for(int i = arr.length-1; i > 0; i--){
            for(int j = 1; j <= i; j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
