package com.code.lint.entiy;

/**
 * @Author: hyy
 * @Date: 2020-01-25 23:45
 */
public class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
