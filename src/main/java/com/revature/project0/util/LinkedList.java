package com.revature.project0.util;

public class LinkedList<T> implements List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public boolean add(T data) {

        if (data == null){
            return false;
        }

        Node<T> newNode = new Node<>(data);
        if (head == null){
            tail = head = newNode;
        } else{
            tail = tail.nextNode = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(T data) {
        Node<T> runner = head;
        while (runner != null){
            if (runner.data.equals(data)){
                return true;
            }else{
                runner = runner.nextNode;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(T element) {
        Node<T> prevNode = null;
        Node<T> currentNode = head;
        /*
        while (currentNode != null){
            //case: element for removal found
            if (currentNode.data.equals(element)){
                //case: head is subject to removal
                if (prevNode == null && currentNode.nextNode == null){
                    //case: head is to be removed, and it is the only element
                    head = tail = null;
                } else{
                    //case: head is to be removed and there is another node
                    head = currentNode.nextNode;
                }

                //case, it is somewhere in the middle
                if (prevNode != null && currentNode.nextNode != null){
                    prevNode.nextNode = currentNode.nextNode;
                }
                //case: tail is to be removed
                if(currentNode.nextNode == null && prevNode != null){
                    tail = prevNode;
                    prevNode.nextNode = null;
                }
                //static operations to be performed when the object to remove has been found
                size--;
                break;
            }
            //case: current element is not what we are looking for
            else{
                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }
        }
        return false;*/

        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (currentNode.data == element) {
                if (currentNode == head) {
                    head = currentNode.nextNode;
                } else {
                    prevNode.nextNode = currentNode.nextNode;
                }
                size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0){
            throw new RuntimeException("Provided index value is out of bounds");
        }
        Node<T> currentNode = head;
        for(int i = 0;i <= index; i++){
            if(i == index){
                return currentNode.data;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    private static class Node<T>{
        T data;
        Node<T> nextNode;

        public Node(T data){
            this.data = data;
        }
    }
}
