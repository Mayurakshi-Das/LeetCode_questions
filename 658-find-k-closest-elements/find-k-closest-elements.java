import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int starting = 0;
        int ending = arr.length - 1;
        while (ending - starting >= k) {
            if (Math.abs(arr[starting] - x) > Math.abs(arr[ending] - x)) {
                starting++;
            } else {
                ending--;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = starting; i <= ending; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

