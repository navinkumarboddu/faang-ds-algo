package org.faang.arrays;

/*
Richest Customer Wealth
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.

Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation:
1st customer has wealth = 6
2nd customer has wealth = 10
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.

Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17

Constraints:

m == accounts.length
n == accounts[i].length
1 <= m, n <= 50
1 <= accounts[i][j] <= 100
 */
public class RichestCustomerWealth {

    static class Pair{
        int index;
        int wealth;

        public Pair(int index, int wealth){
            this.index = index;
            this.wealth = wealth;
        }
    }

    public static void main(String[] args) {
        int[][] accounts = {{1,5},{7,3},{3,5}};
        int index = maximumWealth(accounts);
        System.out.println(index);
    }

    public static int maximumWealthPair(int[][] accounts) {
        int array_size = accounts.length;
        Pair[] wealths = new Pair[array_size];
        int maxWealth = 0;
        int count = 0;
        for (int[] account: accounts){
            for (int wealth : account){
                maxWealth += wealth;
            }
            wealths[count] = new Pair(count, maxWealth);
            count++;
            maxWealth = 0;
        }
        int max = wealths[0].wealth;
        int pairIndex = 0;
        for (Pair wealthPair : wealths){
            if(wealths[pairIndex].wealth < wealthPair.wealth){
                pairIndex = wealthPair.index;
            }
        }
        return pairIndex;
    }

    public int maximumWealth(int[][] accounts) {
        int array_size = accounts.length;
        int[] wealths = new int[array_size];
        int maxWealth = 0;
        int count = 0;
        for (int[] account: accounts){
            int currentWealth = 0;
            for (int wealth : account){
                currentWealth += wealth;
            }
            //wealths[count] = maxWealth;
            if(maxWealth < currentWealth){
                maxWealth = currentWealth;
            }
            //count++;
            //maxWealth = 0;
        }
        //maxWealth = wealths[0];
        //for (int wealth : wealths){
        //    if(maxWealth < wealth){
        //        maxWealth = wealth;
        //    }
        //}
        return maxWealth;
    }
}
