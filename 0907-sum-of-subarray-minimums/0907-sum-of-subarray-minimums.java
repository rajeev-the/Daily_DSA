class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;

       long ans = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {

            int val = arr[i];

            while (!st.isEmpty() && arr[st.peek()] > val) {
                st.pop();
            }
            if (!st.isEmpty()) {
                left[i] = i - st.peek();
            } else {
                left[i] = 1 + i;
            }

            st.push(i);

        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
             
             int val = arr[i];

            while (!st.isEmpty() && arr[st.peek()] >= val) {
                st.pop();
            }

            if (!st.isEmpty()) {
                right[i] = st.peek() -i ;
            } else {
                right[i] = n-i;
            }

            st.push(i);
        }


        for(int i =0 ; i < n ; i++){
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }

         return (int) ans;
    }
}