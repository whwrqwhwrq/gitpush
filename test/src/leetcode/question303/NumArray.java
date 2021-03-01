package leetcode.question303;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2021/3/1 11:04
 */
public class NumArray {
    private List list;

    public NumArray(int[] nums) {
        list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            this.list.add(nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0) {
            i = 0;
        }
        if (j > list.size() - 1) {
            j = list.size() - 1;
        }

        int sum = 0;
        for (int temp = i; temp < j + 1; temp++) {
            sum += (int) list.get(temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        NumArray numArray = new NumArray(nums);
        int i = numArray.sumRange(0, 3);
        System.out.println(i);
    }
}
