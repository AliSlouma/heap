package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class Sort <T extends Comparable<T>> implements ISort {


    @Override
    public IHeap heapSort(ArrayList unordered) {
        IHeap sorted = new Heap();
        sorted.build(unordered);

        for (int i=sorted.size()-1; i>=0; i--)
        {
            sorted.extract();
            sorted.heapify(sorted.getRoot());
        }

        return sorted;
    }

    public void sortSlow(ArrayList unordered) {
        int size = unordered.size();
        for (int i=0;i<size;i++){
            for (int j=0;j<size-i-1;j++) {
                T first = (T) unordered.get(size-j-i-1);
                T second = (T) unordered.get(size-j-i -2);

                if(first.compareTo(second) <0){
                    T temp = (T) unordered.get(size-j-i-1);
                    unordered.set(size-j-i-1,unordered.get(size-j-i-2));
                    unordered.set(size-j-i-2 , temp);
                }
            }
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
                arr.remove(k);
                arr.add(k,left.get(i++));
            }
            else
            {
                arr.remove(k);
                arr.add(k,right.get(j++));
            }
            k++;
        }
        while (i < n1)
        {
            arr.remove(k);
            arr.add(k++,left.get(i++));
        }
        while (j < n2)
        {
            arr.remove(k);
            arr.add(k++,right.get(j++));
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
        sort(unordered,0,unordered.size()-1);
    }

   /* public static void main (String[] args){

        Sort <Integer> s = new Sort<>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(4);
        arr.add(3);
        arr.add(5);
        arr.add(1);
       // s.sortSlow(arr);

//        s.sortFast(arr);
        s.heapSort(arr);

        int d = 2;
    }*/


}
