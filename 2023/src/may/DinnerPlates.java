package may;

import java.util.HashMap;
import java.util.Map;

/**
 * 1172. 餐盘栈
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 *
 * 实现一个叫「餐盘」的类 DinnerPlates：
 *
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 *
 *
 * 示例：
 *
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 *
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 *                                     1  3  5
 *                                     ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 *                                           1  3  5
 *                                           ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 *                                    1  3  5
 *                                    ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 *                                    1  3  5
 *                                    ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 *                                             1  3  5
 *                                             ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 *                                             1  3  5
 *                                             ﹈ ﹈ ﹈
 * D.pop()            // 返回 5。栈的现状为：        4
 *                                             1  3
 *                                             ﹈ ﹈
 * D.pop()            // 返回 4。栈的现状为：    1  3
 *                                            ﹈ ﹈
 * D.pop()            // 返回 3。栈的现状为：    1
 *                                            ﹈
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 */
public class DinnerPlates {

    /**
     * 每个node里面的最大容量
     */
    private final int capacity;

    /**
     * 所有的节点
     */
    private final TreeNode[] nodes;

    /**
     * 用来存储有哪些可用的Index
     */
    private IndexTreeNode indexQueue;

    /**
     * 存储已用的下标
     */
    private IndexTreeNode maxIndex = new IndexTreeNode( -1 );

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.nodes = new TreeNode[200001];

