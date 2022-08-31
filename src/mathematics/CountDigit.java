package mathematics;

public class CountDigit {

    public static void main(String[] args) {
        System.out.println(countDigitOptimized(23));
    }

    private static int countDigit(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }
    private static int countDigitOptimized(int num) {
        return (int) (Math.log10(num)+1);
    }
    }
