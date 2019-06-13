package TADS.QuickSort;

import java.util.ArrayList;

public class QuickSort {
    public static void sort(ArrayList objects)
    {
        quickSort(objects, 0, objects.size() -1);
    }

    public static void quickSort(ArrayList elements, int from, int to)
    {
        if (from < to)
        {
            int p = partition(elements, from, to);
            quickSort(elements, from, p);
            quickSort(elements, p+1, to);
        }
    }

    public static int partition(ArrayList elements, int from, int to)
    {
        Comparable pivot = (Comparable)elements.get(from);
        int i = from -1;
        int j = to +1;

        while (i < j)
        {
            i++; while (((Comparable)(elements.get(i))).compareTo(pivot) < 0) i++;
            j--; while (((Comparable)(elements.get(i))).compareTo(pivot) > 0) j--;
            if (i < j)
            {
                Comparable temp = (Comparable)elements.get(i);
                elements.set(i, (Comparable)elements.get(j));
                elements.set(j, temp);
            }
        }
        return j;
    }}