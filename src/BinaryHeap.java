import java.util.ArrayList;

/**
 * Created by smurphy on 2/10/15.
 */
public class BinaryHeap<E> {
    ArrayList<E> arr;//Maybe should be a different data type?

    public void addObject(BinaryHeapNode<E> rt, E o) {//UNFINISHED - add object o to the heap rt
        if (isLeft()) {
            addObject(rt.getLeft(), o);
        }
        else {
            addObject(rt.getRight(), o);
        }
    }

    public boolean isLeft() {
        return (2^(numRows()+1))-(arr.size()-(2^numRows()))>(2^(numRows()+1))/2;
    }

    public int numRows() {
        int num = 0;
        int tempArrSize = arr.size();
        while (tempArrSize>(2^num)) {
            tempArrSize -= 2^num;
            num++;
        }
        return num;
    }
}
