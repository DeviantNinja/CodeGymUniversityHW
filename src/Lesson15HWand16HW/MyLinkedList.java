package Lesson15HWand16HW;

public class MyLinkedList<T> {
    private int size;
    private Node<T> head;

    public MyLinkedList(){
        size = 0;
        head = null;
    }

    public MyLinkedList(T data){
        head = new Node<>(data);
        size = 1;
    }

    public void add(T data){
       if(size == 0) {
           head = new Node<>(data);
       } else {
           Node<T> node = getLastNode();
           node.next = new Node<>(data);
       }
       size++;
    }

    public void add(T data, int index){
        if(index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index Out of Bounds");
        Node<T> tempNode = get(index);

        if(index == 0){
            head = new Node<>(data);
            head.next = tempNode;
        } else {
            get(index-1).next = new Node<>(data, tempNode);
        }

        size++;
    }

    private Node<T> getLastNode() {
        Node<T> node = head;
        while(node.next != null){
            node = node.next;
        }
        return node;
    }

    public Node<T> get(int index){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException(index + "is out of bounds Max size: "+size);
        if(index == 0) return head;

        Node<T> node = head.next;
        int count = 1;
        while (count < index) {
            node = node.next;
            count++;
        }
        return node;
    }

    public int size(){
        return size;
    }

    public Node<T> getNthFromLast(int nthValue) {
        if(nthValue <= 0) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        int sizeCount = 0;
        int count = 0;

        while (node.next != null) {
            sizeCount++;
            node = node.next;
        }

        node = head;
        while (count <= sizeCount - nthValue ){
            node = node.next;
            count++;
        }

        return node;
    }

    public Node<T> getNthFromLastOnePass(int nthValue) {
        if(nthValue <= 0) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        Node<T> nthNode = head;
        int count = 0;

        while(node.next != null) {
            node = node.next;

            if(count >= nthValue - 1) {
                nthNode = nthNode.next;
            }
            count++;
        }

        return nthNode;
    }


    public void output(){
        var node = head;
        while(node.next != null) {
            System.out.println(node.data + " " + node.next);
            node = node.next;
        }
        System.out.println(node.data + " " + node.next);
    }
}
