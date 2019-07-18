import java.io.IOException;

public class KnapSack {
    static int solveProblem(int total, int[] arr) {
        int[] knapsack = new int[total + 1];
        knapsack[0] = 0;
        for (int maxSack = 1; maxSack <= total; maxSack++) {
            int[] subSolutions = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (maxSack >= arr[i]) {
                    subSolutions[i] = arr[i] + knapsack[maxSack - arr[i]];
                } else {
                    subSolutions[i] = 0;
                }
            }
            knapsack[maxSack] = subSolutions[0];
            for (int i = 0; i < arr.length; i++) {
                if (subSolutions[i] > knapsack[maxSack]) {
                    knapsack[maxSack] = subSolutions[i];
                }
            }
        }
        return knapsack[total];
    }

    public static void main(String[] args) throws IOException {
        int total = 12;
        int []arr = {1,6,9};
        int result = solveProblem(total, arr);
        System.out.println(result);
    }
}