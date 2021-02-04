package com.code.lint.y2020.m01.d27;

import java.util.ArrayList;
import java.util.List;

/**
 * error
 * @Author: hyy
 * @Date: 2020-01-27 19:06
 *
 * 1751. 牛郎织女
 * cat-only-iconCAT 专属题目
 *
 * 又到了七夕节，牛郎织女相约一起去一个n*m大小的迷宫maze里玩耍。然而没过多久，他们就倒霉地走散了。现在给定由.,*,S,T组成的矩阵maze，
 * 其中.表示空地,*表示障碍物,S表示牛郎的位置 ,T表示织女的位置，牛郎和织女都会试图寻找对方，不停地在矩阵中走动(他们可以每次向上下左右四
 * 个方向移动一格或者站着不动，但是不能走到迷宫外面或者障碍物)，请问他们是否有可能重逢?如果有可能，返回True，否则返回False。
 *
 * 样例
 *
 * 样例1:
 *
 * 输入:
 * [
 * "S..*",
 * "*.**",
 * "...T"
 * ]
 * 输出: true
 * 说明:
 * 织女选择不动
 * 牛郎行动路线(0,0)->(0,1)->(1,1)->(2,1)->(2,2)->(2,3)
 *
 * 样例2:
 *
 * 输入:
 * [
 * "S..*",
 * "***.",
 * "...T"
 * ]
 * 输出: false
 * 说明：
 * 这两个人无论如何和碰不上了
 *
 * 注意事项
 *
 * 2<=n,m<=1000
 */

public class FindHer {
    /**
     * @param maze: the maze
     * @return: Can they reunion?
     */
    public boolean findHer(String[] maze) {
        // Write your code here
        List<String> strs = new ArrayList();
        int[][] num = new int[strs.size()][strs.get(0).length()];
        int x1=0,y1=0,x2=0,y2=0;
        for(int i = 0; i < maze.length; i++){
            strs.add(maze[i]);
            int index1 = maze[i].indexOf("S");
            if(index1>0){
                x1=i;
                y1=index1;
            }
            int index2 = maze[i].indexOf("T");
            if(index2>0){
                x2=i;
                y2=index1;
            }
        }
        for (int i = 0; i < num.length;i++){
            for(int j=0;j<num[0].length;j++){
                num[i][j]=0;
            }
        }
        return isFind(strs,x1,y1,x2,y2,num);
    }
    boolean isFind(List<String> strs,int x1,int y1,int x2,int y2,int[][] num){
        if(Math.abs(x1-x2)+Math.abs(y1-y2)==1){
            return true;
        }
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        if(x1-1>=0&&strs.get(x1-1).charAt(y1)=='.'&&num[x1-1][y1]==0){
            num[x1-1][y1] = 1;
            up = isFind(strs,x1-1,y1,x2,y2,num);
        }
        if(x1+1<strs.size()&&strs.get(x1+1).charAt(y1)=='.'&&num[x1+1][y1]==0){
            num[x1+1][y1] = 1;
            down = isFind(strs,x1+1,y1,x2,y2,num);
        }
        if(y1-1>=0&&strs.get(x1).charAt(y1-1)=='.'&&num[x1][y1-1]==0){
            num[x1][y1-1] = 1;
            left = isFind(strs,x1-1,y1,x2,y2,num);
        }
        if(y1+1<strs.get(0).length()&&strs.get(x1).charAt(y1+1)=='.'&&num[x1+1][y1]==0){
            num[x1][y1+1] = 1;
            right = isFind(strs,x1+1,y1,x2,y2,num);
        }
        return up||down||left||right;
    }
}
