package com.dongboy.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/5/13 22:43
 */
public class One {
    public int[] circularGameLosers(int n, int k) {
        int[] nums = new int[n + 1];
        int index = 1;
        nums[index] = 1;
        int loop = 1;
        for (; ; ) {
            index = (index + k * loop);
            if (index % n == 0) {
                index = n;
            } else {
                index = index % n;
            }
            nums[index]++;
            if (nums[index] > 1) {
                break;
            }
            loop++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
