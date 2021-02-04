package com.code.lint.y2020.m04.d026;

import java.util.HashMap;
import java.util.Map;

/**
 * 1673. 存钱
 * @Author: hyy
 * @Date: 2020-04-26 14:38
 */
public class GetAns {
    /**
     * @param op:   the type of information
     * @param name: the name of user
     * @param w:    the money need to save or take
     * @return: output the remaining money of the user.if the operation is illegal,output -1
     */
    public int[] getAns(int[] op, String[] name, int[] w) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        int[] result = new int[op.length];
        for (int i = 0; i < op.length; i++) {
            if (op[i] == 0) {
                if (map.containsKey(name[i])) {
                    map.put(name[i], map.get(name[i]) + w[i]);
                } else {
                    map.put(name[i], w[i]);
                }
                result[i] = map.get(name[i]);
            } else {
                if (map.containsKey(name[i])) {
                    if (map.get(name[i]) >= w[i]) {
                        map.put(name[i], map.get(name[i]) - w[i]);
                        result[i] = map.get(name[i]);
                    } else {
                        result[i] = -1;
                    }
                } else {
                    result[i] = -1;
                }
            }
        }
        return result;
    }
}
