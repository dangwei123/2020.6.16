牛牛最近喜欢上了俄罗斯套娃、大鱼吃小鱼这些大的包住小的类型的游戏。
于是牛爸给牛牛做了一个特别版的大鱼吃小鱼游戏，他希望通过这个游戏
能够近一步提高牛牛的智商。
游戏规则如下：

现在有N条鱼，每条鱼的体积为Ai，从左到右拍成一排。
A数组是一个排列。
牛牛每轮可以执行一次大鱼吃小鱼的操作
一次大鱼吃小鱼的操作：对于每条鱼，它在每一次操作时会吃掉右边比自己小的第一条鱼
值得注意的时，在一次操作中，每条鱼吃比自己小的鱼的时候是同时发生的。
举一个例子，假设现在有三条鱼,体积为分别[5，4，3]，5吃4，4吃3，一次操作后就剩下[5]一条鱼。
牛爸问牛牛，你知道要多少次操作，鱼的数量就不会变了嘛？

import java.util.*;
public class Solution {
    /**
     * 
     * @param N int整型 N条鱼
     * @param A int整型一维数组 每条鱼的体积为Ai
     * @return int整型
     */
    public int solve (int N, int[] A) {
        // write code here
        int[] arr=new int[N+1];
        Stack<Integer> stack=new Stack<Integer>();
        int ret=0;
        for(int i=0;i<N;i++){
            if(stack.isEmpty()){
                stack.push(A[i]);
                continue;
            }
            int max=0;
            while(!stack.isEmpty()&&stack.peek()<A[i]){
                max=Math.max(max,arr[stack.pop()]);
            }
            stack.push(A[i]);
            if(stack.size()==1){
                continue;
            }
            arr[A[i]]=max+1;
            ret=Math.max(ret,arr[A[i]]);
        }
        return ret;
    }
}

