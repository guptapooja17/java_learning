package com.programOfJava;

public class CustomLinkedList {

    public static void main(String[] args) {

        EmployeeLinkedList e1 = new EmployeeLinkedList();
        e1.addNode(1, "Aryan");
        e1.addNode(2, "Anupama");
        e1.addNode(3, "Pooja");
        e1.addNode(4, "Poonam");
        e1.addNode(5, "Pradeep");

        e1.displayNode();
    }
}

class EmployeeLinkedList {

    Node head;
    Node temp;

    class Node {

        final int rollNo;
        String nameString;
        Node nextAddress;

        public Node(int rollNo, String nameString) {
            this.rollNo = rollNo;
            this.nameString = nameString;
        }
    }

    public void addNode(int rollNo, String namString) {
        Node emp = new Node(rollNo, namString);
        if (head == null) {
            emp.nextAddress = null;
            head = emp;
            temp = emp;
        }
        else {
            temp.nextAddress = emp;
            temp = emp;
            temp.nextAddress = null;
        }
    }
    
    public void deleteNode(int rollNo) {
    	Node tempNode = head;
        if (tempNode != null && tempNode.rollNo == rollNo) {
        	
        } else {
        		
        }
    }
    

    public void displayNode() {
        if (head == null)
            System.out.println("Employee LinkedList Is empty");
        else {
            Node first = head;
            while (first != null) {
                System.out.println("Employee rollNo.: " + first.rollNo + " Name : " + first.nameString);
                first = first.nextAddress;
            }
        }
    }
}