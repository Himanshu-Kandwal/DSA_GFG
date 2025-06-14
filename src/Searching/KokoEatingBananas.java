package Searching;

import java.util.Arrays;

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        return kokoEat(piles, h);
    }

    public int kokoEat(int[] arr, int k) {
        Arrays.sort(arr);

        //max min possible ans possible
        int minAns = 1;
        int maxAns = arr[arr.length - 1];

        //do binary search from min to max possibility
        return searchAns(arr, minAns, maxAns, k);

    }

    public long totalHoursToEatUsingGivenS(int s, int[] arr) {
        long totalHours = 0; /*
                             long not int so we can handle big test cases
                             piles =
                             [805306368,805306368,805306368]
                             h =
                             1000000000
                             */

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
            long currAns = totalHoursToEatUsingGivenS(mid, arr);

            if (currAns <= k) {
                // Took too few hours ⇒ too fast ⇒ try slower ⇒ go left
                minAns = mid; //keep track of minimum ans as their would be multiple ans
                max = mid - 1;
            } else {
                // Took too many hours ⇒ too slow ⇒ need higher speed ⇒ go right
                min = mid + 1;

            }

        }
        return minAns;

    }
}
