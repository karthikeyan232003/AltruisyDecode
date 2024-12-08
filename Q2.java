import java.util.*;

public class Q2 {

    public static int[] countBeesBetweenFlowers(String s, int[] startIndex, int[] endIndex) {
        int n = s.length();
        int m = startIndex.length;

        // Precompute prefix sums for '*' (bees)
        int[] prefixBeeCount = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixBeeCount[i + 1] = prefixBeeCount[i] + (s.charAt(i) == '*' ? 1 : 0);
        }

        // Precompute leftmost and rightmost flowers for each index
        int[] leftMostFlower = new int[n];
        int[] rightMostFlower = new int[n];
        Arrays.fill(leftMostFlower, -1);
        Arrays.fill(rightMostFlower, -1);

        // Fill leftmost flower positions
        int lastFlower = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastFlower = i;
            }
            leftMostFlower[i] = lastFlower;
        }

        // Fill rightmost flower positions
        lastFlower = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastFlower = i;
            }
            rightMostFlower[i] = lastFlower;
        }

        // Process each query
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int start = startIndex[i] - 1; // Convert to 0-based index
            int end = endIndex[i] - 1;

            // Find the valid range bounded by flowers
            int leftFlower = rightMostFlower[start];
            int rightFlower = leftMostFlower[end];

            if (leftFlower != -1 && rightFlower != -1 && leftFlower < rightFlower) {
                // Bees between flowers
                result[i] = prefixBeeCount[rightFlower] - prefixBeeCount[leftFlower + 1];
            } else {
                // No valid range
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input string s
        String s = scanner.nextLine();
        // Input startIndex array
        int n = scanner.nextInt();
        int[] startIndex = new int[n];
        for (int i = 0; i < n; i++) {
            startIndex[i] = scanner.nextInt();
        }
        // Input endIndex array
        int[] endIndex = new int[n];
        for (int i = 0; i < n; i++) {
            endIndex[i] = scanner.nextInt();
        }

        // Calculate results
        int[] result = countBeesBetweenFlowers(s, startIndex, endIndex);

        // Output results
        System.out.println("Results:");
        for (int res : result) {
            System.out.println(res);
        }

        scanner.close();
    }
}
