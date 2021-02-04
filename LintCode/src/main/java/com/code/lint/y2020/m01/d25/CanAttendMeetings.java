package com.code.lint.y2020.m01.d25;

import entiy.Interval;

import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-25 23:42
 */
public class CanAttendMeetings {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        for (int i = 0;i<intervals.size();i++){
            for (int j=i+1;j<intervals.size();j++){
                if(intervals.get(i).getStart()>=intervals.get(j).getStart()){
                    if(intervals.get(i).getStart()>=intervals.get(j).getEnd()){
                        Interval temp = intervals.get(i);
                        intervals.set(i, intervals.get(j));
                    }else{
                        return false;
                    }
                }else{
                    if(intervals.get(i).getEnd()>intervals.get(j).getStart()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
