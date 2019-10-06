package com.company;

public class InverseList {
    public static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void print() {
            Node current = this;
            while (current != null) {
                System.out.print(current.getValue());
                current = current.getNext();
            }
            System.out.println();
        }
    }

    //should reverse list
    public static Node reverseList(Node list) {
        Node current = list.getNext();
        list.setNext(null);
        Node tmp;
        while (current != null) {
            tmp = current;
            current = current.getNext();
            tmp.setNext(list);
            list = tmp;
        }
        return list;
    }

    public static void main(String[] args) {
        Node list = new Node(1, null);
        list = new Node(2, list);
        list = new Node(3, list);
        list = new Node(4, list);
        list = new Node(5, list);
        list.print();
        list = reverseList(list);
        list.print();
    }

}

