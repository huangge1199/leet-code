package com.code.lint.y2020.m02.d11;

/**
 * @Author: hyy
 * @Date: 2020-02-11 09:40
 */

import entiy.SVNRepo;

/**
 * public class SVNRepo {
 * public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
public class FindFirstBadVersion {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 1;
        int end = n;
        int index = (start + end) / 2;
        while (start < index && index < end) {
            if (SVNRepo.isBadVersion(index) == true) {
                end = index;
            } else {
                start = index;
            }
            index = (start + end) / 2;
        }
        if (SVNRepo.isBadVersion(start) == true) {
            index = start;
        } else {
            index = end;
        }
        return index;
    }
}
