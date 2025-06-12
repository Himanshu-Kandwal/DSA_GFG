package Searching;

import java.util.Arrays;

class KokoEatingBananas {
    public int kokoEat(int[] arr, int k) {
        Arrays.sort(arr);

        //max min possible ans possible
        int minAns = 1;
        int maxAns = arr[arr.length - 1];

        //do binary search from min to max possibility
        return searchAns(arr, minAns, maxAns, k);

    }

    public int totalHoursToEatUsingGivenS(int s, int[] arr) {
        int totalHours = 0;

        for (int i = 0; i < arr.length; i++) {
            int currTime = (int) Math.ceil((double) arr[i] / s);
            totalHours += currTime;
        }

        return totalHours;
    }

    public int searchAns(int arr[], int min, int max, int k) {
        int minAns = Integer.MAX_VALUE;


        while (min <= max) {
            int mid = min + (max - min) / 2; //mid without overflow
            int currAns = totalHoursToEatUsingGivenS(mid, arr);

            if (currAns <= k) {
                // Took too few hours ⇒ too fast ⇒ try slower ⇒ go left
                max = mid - 1;
                minAns = Math.min(minAns, mid); //keep track of minimum ans as their would be multiple ans
            } else {
                // Took too many hours ⇒ too slow ⇒ need higher speed ⇒ go right
                min = mid + 1;

            }

        }
        return minAns;

    }
}

