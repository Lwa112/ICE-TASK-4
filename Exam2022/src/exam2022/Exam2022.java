/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exam2022;

/**
 *
 * @author massi
 */
public class Exam2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Single array that stores the provinces (Q.2 mark: "single array to store the provinces")
        String[] provinces = {"Gauteng", "Natal", "Cape"};

        // 2D array: rows = provinces, columns = flat, townhouse, house (Q.2.1)
        int[][] prices = {
            {800000, 1500000, 2000000},   // Gauteng
            {700000, 1200000, 1600000},   // Natal
            {750000, 1300000, 1800000}    // Cape
        };

        // Array that stores the average price for each province
        int[] averages = new int[provinces.length];

        // Calculate the average of the three property types for each province (Q.2.2)
        for (int i = 0; i < provinces.length; i++) {
            int total = 0;
            for (int j = 0; j < prices[i].length; j++) {
                total += prices[i][j];           // add up flat + townhouse + house
            }
            averages[i] = total / prices[i].length; // divide by 3 property types
        }

        // Print the table heading
        System.out.printf("%-12s%-15s%-15s%-15s%n", "", "FLAT", "TOWN HOUSE", "HOUSE");
        System.out.println("-----------------------------------------------------");

        // Print each province and its three prices
        for (int i = 0; i < provinces.length; i++) {
            System.out.printf("%-12s", provinces[i]);
            for (int j = 0; j < prices[i].length; j++) {
                System.out.printf("R %-13d", prices[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        // Print the average property price for each province
        for (int i = 0; i < provinces.length; i++) {
            System.out.println("Average property prices in " + provinces[i]
                    + " = R " + String.format(java.util.Locale.US, "%,d", averages[i]));
        }
    }
}
    