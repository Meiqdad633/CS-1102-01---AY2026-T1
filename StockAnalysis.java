import java.util.ArrayList;

public class StockAnalysis {

    // 1. Calculate average price from array
    public static double calculateAveragePrice(int[] prices) {
        double sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    // 2. Find maximum price from array
    public static int findMaximumPrice(int[] prices) {
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    // 3. Count occurrences of a specific price in array
    public static int countOccurrences(int[] prices, int target) {
        int count = 0;
        for (int price : prices) {
            if (price == target) {
                count++;
            }
        }
        return count;
    }

    // 4. Compute cumulative sum using ArrayList
    public static ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> prices) {
        ArrayList<Integer> cumulative = new ArrayList<>();
        int sum = 0;
        for (int price : prices) {
            sum += price;
            cumulative.add(sum);
        }
        return cumulative;
    }

    // Main method to test functionality
    public static void main(String[] args) {
        // Example array of stock prices (10 days)
        int[] stockPricesArray = {100, 105, 102, 110, 98, 97, 103, 115, 108, 106};

        // Example ArrayList of stock prices
        ArrayList<Integer> stockPricesList = new ArrayList<>();
        for (int price : stockPricesArray) {
            stockPricesList.add(price);
        }

        // Calling and printing results
        System.out.println("Average Price: " + calculateAveragePrice(stockPricesArray));
        System.out.println("Maximum Price: " + findMaximumPrice(stockPricesArray));
        System.out.println("Occurrences of 103: " + countOccurrences(stockPricesArray, 103));
        System.out.println("Cumulative Sum: " + computeCumulativeSum(stockPricesList));
    }
}
