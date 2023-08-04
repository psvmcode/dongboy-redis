package com.dongboy.test;

/**
 * @Author dongboy
 * @what time    2023/5/13 22:43
 */
public class Two {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            nums[i + 1] = derived[i] ^ nums[i];
        }
        if ((nums[n - 1] ^ nums[0]) == derived[n - 1]) {
            return true;
        }
        int[] arr = new int[n];
        arr[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i + 1] = derived[i] ^ arr[i];
        }
        if ((arr[n - 1] ^ arr[0]) == derived[n - 1]) {
            return true;
        }
        return false;
    }
}
