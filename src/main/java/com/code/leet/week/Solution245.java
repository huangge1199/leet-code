package com.code.leet.week;

import com.code.leet.doubleWeek.SolutionD54;

import java.util.ArrayList;
import java.util.List;

public class Solution245 {

    public static void main(String[] args) {
        Solution245 solution = new Solution245();
        //2,1,0,7,2
        System.out.println(solution.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0}));
//        System.out.println(solution.maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
//        System.out.println(solution.maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4}));
//        System.out.println(solution.maximumRemovals("qobftgcueho", "obue", new int[]{5, 3, 0, 6, 4, 9, 10, 7, 2, 8}));
//        System.out.println(solution.maximumRemovals("qlevcvgzfpryiqlwy", "qlecfqlw", new int[]{12, 5}));
    }

    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        int size = words.length;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % size > 0) {
                return false;
            }
        }
        return true;
    }

//    public int maximumRemovals(String s, String p, int[] removable) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < removable.length; i++) {
//            list.add(removable[i]);
//            String temp = "";
//            for (int j = 0; j < s.length(); j++) {
//                if (!list.contains(j)) {
//                    temp += s.charAt(j);
//                }
//            }
//            if (!remove(temp, p)) {
//                return i;
//            }
//        }
//        return removable.length;
//    }
//
//    private boolean remove(String s, String p) {
//        int index = s.indexOf(p.charAt(0));
//        if (index < 0) {
//            return false;
//        }
//        s = s.substring(index + 1);
//        int i = 1;
//        for (; i < p.length(); i++) {
//            index = s.indexOf(p.charAt(i));
//            if (index >= 0) {
//                s = s.substring(index + 1);
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

    List<List<Integer>> slist = new ArrayList<>();

    public int maximumRemovals(String s, String p, int[] removable) {
        son(s, p, 0, new ArrayList<>());
        for (int i = 0; i < removable.length; i++) {
            for (int j = 0; j < slist.size(); j++) {
                if (slist.get(j).contains(removable[i])) {
                    slist.remove(j);
                    j--;
                    if (slist.size() == 0) {
                        return i;
                    }
                }
            }
        }
        return removable.length;
    }

    private void son(String s, String p, int index, List<Integer> list) {
        if (index == p.length()) {
            slist.add(list);
            return;
        }
        int temp = list.size() > 0 ? list.get(list.size() - 1) + 1 : 0;
        int sindex = s.substring(temp).indexOf(p.charAt(index)) + temp;
        if (sindex >= 0) {
            list.add(sindex);
            son(s, p, index + 1, list);
        } else {
            return;
        }
    }
}
