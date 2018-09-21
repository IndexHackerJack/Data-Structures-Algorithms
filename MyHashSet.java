/**
 * Created by jackli on 2018-09-12.
 */
public class MyHashSet
{
    private static final int SET_CAPACITY = 1000001;
    private ChainLinkedList[] setArray;

    public static void main(String[] args)
    {
        System.out.println("***HashSet***");
        MyHashSet hs = new MyHashSet();
        hs.add(5);
        hs.add(5);
        System.out.println(hs.contains(5));
        hs.add(10);
        System.out.println(hs.contains(10));
        System.out.println(hs.contains(9));
        hs.remove(5);
        System.out.println(hs.contains(5));

//        hs.add(1000);
//        hs.add(1000);
//        hs.add(1000);
//        hs.add(1000);
//        hs.add(1000);
//        hs.add(10000);
//        hs.add(100000);
//        hs.add(1000000);
//        System.out.println(hs.contains(1000));
//        System.out.println(hs.contains(10000));
//        System.out.println(hs.contains(100000));
//        System.out.println(hs.contains(1000000));
//
//        hs.remove(1000);
//        System.out.println(hs.contains(1000));
//        System.out.println(hs.contains(10000));
//        System.out.println(hs.contains(100000));
//        System.out.println(hs.contains(1000000));
//        hs.remove(1000);
//        hs.remove(10000);
//        hs.remove(100000);
//        hs.remove(1000000);
//        System.out.println(hs.contains(1000));
//        System.out.println(hs.contains(10000));
//        System.out.println(hs.contains(100000));
//        System.out.println(hs.contains(1000000));
    }
    
    public MyHashSet()
    {
        setArray = new ChainLinkedList[SET_CAPACITY];
    }

    private static int getBucket(int key)
    {
        return Math.abs(key % SET_CAPACITY);
    }

    public void add(int key)
    {
        int bucket = getBucket(key);

        if (setArray[bucket] == null)
        {
            ChainLinkedList linkedListToAddNode = new ChainLinkedList(key);
            setArray[bucket] = linkedListToAddNode;
        }
        else
        {
            ChainLinkedList linkedListToInsert = setArray[bucket];
            linkedListToInsert.insertTailIfNotPresent(key);
        }
    }

    public void remove(int key)
    {
        int bucket = getBucket(key);

        if (setArray[bucket] != null)
        {
            ChainLinkedList linkedListToRemoveNode = setArray[bucket];
            linkedListToRemoveNode.deleteNode(key);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key)
    {
        int bucket = getBucket(key);
        ChainLinkedList linkedListAtBucket = setArray[bucket];

        if (linkedListAtBucket != null)
        {
            return linkedListAtBucket.hasValue(key);
        }

        return false;
    }
}

class ChainLinkedList
{
    Node head;

    public ChainLinkedList(Node head)
    {
        this.head = head;
    }

    public ChainLinkedList(int headValue)
    {
        this.head = new Node(headValue);
    }

    /**
     * @param deleteVal
     * @return true if node deleted, false otherwise (doesn't exist in linked list)
     */
    public boolean deleteNode(int deleteVal)
    {
        if (head == null)
        {
            return false;
        }

        Node previous = null;
        Node current = head;
        while (current != null)
        {
            if (current.value == deleteVal)
            {
                if (current == head)
                {
                    head = current.next;
                }
                else
                {
                    previous.next = current.next;
                }

                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public boolean hasValue(int targetVal)
    {
        Node current = head;

        while (current != null)
        {
            if (current.value == targetVal)
            {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * Insert new node representing input value to tail if there is no other existing
     * node with that value
     *
     * @param insertVal value to insert
     * @return true if inserted, false if linked list already contains another node
     * with the same value as insertVal
     */
    public boolean insertTailIfNotPresent(int insertVal)
    {
        if (head == null)
        {
            head = new Node(insertVal);
            return true;
        }

        Node previous = null;
        Node current = head;

        do
        {
            if (current.value == insertVal)
            {
                return false;
            }

            previous = current;
            current = current.next;
        } while (current != null);

        previous.next = new Node(insertVal);

        return true;
    }
}

class Node
{
    int value;
    Node next;

    public Node(int value)
    {
        this.value = value;
    }
}