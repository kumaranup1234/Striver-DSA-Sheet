package Array;

import java.util.ArrayList;
import java.util.List;

public class merge2SortedArray {
    public static List< Integer > sortedArray(int []a, int []b) {
        List<Integer> merged = new ArrayList<>();
        int i = 0;
        int j = 0;
        int lastAdded = Integer.MIN_VALUE;

        while(i < a.length && j < b.length){
            if (a[i] <= b[j]){
                if (a[i] != lastAdded){
                    merged.add(a[i]);
                    lastAdded = a[i];
                }
                i++;
            }else if (a[i] >= b[j]){
                if (b[j] != lastAdded){
                    merged.add(b[j]);
                    lastAdded = b[j];
                }
                j++;
            }
        }

        while (i < a.length){
            if (a[i] != lastAdded){
                merged.add(a[i]);
                lastAdded = a[i];
            }
            i++;
        }

        while (j < b.length){
            if (b[j] != lastAdded){
                merged.add(b[j]);
                lastAdded = b[j];
            }
            j++;
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 4, 5, 6, 7, 8, 9, 9, 9};
        int[] b = {2, 4, 10, 10};
        System.out.println(sortedArray(a, b));
    }
}
