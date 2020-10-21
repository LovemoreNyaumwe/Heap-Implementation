import java.util.ArrayList;

public class MyHeap<V extends Comparable<V>> implements CS211PriorityQueueInterface<V> {
    boolean queueType;
    ArrayList<V> theHeap = new ArrayList<>();


    public MyHeap(boolean which) {
        this.queueType = which;//true for minheap and false for maxheap
        this.theHeap.add(null);
    }


    @Override
    public void insert(V w) {
        theHeap.add(w);//Insert the element in the next slot of the array.
        bubbleUp(theHeap.size() - 1);//Then bubble up – for a minheap, switch
        // the element with its parent as long as it is smaller than its parent.
        //For a maxheap, switch the element with its parent as long as it is larger
        // than its parent.

    }

    @Override
    public V peek() {
        if (isEmpty()) {
            return null;
        } else {
            return theHeap.get(1);
        }
    }

    @Override
    public V remove() {
        if (isEmpty()) {
            return null;
        } else if (theHeap.size() == 2) {
            return theHeap.remove(1);
        } else {
            V top = theHeap.get(1);//first element in the heap.
            theHeap.set(1, theHeap.remove(theHeap.size() - 1));//Replace the first element with the last element.
            //update the size of the heap.
            bubbleDown(1);// Then bubble down – switch the element with the
            // smaller of its children as long as it is larger than one of its children
            return top;//return the first element in the array.


        }
    }

    @Override
    public void build(ArrayList<V> words) {
        for (V word : words) {
            insert(word);


       }
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        if (theHeap.size() == 1) {
            isEmpty = true;//returns true if and only nothing is stored in the array.
        }
        return isEmpty;
    }

    @Override
    public void writePQ() {
        for (V v : theHeap) {
            System.out.print(" " + v);
        }

    }

    public int parent(int i) {
        return (i) / 2;
    }

    public int leftChild(int i) {
        return (2 * i);
    }

    public int rightChild(int i) {
        return (2 * i) + 1;
    }


    public void bubbleDown(int index) {
        int maxChild;
        int minChild;
        if (queueType && (rightChild(index) <= theHeap.size())) {
            minChild = leftChild(index);
            if(rightChild(index) < theHeap.size()) {
                if (theHeap.get(leftChild(index)).compareTo(theHeap.get(rightChild(index))) > 0) {
                    minChild = rightChild(index);
                }
            }
            if (theHeap.get(minChild).compareTo(theHeap.get(index)) < 0) {
                swap(minChild, index);
                bubbleDown(minChild);
            }
        } else if (!queueType && (rightChild(index) <=theHeap.size())) {
            maxChild = leftChild(index);
            if(rightChild(index) < theHeap.size()) {
                if (theHeap.get(leftChild(index)).compareTo(theHeap.get(rightChild(index))) < 0) {
                    maxChild = rightChild(index);
                }
            }
            if (theHeap.get(maxChild).compareTo(theHeap.get(index)) > 0) {
                swap(maxChild, index);
                bubbleDown(maxChild);
            }
        }
    }

    public void swap(int parent, int Child) {
        V temp = theHeap.get(Child);
        theHeap.set(Child, theHeap.get(parent));
        theHeap.set(parent, temp);
    }


    public void bubbleUp(int Child) {
        if (parent(Child) > 0) {
            if (queueType) {
                if (theHeap.get(Child).compareTo(theHeap.get(parent(Child))) < 0) {
                    V temp = theHeap.get(Child);
                    theHeap.set(Child, theHeap.get(parent(Child)));
                    theHeap.set(parent(Child), temp);
                    bubbleUp(parent(Child));
                }
            } else {
                if (theHeap.get(Child).compareTo(theHeap.get(parent(Child))) > 0) {
                    V temp = theHeap.get(Child);
                    theHeap.set(Child, theHeap.get(parent(Child)));
                    theHeap.set(parent(Child), temp);
                    bubbleUp(parent(Child));
                }

            }
       }
    }
}