        IndexTreeNode indexQueue = new IndexTreeNode(0);
        this.indexQueue = indexQueue;
        // 初始化所有可用的index
        for (int i = 1; i < 200001; i++) {
            indexQueue.next = new IndexTreeNode( i, indexQueue );
            indexQueue = indexQueue.next;
        }
    }

    /**
     * 将给出的正整数val推入从左往右第一个没有满的栈。
     * @param val
     */
    public void push(int val) {
        // 获取第一个可用的index
        int firstIndex = indexQueue.index;
        // 获取对应的node节点
        TreeNode node = nodes[firstIndex];
        if (node == null || node.first == null) {
            // 如果node节点是空的，初始化一下
            node = TreeNode.init(val, capacity);
            // 把初始化出来的节点，放进节点集合
            nodes[firstIndex] = node;
        } else {
            // 追加一个节点
            node.appendNode(val);
        }

        // 如果当前节点的所在的节点总和已经超过容量，把当前index剔除出去
        if (node.first.size >= capacity) {
            indexQueue = indexQueue.pop();
        }
        maxIndex = maxIndex.offer1( firstIndex );
    }

    /**
     * 返回从右往左第一个非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回-1。
     * @return
     */
    public int pop() {
        return popAtStack(maxIndex.index);
    }

    /**
     * 返回编号index的栈顶部的值，并将其从栈中删除；如果编号index的栈是空的，请返回 -1。
     * @param index 下标
     * @return
     */
    public int popAtStack(int index) {
        if (index < 0) {
            return -1;
        }
        TreeNode treeNode = nodes[index];
        // 如果编号index的栈是空的，返回 -1。
        if (treeNode == null) {
            return -1;
        }
        boolean isLast = treeNode.isLast();
        int topNum = treeNode.removeLastNode();
        if (isLast) {
            nodes[index] = null;
        }
        indexQueue = indexQueue.offer( index );
        if (isLast) {
            maxIndex.offer2( index );
        }
        return topNum;
    }

    static class TreeNode {
        // 当前的元素的值
        public int val;
        // 容量
        public int capacity;
        // size（仅first拥有此数据）
        public int size = 0;
        // 记录前一个元素
        public TreeNode prev;
        // 记录后一个元素
        public TreeNode next;
        // 记录头部
        public TreeNode first;
        // 记录尾部（firstNode拥有此节点）
        public TreeNode last;

        /**
         * 初始化
         * @param val
         * @return
         */
        public static TreeNode init(int val, int capacity) {
            return new TreeNode(val, capacity);
        }

        /**
         * 追加节点
         * @return
         */
        public void appendNode(int val) {
            new TreeNode( val, this );
        }

        /**
         * 是否最后一个节点
         * @return 是否最后一个节点
         */
        public boolean isLast() {
            return !isNotLast();
        }

        /**
         * 不是最后一个节点
         * @return 不是最后一个节点
         */
        public boolean isNotLast() {
            return this.first.size > 1;
        }

        /**
         * 移除最后一个节点
         * @return 移除的节点数量
         */
        public int removeLastNode() {
            if (this.isLast()) {
                return this.val;
            }

            // 更改sum和last
            TreeNode firstNode = this.first, lastNode = firstNode.last;

            --firstNode.size;
            firstNode.last = last.prev;

            // 移除最后的节点
            if (this.prev != null) {
                // 更改上一个节点的next
                this.prev.next = null;
            }

            return lastNode.val;
        }


        protected TreeNode() {}

        protected TreeNode(int val, int capacity) {
            this.val = val;
            this.capacity = capacity;
            ++this.size;
            this.first = this;
            this.last = this;
        }

        private TreeNode(int val, TreeNode prev) {
            TreeNode curr = new TreeNode();
            // 将当前节点的值设置成val
            curr.val = val;
            // 将当前节点的上一个节点设置成prev
            curr.prev = prev;
            // 将当前节点的第一个节点设置成统一的
            curr.first = prev.first;

            // 将上一个节点的下一个节点设置成当前数据
            prev.next = curr;

            // 找到第一个节点
            TreeNode first = curr.first;
            // 将当前节点设置成最后一个节点
            first.last = curr;
            // 计算一整个node的sum
            first.size++;
        }
    }

    static class IndexTreeNode {
        public int index;
        public IndexTreeNode prev;
        public IndexTreeNode next;

        public IndexTreeNode(int index) {
            this.index = index;
        }

        public IndexTreeNode(int index, IndexTreeNode prev) {
            this.index = index;
            this.prev = prev;
        }

        public IndexTreeNode pop() {
            if (this.next != null) {
                this.next.prev = null;
            }
            return this.next;
        }

        public IndexTreeNode offer(int index) {
            if (index == this.index) {
                return this;
            }
            if (index < this.index) {
                IndexTreeNode first = new IndexTreeNode(index);
                this.prev = first;
                first.next = this;
                return first;
            }
            IndexTreeNode curr = this;
            while (curr.index != index) {
                if (curr.next == null || index < curr.next.index) {
                    IndexTreeNode next = new IndexTreeNode( index, curr );
                    next.next = curr.next;
                    curr.next = next;
                    break;
                }
                curr = curr.next;
            }
            return this;
        }

        public IndexTreeNode offer1(int index) {
            if (index == this.index) {
                return this;
            }
            if (index > this.index) {
                IndexTreeNode first = new IndexTreeNode(index);
                this.prev = first;
                first.next = this;
                return first;
            }
            IndexTreeNode curr = this;
            while (curr.index != index) {
                if (curr.next == null || index > curr.next.index) {
                    curr.next = new IndexTreeNode( index, curr );
                    break;
                } else {
                    curr = curr.next;
                }
            }
            return this;
        }

        public void offer2(int index) {
            IndexTreeNode curr = this;
            while (true) {
                if (curr == null) {
                    break;
                }
                // 当前就是index。
                // 要做的事情就是把curr.prev.next 替换成curr.next
                // curr.next.prev = curr.prev
                if (index == curr.index) {
                    if (curr.prev == null) {
                        curr.index = curr.next.index;
                        curr.next = curr.next.next;
                    } else {
                        curr.prev.next = curr.next;
                        if (curr.next != null) {
                            curr.next.prev = curr.prev;
                        }
                    }
                    break;
                }
                curr = curr.next;
            }
        }
    }
}

