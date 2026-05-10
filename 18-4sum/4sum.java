class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> rez = new ArrayList<>();

        for (int a = 0; a < len - 3; a++) {

            int numA = nums[a];

            if (a > 0 && numA == nums[a - 1]) {
                continue;
            }

            if ((long) numA + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }

            for (int b = a + 1; b < len - 2; b++) {
                int numB = nums[b];

                if (b > a + 1 && numB == nums[b - 1]) {
                    continue;
                }

                if ((long) numA + numB + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }

                int c = b + 1;
                int d = len - 1;

                while (c < d) {
                    int numC = nums[c];
                    int numD = nums[d];

                    long sum = (long) numA + numB + numC + numD;

                    if (sum == target) {
                        rez.add(List.of(numA, numB, numC, numD));
                        c++;
                        d--;

                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }

                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }

                    } else if (sum > target) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }

        return rez;
    }
}