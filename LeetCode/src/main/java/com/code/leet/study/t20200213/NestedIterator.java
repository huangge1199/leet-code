package com.code.leet.study.t20200213;

/**
 * @Author: hyy
 * @Date: 2020-02-13 19:17
 */

import com.code.leet.entiy.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        NestedIterator i = new NestedIterator(nestedList);
        list = new ArrayList<>();
        while (i.hasNext()){
            list.add(i.next());
        }
    }

    @Override
    public Integer next() {
        if(nestedList.get(0).isInteger()){
            int num = nestedList.get(0).getInteger();
            nestedList.remove(0);
            return num;
        }else{
            List<NestedInteger> firstList,temp = firstList = nestedList.get(0).getList();
            while (!temp.get(0).isInteger()){
                temp = temp.get(0).getList();
            }
            int num = temp.get(0).getInteger();
            temp.remove(0);
            nestedList.set(0,firstList.get(0));
            return num;
        }
    }

    @Override
    public boolean hasNext() {
        if(nestedList.size()>0){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */