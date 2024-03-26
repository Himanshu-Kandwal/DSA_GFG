package CodingChallenge.POTD;

public class BuySellAtMostTwice {

    public static void main(String[] args) {
        int n = 6;
        int prices[] = {10, 22, 5, 75, 65, 80};
        Solution.helper(prices, true, 0, 0);
    }

    static class Solution {
        public static int maxProfit(int n, int[] price) {
            return helper(price, true, 0, 0);
        }

        private static int helper(int[] price, boolean isBeingPurchased, int purchasedPrice, int idx) {

            if (isBeingPurchased && purchasedPrice != 0) {
                int a1 = price[idx] - purchasedPrice;
                int a2 = helper(price, false, 0, idx + 1); //ans from others
                return Math.max(a1, a2);
            } else {
                int a1 = helper(price, true, price[idx], idx + 1); //ans from others;
                int a2 = helper(price, true, price[idx], idx + 1); //ans from others;
                return Math.max(a1, a2);
            }
        }
    }

}
