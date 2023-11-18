public class Main {
    static final String USAGE = ("Usage: Main [numOfDice]d[numOfSides] [dropLowest] [dropHighest]");
    
    public static void main (String[] args) {
        int[] input = parseInput(args);
        int numOfDice = input[0];
        int numOfSides = input[1];
        int dropLowest = input[2];
        int dropHighest = input[3];

        // no need to run through the counter if it can be easily calculated mathematically
        if (dropLowest == 0 && dropHighest == 0) {
            double mean = (double) numOfDice * (numOfSides + 1)/2;
            double standDev = Math.sqrt(numOfDice * (Math.pow(numOfSides, 2) - 1)/12);
            displayResults(mean, standDev);
            System.exit(1);
        }

        int[] X = new int[numOfSides];
        int[] XSum = new int[numOfSides * (numOfDice - (dropLowest + dropHighest))];
        int combTotal = 0;
        DynamicCounter counter = new DynamicCounter(numOfDice, numOfSides);
        // Brute forcing every dice combination
        while (!counter.done) {
            for (int num : counter.getCombinations(dropLowest, dropHighest)) {
                X[num - 1] += 1;
                combTotal += num;
            }
            XSum[combTotal - 1] += 1;
            combTotal = 0;
            counter.downOne();
        }

        // calculating mean:
        double x_iTotal = 0d;
        for (int i = 0; i < X.length; i++) {
            x_iTotal += X[i] * (i+1);
        }
        double mean = x_iTotal/Math.pow(numOfSides, numOfDice);

        // calculating standard deviation:
        double x_iDiffSquaredTotal = 0d;
        double XSumTotal = 0d;
        for (int i = 0; i < XSum.length; i++) {
            x_iDiffSquaredTotal += XSum[i] * Math.pow(i+1 - mean, 2);
            XSumTotal += XSum[i];
        }
        double standDev = Math.pow(x_iDiffSquaredTotal/XSumTotal, .5);

        displayResults(mean, standDev);
    }

    private static int[] parseInput(String[] args) {
        int[] input = new int[4];
        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }
        if (args.length == 2) {
            input[2] = Integer.parseInt(args[1]);
        }
        if (args.length >= 3) {
            input[3] = Integer.parseInt(args[2]);
        }

        String[] xdY = args[0].split("d");
        input[0] = Integer.parseInt(xdY[0]);
        input[1] = Integer.parseInt(xdY[1]);
        if (input[0] <= 0 || input[1] <= 0) {
            System.out.println(USAGE);
            System.out.println("numOfDice and numOfSides must be positive integers.");
            System.exit(1);
        }
        if (input[2] < 0 || input[3] < 0) {
            System.out.println("dropLowest and dropHighest must be nonnegative");
            System.exit(1);
        }
        else if (input[2] + input[3] > input[0]){
            System.out.println(USAGE);
            System.out.println("Dropping too many dice: dropLowest + dropHighest <= numOfDice.");
            System.exit(1);
        }
        return input;
    }

    private static void displayResults(double mean, double stdDev) {
        int padding = String.format("%.3f", mean).indexOf('.') - String.format("%.3f", stdDev).indexOf('.');
        System.out.printf("              mean = %-32.3f %n", mean);
        if (padding > 0) {
            System.out.printf("standard deviation = %" + padding + "s%-32.3f %n", "", stdDev);
        }else {
            System.out.printf("standard deviation = %-32.3f %n", stdDev);
        }
    }
}
