package contest.y2022.m1.week;

import com.code.leet.entiy.TwoArray;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution277 {
    public static void main(String[] args) {
        Solution277 solution = new Solution277();
        TwoArray twoArray = new TwoArray("[[2,0,2,2,0],[2,2,2,1,2],[2,2,2,1,2],[1,2,0,2,2],[1,0,2,1,2]]", true);
        solution.maximumGood(twoArray.getArr());
    }

    public int countElements(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = nums.length - 2;
        int bef = nums[0];
        int end = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == bef || nums[i] == end) {
                count--;
            }
        }
        return count;
    }

    public int[] rearrangeArray(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        Queue<Integer> large = new LinkedList<>();
        Queue<Integer> small = new LinkedList<>();
        boolean isLarge = true;
        int index = 0;
        for (int num : nums) {
            if (isLarge) {
                if (!large.isEmpty()) {
                    result[index] = large.poll();
                    index++;
                    isLarge = false;
                    if (num > 0) {
                        large.add(num);
                    } else {
                        small.add(num);
                    }
                } else {
                    if (num > 0) {
                        result[index] = num;
                        index++;
                        isLarge = false;
                    } else {
                        small.add(num);
                    }
                }
            } else {
                if (!small.isEmpty()) {
                    result[index] = small.poll();
                    index++;
                    isLarge = true;
                    if (num > 0) {
                        large.add(num);
                    } else {
                        small.add(num);
                    }
                } else {
                    if (num < 0) {
                        result[index] = num;
                        index++;
                        isLarge = true;
                    } else {
                        large.add(num);
                    }
                }
            }
        }
        for (int i = index; i < size; i++) {
            if (isLarge) {
                result[i] = large.poll();
                isLarge = false;
            } else {
                result[i] = small.poll();
                isLarge = true;
            }
        }
        return result;
    }

    public List<Integer> findLonely(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (Math.abs(nums[i] - nums[i + 1]) > 1) {
                    list.add(nums[i]);
                }
            } else if (i == nums.length - 1) {
                if (Math.abs(nums[i] - nums[i - 1]) > 1) {
                    list.add(nums[i]);
                }
            } else {
                if (Math.abs(nums[i] - nums[i - 1]) > 1 && Math.abs(nums[i] - nums[i + 1]) > 1) {
                    list.add(nums[i]);
                }
            }
        }
        return list;
    }

    public int maximumGood(int[][] statements) {
        max = 0;
        int[] pd = new int[statements.length];
        Arrays.fill(pd, 2);
        dfs(statements, pd, 0, 0);
        return max;
    }

    int max;

    private void dfs(int[][] statements, int[] pd, int index, int count) {
        if (index == statements.length) {
            max = Math.max(max, count);
            return;
        }
        int[] temp = Arrays.copyOf(pd, pd.length);
        if (temp[index] != 1) {
            temp[index] = 0;
            dfs(statements, temp, index + 1, count);
        }
        temp = Arrays.copyOf(pd, pd.length);
        if (temp[index] != 0) {
            temp[index] = 1;
            for (int i = 0; i < temp.length; i++) {
                if (i == index) {
                    continue;
                }
                if (temp[i] == 2) {
                    temp[i] = statements[index][i];
                } else if (statements[index][i] != 2 && temp[i] != statements[index][i]) {
                    return;
                }
            }
            dfs(statements, temp, index + 1, count + 1);
        }
    }
}
