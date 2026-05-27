class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();

        return dfs(price, special, needs, memo);
    }
    private static int dfs(List<Integer> price,
                           List<List<Integer>> special,
                           List<Integer> needs,
                           Map<List<Integer>, Integer> memo) {

        // Memoization
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int n = price.size();

        // Cost without any special offer
        int minCost = 0;

        for (int i = 0; i < n; i++) {
            minCost += needs.get(i) * price.get(i);
        }

        // Try every special offer
        for (List<Integer> offer : special) {

            List<Integer> remaining = new ArrayList<>();
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if (offer.get(i) > needs.get(i)) {
                    valid = false;
                    break;
                }

                remaining.add(needs.get(i) - offer.get(i));
            }

            // Use offer if valid
            if (valid) {

                int offerPrice = offer.get(n);

                minCost = Math.min(
                        minCost,
                        offerPrice + dfs(price, special, remaining, memo)
                );
            }
        }

        memo.put(needs, minCost);

        return minCost;
    }
}
