public class Testing {public static void main(String[] arg)
{

    MyHeap<Integer> maxHeap = new MyHeap<Integer>(true);
    maxHeap.insert(1);
    maxHeap.writePQ();
    System.out.println("------");
    maxHeap.insert(4);
    maxHeap.writePQ();
    System.out.println("------");
    maxHeap.insert(2);
    maxHeap.writePQ();
    System.out.println("------");
    maxHeap.insert(5);
    maxHeap.writePQ();
    System.out.println("------");
    maxHeap.insert(13);
    maxHeap.writePQ();
    System.out.println("------");
    maxHeap.insert(6);
    maxHeap.writePQ();
    System.out.println("------");
    //maxHeap.insert(1);

    //maxHeap.bubbleDown(1);

    maxHeap.writePQ();
    System.out.println(" ");
    System.out.println("The min is " + maxHeap.peek());
}
}
