package hanteo2;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] coins1 = {1, 2, 3};
        int target = 4;
        System.out.println("Output: " + countCombination(coins1, target));  // Output: 4

        int[] coins2 = {2, 5, 3, 6};
        int target2 = 10;
        System.out.println("Output: " + countCombination(coins2, target2));  // Output: 5
    }

    // dp or dfs로 푸는 방법
    // dp가 더 빠름 이전 정보를 저장하여 더 빠르게 조회
    // 시간 복잡도 O(n*t), 공간복잡도 O(t)
    public static int countCombination(int[] coins, int target) {
        int[] dp = new int[target + 1]; // dp[i] 합이 idx일때 조합의 수
        dp[0] = 1; // 0은 무조건 1개

        // 입력받은 coin을 돌면서 coin의 합이 주어진 sum보다 작거나 같을때까지 반복
        for (int coin : coins) {
            for (int sum = coin; sum <= target; sum++) {
                // dp[i]는 i-coin일떄 조합에 coin을 더하면 dp[i]가 되기에 dp[i-coin]을 dp[i]에 더해줌
                // 계단 문제와 비슷
                dp[sum] += dp[sum - coin];
            }
        }

        return dp[target];
    }
}
