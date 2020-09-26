package com.practice.array;
/*
Leetcode#33. Search in Rotated Sorted Array
You are given an integer array nums sorted in ascending order, and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1.
*/
public class BinarySearchRotatedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        int pivot = left;
        
        left = 0;
        right = nums.length - 1;
        if(target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        }
        else {
            right = pivot - 1;
        }
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
