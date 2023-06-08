package may;

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
class May1172 {

    public static void main(String[] args) {
        DinnerPlates dinnerPlates = new DinnerPlates( 2 );
        dinnerPlates.push( 1 );
        dinnerPlates.push( 2 );
        dinnerPlates.push( 3 );
        dinnerPlates.push( 4 );
        dinnerPlates.push( 5 );

        System.out.println( dinnerPlates.popAtStack( 0 ) );

        dinnerPlates.push( 20 );
        dinnerPlates.push( 21 );

        System.out.println( dinnerPlates.popAtStack( 0 ) );
        System.out.println( dinnerPlates.popAtStack( 2 ) );

        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println();

        //["DinnerPlates","push","push","push","popAtStack","pop","pop"]
        //[[1],[1],[2],[3],[1],[],[]]
        //[null,null,null,null,2,3,1]
        DinnerPlates dinnerPlates1 = new DinnerPlates( 1 );
        dinnerPlates1.push( 1 );
        dinnerPlates1.push( 2 );
        dinnerPlates1.push( 3 );
        System.out.println(dinnerPlates1.popAtStack( 1 ));
        System.out.println(dinnerPlates1.pop());
        System.out.println(dinnerPlates1.pop());
        System.out.println();

        //["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
        //[[2],[1],[2],[3],[4],[5],[0],[20],[21],[1],[1],[],[],[],[],[]]
        //[null,null,null,null,null,null,2,null,null,4,3,21,5,20,1,-1]
        DinnerPlates dinnerPlates2 = new DinnerPlates( 2 );
        dinnerPlates2.push( 1 );
        dinnerPlates2.push( 2 );
        dinnerPlates2.push( 3 );
        dinnerPlates2.push( 4 );
        dinnerPlates2.push( 5 );
        System.out.println(dinnerPlates2.popAtStack( 0 ));
        dinnerPlates2.push( 20 );
        dinnerPlates2.push( 21 );
        System.out.println(dinnerPlates2.popAtStack( 1 ));
        System.out.println(dinnerPlates2.popAtStack( 1 ));
        System.out.println(dinnerPlates2.pop());
        System.out.println(dinnerPlates2.pop());
        System.out.println(dinnerPlates2.pop());
        System.out.println(dinnerPlates2.pop());
        System.out.println(dinnerPlates2.pop());
        System.out.println();

        // ["DinnerPlates","push","push","push","push","push","push","push","push","popAtStack","popAtStack","popAtStack","popAtStack","push","push","push","push","push","push","push","push","pop","pop","pop","pop"]
        //[[2],[471],[177],[1],[29],[333],[154],[130],[333],[1],[0],[2],[0],[165],[383],[267],[367],[53],[373],[388],[249],[],[],[],[]]
        DinnerPlates dinnerPlates3 = new DinnerPlates( 2 );
        dinnerPlates3.push( 471 );
        dinnerPlates3.push( 177 );
        dinnerPlates3.push( 177 );
        dinnerPlates3.push( 1 );
        dinnerPlates3.push( 29 );
        dinnerPlates3.push( 333 );
        dinnerPlates3.push( 154 );
        dinnerPlates3.push( 130 );
        dinnerPlates3.push( 333 );
        System.out.println(dinnerPlates3.popAtStack( 1 ));
        System.out.println(dinnerPlates3.popAtStack( 0 ));
        System.out.println(dinnerPlates3.popAtStack( 2 ));
        System.out.println(dinnerPlates3.popAtStack( 0 ));
        dinnerPlates3.push( 165 );
        dinnerPlates3.push( 383 );
        dinnerPlates3.push( 267 );
        dinnerPlates3.push( 367 );
        dinnerPlates3.push( 53 );
        dinnerPlates3.push( 373 );
        dinnerPlates3.push( 388 );
        dinnerPlates3.push( 249 );
        System.out.println(dinnerPlates3.pop());
        System.out.println(dinnerPlates3.pop());
        System.out.println(dinnerPlates3.pop());
        System.out.println(dinnerPlates3.pop());
    }


}
