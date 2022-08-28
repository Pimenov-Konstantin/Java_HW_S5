import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Two {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;

        }
        HashMap<Integer, Integer> smollArr = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            smollArr.putIfAbsent(nums1[i], 0);
            smollArr.put(nums1[i], smollArr.get(nums1[i]) + 1);
        }
        List<Integer> currRes = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (smollArr.get(nums2[i]) != null) {
                currRes.add(nums2[i]);
                smollArr.put(nums2[i], smollArr.get(nums2[i]) - 1);
                if (smollArr.get(nums2[i]) == 0) {
                    smollArr.remove(nums2[i]);
                }
            }

        }
        int[] result = new int[currRes.size()];
        for (int i = 0; i < currRes.size(); i++) {
            result[i] = currRes.get(i);
        }
        return result;
    }
}