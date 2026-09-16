class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> d = new HashMap<>();

        for (int i : nums) {
            d.put(i, d.getOrDefault(i, 0) + 1);
        }

        for (int i : d.keySet()) {
            if (d.get(i) >= 2) {
                l.add(i);
            }
        }

        return l;
    }
}