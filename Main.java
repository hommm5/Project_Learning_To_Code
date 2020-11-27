package SumOfCoins;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        int[] ints = Arrays.stream(coins).sorted().toArray();

        Map<Integer, Integer> usedCoins = chooseCoins(ints, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    private static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int index = coins.length - 1;
        int result;
        int currentSum = targetSum;
        int count=0;

        while (index >= 0) {
            result = currentSum / coins[index];
            if (result != 0) {
                map.put(coins[index], result);
                count+=result;
                currentSum -= (coins[index] * result);
            }


            index--;

        }
        if (currentSum > 0){
            System.out.println("Error");
            return new HashMap<>();
        }
        System.out.println("Number of coins to take: "+count);
        return map;
    }
}

