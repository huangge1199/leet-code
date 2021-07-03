package leet.book.queueStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 轩辕龙儿
 * @date: 2021/7/2 16:09
 * @Description: No Description
 */
public class CanVisitAllRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int num = rooms.size();
            List<Integer> use = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            use.add(0);
            if (num == use.size()) {
                return true;
            }
            while (!queue.isEmpty()) {
                int open = queue.poll();
                for (int room : rooms.get(open)) {
                    if (use.contains(room)) {
                        continue;
                    }
                    queue.offer(room);
                    use.add(room);
                    if (num == use.size()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
