package org.ayahiro.practice.sword_to_offer.知识迁移能力;

public class 数字在排序数组中出现的次数 {

        public static int GetNumberOfK(int[] array, int k) {
            if (array == null || array.length == 0) return 0;
            //先用二分找到一个k在array中位置
            int position = BSearch(array, k);
            System.out.println(position);
            if (position != -1) {
                //找到第一个k之后，用双指针向两边扩展（因为有序，所以时间复杂度为O(n)，与二分O(nlogn)相加还是O(nlogn)）
                int i, j;
                i = j = position;
                while (i >= 0 && array[i] == k) i--;
                while (j < array.length && array[j] == k) j++;
                //最终结果
                System.out.println("i="+i+",j="+j);
                return j - i - 1;
            }
            //没找到
            return 0;
        }

        private static int BSearch(int[] array, int k) {
            int low = 0, high = array.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;
                if (array[mid] < k) {
                    low = mid + 1;
                } else if (array[mid] > k) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        int[] a={1,1,2,2,2,3,3,4,4};
        GetNumberOfK(a, 2);
    }
}
