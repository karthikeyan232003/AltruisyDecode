import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] strengthLevels = new int[3][4]; // 3 rounds, 4 trainees

        // Input strength levels for each round and each trainee
        for (int round = 0; round < 3; round++) {
            for (int trainee = 0; trainee < 4; trainee++) {
                int strength = scanner.nextInt();
                if (strength < 1 || strength > 200) {
                    System.out.println("INVALID INPUT");
                    return;
                }
                strengthLevels[round][trainee] = strength;
            }
        }

        int[] averageStrengths = new int[4];
        int highestAverage = 0;

        // Calculate average strength for each trainee and find the highest average
        for (int trainee = 0; trainee < 4; trainee++) {
            int totalStrength = 0;
            for (int round = 0; round < 3; round++) {
                totalStrength += strengthLevels[round][trainee];
            }
            averageStrengths[trainee] = Math.round((float) totalStrength / 3);
            highestAverage = Math.max(highestAverage, averageStrengths[trainee]);
        }

        // Check if all trainees are unfit
        if (highestAverage < 100) {
            System.out.println("All trainees are unfit");
            return;
        }

        // Identify and display the strongest trainees
        System.out.println("Trainee(s) with the highest average strength:");
        for (int trainee = 0; trainee < 4; trainee++) {
            if (averageStrengths[trainee] == highestAverage) {
                System.out.println("Trainee Number : " + (trainee + 1));
            }
        }

        // Display the highest average strength
        System.out.println("Highest Average Strength: " + highestAverage);

        scanner.close();
    }
}
