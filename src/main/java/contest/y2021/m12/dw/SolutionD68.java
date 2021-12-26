package contest.y2021.m12.dw;

import java.math.BigInteger;
import java.util.*;

public class SolutionD68 {
    public static void main(String[] args) {
        SolutionD68 solution = new SolutionD68();
//        solution.findAllRecipes(new String[]{"bread"}, Arrays.asList(Arrays.asList("yeast", "flour")), new String[]{"yeast", "flour", "corn"});
//        solution.abbreviateProduct(1,99999);
    }

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String str : sentences) {
            max = Math.max(str.split(" ").length, max);
        }
        return max;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], i);
        }
        List<String> sup = Arrays.asList(supplies);
        use = new int[recipes.length];
        list = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            use[i] = dfs(recipes[i], ingredients, sup, map);
        }
        HashSet<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    int[] use;
    List<String> list;

    private int dfs(String strs, List<List<String>> ingredients, List<String> sup, Map<String, Integer> map) {
        int i = map.get(strs);
        if (use[i] > 0) {
            return use[i];
        }
        boolean bl = true;
        for (String str : ingredients.get(i)) {
            if ((list != null && list.contains(str)) || sup.contains(str)) {
                continue;
            }
            if (map.containsKey(str) && use[map.get(str)] == 0) {
                if (use[map.get(str)] == 3) {
                    use[map.get(str)] = 2;
                    return 2;
                }
                use[i] = 3;
                if (dfs(str, ingredients, sup, map) == 2) {
                    bl = false;
                    break;
                }
            } else {
                bl = false;
                break;
            }
        }
        if (bl) {
            list.add(strs);
        }
        return bl ? 1 : 2;
    }


    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                min = Math.max(min - 1, 0);
                max += 1;
            } else if (s.charAt(i) == '(') {
                min += 1;
                max += 1;
            } else {
                min = Math.max(min - 1, 0);
                max -= 1;
                if (max < 0) {
                    return false;
                }
            }
        }
        return min == 0 && max % 2 == 0;
    }
}
