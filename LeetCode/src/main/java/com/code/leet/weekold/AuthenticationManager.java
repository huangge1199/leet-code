package com.code.leet.weekold;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 轩辕龙儿
 * Date: 2021/3/20
 * Time: 22:42
 * Description: No Description
 */
public class AuthenticationManager {
    Map<String, Integer> map = new HashMap<>();
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && currentTime < map.get(tokenId)) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int num = 0;
        for (String key:map.keySet()) {
            if(map.get(key)>currentTime){
                num++;
            }
        }
        return num;
    }
}
