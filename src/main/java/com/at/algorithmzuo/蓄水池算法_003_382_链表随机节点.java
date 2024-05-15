package com.at.algorithmzuo;

import java.util.Random;

// https://leetcode.cn/problems/linked-list-random-node/description/

public class 蓄水池算法_003_382_链表随机节点 {


    class Solution {

        private ListNode head;
        private Random random;

        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {

            int i = 1, ans = 0;

            for (ListNode curr = head; curr != null; curr = curr.next) {

                if (random.nextInt(i) == 0) ans = curr.val;

                ++i;

            }

            return ans;

        }
    }

}
