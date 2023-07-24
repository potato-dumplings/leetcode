package jul;

import java.util.*;

public class Jul59 {

    public static class MaxQueue {
        private Queue<Integer> queue;
        private Deque<Integer> sortQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            sortQueue = new LinkedList<>();
        }

        /**
         * 获取当前最大值
         *
         * @return
         */
        public int max_value() {
            if (sortQueue.isEmpty()) {
                return -1;
            }
            return sortQueue.getFirst();
        }

        /**
         * 将值按大小推进队列
         *
         * @param value
         */
        public void push_back(int value) {
            queue.add( value );
            while(!sortQueue.isEmpty() && sortQueue.peekLast() < value){
                sortQueue.pollLast();
            }
            sortQueue.offer(value);
        }

        /**
         * 取出最先放进队列的数据
         *
         * @return
         */
        public int pop_front() {
            Integer integer = queue.poll();
            if (integer == null) {
                return -1;
            }
            if(integer.equals(sortQueue.peek())){
                // 删除所维护双端队列的队首元素;
                sortQueue.poll();
            }

            return integer;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back( 8 );
        maxQueue.push_back( 6 );
        maxQueue.push_back( 7 );
        maxQueue.push_back( 1 );
        maxQueue.max_value();
        maxQueue.pop_front();
        maxQueue.pop_front();
        maxQueue.max_value();
    }

}
