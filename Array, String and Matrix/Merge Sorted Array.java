/**
*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
*Note:
*You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
*The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

//solution 1
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            } else {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        while (n > 0) {
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }
}

//solution 2
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
	 
		while (k >= 0) {
			if (j < 0 || (i >= 0 && A[i] > B[j]))
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
	}
}

