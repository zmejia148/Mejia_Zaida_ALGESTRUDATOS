package recursivo;

import java.util.*;

public class OptimizationProgram {

    static int[] values = {60, 100, 120};
    static int[] weights = {10, 20, 30};
    static int capacity = 50;

    public static int knapsackRecursive(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapsackRecursive(W, wt, val, n - 1);

        return Math.max(
            val[n - 1] + knapsackRecursive(W - wt[n - 1], wt, val, n - 1),
            knapsackRecursive(W, wt, val, n - 1)
        );
    }

    public static int knapsackBottomUp(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][W];
    }

    public static int knapsackTopDown(int W, int[] wt, int[] val, int n, int[][] memo) {
        if (n == 0 || W == 0)
            return 0;

        if (memo[n][W] != -1)
            return memo[n][W];

        if (wt[n - 1] > W)
            memo[n][W] = knapsackTopDown(W, wt, val, n - 1, memo);
        else
            memo[n][W] = Math.max(
                val[n - 1] + knapsackTopDown(W - wt[n - 1], wt, val, n - 1, memo),
                knapsackTopDown(W, wt, val, n - 1, memo)
            );

        return memo[n][W];
    }

    public static void main(String[] args) {
        int n = values.length;

        System.out.println("Resultado recursivo: " + knapsackRecursive(capacity, weights, values, n));

        System.out.println("Resultado bottom-up: " + knapsackBottomUp(capacity, weights, values, n));

        int[][] memo = new int[n + 1][capacity + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        System.out.println("Resultado top-down: " + knapsackTopDown(capacity, weights, values, n, memo));

        long start, end;

        start = System.nanoTime();
        knapsackRecursive(capacity, weights, values, n);
        end = System.nanoTime();
        System.out.println("Tiempo recursivo: " + (end - start) + " ns");

        start = System.nanoTime();
        knapsackBottomUp(capacity, weights, values, n);
        end = System.nanoTime();
        System.out.println("Tiempo bottom-up: " + (end - start) + " ns");

        start = System.nanoTime();
        knapsackTopDown(capacity, weights, values, n, memo);
        end = System.nanoTime();
        System.out.println("Tiempo top-down: " + (end - start) + " ns");
    }
}
