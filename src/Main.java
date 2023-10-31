import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);

        // Prompt the user to input the total budget.
        System.out.println("How much can you spend?");
        double total = scan.nextDouble();
        double sum = 0;
        int i = 0;

        // Create an ArrayList to store expense proportions.
        ArrayList<Double> proportion = new ArrayList<Double>();

        // Prompt the user to enter proportions for various expenses.
        System.out.println("Enter your proportion of various expenses.");
        System.out.println("The system stops if cumulative proportions exceed 100.");

        do {
            // Prompt the user to input the proportion of each expense.
            System.out.println("Your proportion of expense " + (i + 1) + ": ");
            double value = scan.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        } while (sum <= 100);
        scan.close();

        // Adjust proportions if they exceed 100%.
        if (sum > 100) {
            double cumulativeSum = 0.0;
            for (int j = 0; j < proportion.size() - 1; j++) {
                cumulativeSum += proportion.get(j);
            }
            proportion.set(proportion.size() - 1, 100.0 - cumulativeSum);
        }

        // Calculate and display expenses based on proportions and the total budget.
        for (double value : proportion) {
            double expense = value * total / 100.0;
            System.out.println("Your " + value + " % equals $" + expense);
        }
    }
}
