package Misc;

import java.io.IOException;
import java.util.*;

public class Main {

    static Scanner sc;

    public static void main(String[] hi) throws IOException {
        sc = new Scanner(System.in);
        int t = 1;
        while (t-- != 0) {
            if (sc.hasNext()) {
                long n = sc.nextLong();
                long x = sc.nextLong();
                bfs(x, n);
            }
        }
    }

    private static long sizeOfvalue(long a) {
        long c = 0;
        while (a > 0) {
            a /= 10;
            c++;
        }
        return c;
    }

    private static void bfs(long x, long length) throws IOException {
        Queue<Long> qu = new LinkedList<>();
        qu.add(x);
        Set<Long> set = new HashSet<>();
        int operation = 0;
        set.add(x);
        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size-- > 0) {
                long value = qu.poll();
                List<Long> li = numbers(value);

                if (sizeOfvalue(value) == length) {
                    System.out.println(operation);
                    return;
                }
                for (long mul : li) {
                    if (!set.contains(value * mul) && sizeOfvalue(value * mul) <= length) {
                        set.add(value * mul);
                        qu.add(mul * value);
                    }
                }
            }
            operation++;
        }
        System.out.println(-1);
    }

    private static List<Long> numbers(long x) {
        List<Long> li = new ArrayList<>();
        long v = x;
        while (v > 0) {
            if (v % 10 != 0 && v % 10 != 1) {
                li.add(v % 10);
            }
            v = v / 10;
        }
        return li;
    }
}
