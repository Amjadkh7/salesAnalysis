package salesProject;

public class Analysis {
    public static void main(String[] args) {
        // This is the sales data for stores and products
        int[][] sales = {
            {75, 100, 125},
            {90, 110, 130},
            {60, 95, 105},
            {200, 50, 170}
        };

        int sumAllStores = 0;
        int[] sumPerStore = new int[sales.length];
        int[] sumPerProduct = new int[sales[0].length];

        int maxSale = sales[0][0];
        int minSale = sales[0][0];
        int maxStore = 0;
        int maxProduct = 0;
        int minStore = 0;
        int minProduct = 0;

        // Loop through all sales to calculate sums, max, and min
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                int sale = sales[i][j];
                sumPerStore[i] += sale;
                sumPerProduct[j] += sale;
                sumAllStores += sale;

                if (sale > maxSale) {
                    maxSale = sale;
                    maxStore = i;
                    maxProduct = j;
                }
                if (sale < minSale) {
                    minSale = sale;
                    minStore = i;
                    minProduct = j;
                }
            }
        }

        double avgPerStore = (double) sumAllStores / sales.length;
        double avgPerProduct = (double) sumAllStores / sales[0].length;

        printSalesTable(sales);

        // Print totals and averages
        System.out.println("Total sales for all stores: " + sumAllStores);
        for (int i = 0; i < sales.length; i++) {
            System.out.println("Total sales for Store " + (i + 1) + ": " + sumPerStore[i]);
        }
        for (int j = 0; j < sales[0].length; j++) {
            System.out.println("Total sales for Product " + (j + 1) + ": " + sumPerProduct[j]);
        }
        System.out.println("Average sales per store: " + avgPerStore);
        System.out.println("Average sales per product: " + avgPerProduct);
        System.out.println("Highest sale: " + maxSale + " (Store " + (maxStore + 1) + ", Product " + (maxProduct + 1) + ")");
        System.out.println("Lowest sale: " + minSale + " (Store " + (minStore + 1) + ", Product " + (minProduct + 1) + ")");
    }

    // Just printing the sales table here
    public static void printSalesTable(int[][] sales) {
        System.out.println("Sales Data Table:");
        for (int i = 0; i < sales.length; i++) {
            System.out.print("Store " + (i + 1) + ": ");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

