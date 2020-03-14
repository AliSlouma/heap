package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class Sort <T extends Comparable<T>> implements ISort {

    public IHeap heapSort(ArrayList unordered) {
        IHeap sorted = new Heap();
        sorted.build(unordered);

        for (int i=sorted.size()-1; i>=0; i--)
        {   unordered.remove(sorted.getRoot().getValue());
            unordered.add(0, (T) sorted.extract());
        }
        return sorted;
    }

    public void sortSlow(ArrayList unordered) {
        if(unordered !=null){
             int size = unordered.size();
             for (int i=0;i<size-1;i++){
                 for (int j=0;j<size-i-1;j++) {
                     T first = (T) unordered.get(size-j-1);
                     T second = (T) unordered.get(size-j-2);
                    if(first.compareTo(second) <0){
                     T temp = (T) unordered.get(size-j-1);
                       unordered.set(size-j-1,unordered.get(size-j-2));
                      unordered.set(size-j-2 , temp);
                    }
                 }
             }
             int g=2;
        }
    }
    void merge( ArrayList<T> arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        ArrayList<T> left = new ArrayList<>();
        ArrayList<T> right = new ArrayList<>();

        for (int i=0; i<n1; ++i)
            left.add(arr.get(l+i));
        for (int j=0; j<n2; ++j)
            right.add(arr.get(m+1+j));

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if ( left.get(i).compareTo(right.get(j))<=0)
            {
                arr.set(k,left.get(i++));
            }
            else
            {
                arr.set(k,right.get(j++));
            }
            k++;
        }
        while (i < n1)
        {
            arr.set(k,left.get(i++));
            k++;
        }
        while (j < n2)
        {
            arr.set(k,right.get(j++));
            k++;
        }
    }

    void sort(ArrayList arr, int l, int r) {
        if (l < r)
        {
            int m = (l+r)/2;

            sort(arr, l, m);
            sort(arr , m+1, r);

            merge(arr, l, m, r);
        }
    }

    public void sortFast(ArrayList  unordered) {
        if(unordered != null)
         sort(unordered,0,unordered.size()-1);
    }

    public static void main (String[] args) {

        Sort<Integer> s = new Sort<>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(4);
        arr.add(535555);
        arr.add(5353);
        arr.add(53555);
        //  s.sortSlow(arr);

       //s.sortFast(arr);
          s.heapSort(arr);

int f=5;
    }


}
