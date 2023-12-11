package array.slidingWindow;

public class slidingWindow {

   // Fix size sliding window

    public static int maxSumFixedSize(int[] arr, int k) {
        int n = arr.length;

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];


        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum = (window_sum + arr[i]) - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }



    // Sliding Window variable size template

 /*
    while(j < size()){

            // Calculation's happen's here
            -----------------------------------------------
            if(condition < k){
                j++;
            }
            -----------------------------------------------

                    -----------------------------------------------
        else if(condition == k){
                // ans <-- calculation
                j++;
            }
            ----------------------------------------------

                    ----------------------------------------------
        else if(condition > k){
                while(condition > k){
                    // remove calculation for i
                    i++;
                }
                j++;
            }
            ----------------------------------------------
        }

    return ans;

  */

    // Driver code
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1, 2, 1, 5, 3};
        int windowSize = 4;
        System.out.println(maxSumFixedSize(arr, windowSize));
    }
}
