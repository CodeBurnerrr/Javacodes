import java.util.*;

class CircularLL {
    Node First = null;

    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    // to addFirst in the list
    void addFirst(int data) {
        Node newNode = new Node(data);
        if (First == null) {
            First = newNode;
            newNode.link = newNode;
        } else {
            newNode.link = First;
            Node temp = First;
            while (temp.link != First) {
                temp = temp.link;
            }
            temp.link = newNode;
            First = newNode;
        }
    }

    // to addLast in the list
    void addLast(int data) {
        Node newNode = new Node(data);
        if (First == null) {
            First = newNode;
            newNode.link = newNode;
        } else {
            Node temp = First;
            while (temp.link != First) {
                temp = temp.link;
            }
            temp.link = newNode;
            newNode.link = First;
        }
    }

    // to deleteFirst in the list
    void deleteFirst() {
        if (First == null) {
            System.out.println("List is Empty!");
        } else if (First.link == First) {
            System.out.println("Deleted Node data: " + First.data);
            First = null;
        } else {
            Node temp = First;
            while (temp.link != First) {
                temp = temp.link;
            }
            temp.link = First.link;
            System.out.println("Deleted Node data: " + First.data);
            First = First.link;
        }
    }

    // to deleteLast from list
    void deleteLast() {
        if (First == null) {
            System.out.println("List is empty:");
        } else if (First.link == First) {
            System.out.println("Deleted Node data: " + First.data);
            First = null;
        } else {
            Node temp = First;
            while (temp.link.link != First) {
                temp = temp.link;
            }
            System.out.println("Deleted Node data: " + temp.link.data);
            temp.link = First;
        }
    }

    // to display the list
    void display() {
        if (First == null) {
            System.out.println("List is Empty!");
        } else {
            Node temp = First;
            while (temp.link != First) {
                System.out.print(temp.data + "-->");
                temp = temp.link;
            }
            System.out.println(temp.data);
        }
    }

    // to addbefore in the list
    void addBefore(int value, int data) {
        Node newNode = new Node(data);
        if (First.data == value) {
            newNode.link = First;
            Node temp = First;
            while (temp.link != First) {
                temp = temp.link;
            }
            temp.link = newNode;
            First = newNode;
        } else {
            Node temp = First;
            while (temp.link != First && temp.link.data != value) {
                temp = temp.link;
            }
            if (temp.link.data == value) {
                newNode.link = temp.link;
                temp.link = newNode;
            } else {
                System.out.println("Value not found!");
            }
        }
    }

    // to deleteValue from list
    void deleteValue(int value) {
        if (First == null) {
            System.out.println("List is Empty!");
        } else if (First.data == value) {
            if (First == First.link) {
                System.out.println(value + " deleted successfully............");
                First = null;
            } else {
                Node temp = First;
                while (temp.link != First) {
                    temp = temp.link;
                }
                temp.link = First.link;
                System.out.println(value + " deleted successfully............");
                First = First.link;
            }
        } else {
            Node temp = First;
            while (temp.link != First && temp.link.data != value) {
                temp = temp.link;
            }
            if (temp.link.data == value) {
                temp.link = temp.link.link;
                System.out.println(value + " deleted successfully............");
            } else {
                System.out.println("Value Not Found!");
            }
        }

    }
}

class linkedlist {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CircularLL list = new CircularLL();
        int choice = 0;
        while (choice != 8) {
            System.out.println(" ");
            System.out.println("Enter 1 to enter node at Front");
            System.out.println("Enter 2 to enter node at Last");
            System.out.println("Enter 3 to delete First node");
            System.out.println("Enter 4 to delete last node");
            System.out.println("Enter 5 to enter node before the given value");
            System.out.println("Enter 6 to delete a particular node");
            System.out.println("Enter 7 to display Circular Linked list");
            System.out.println("Enter 8 to exit");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter data: ");
                    int datafirst = input.nextInt();
                    list.addFirst(datafirst);
                    break;

                case 2:
                    System.out.println("Enter data: ");
                    int datalast = input.nextInt();
                    list.addLast(datalast);
                    break;
                case 3:
                    list.deleteFirst();
                    break;

                case 4:
                    list.deleteLast();
                    break;

                case 5:
                    System.out.println("Enter value before which you want to insert newnode: ");
                    int value = input.nextInt();
                    System.out.println("Enter data of newnode: ");
                    int data = input.nextInt();
                    list.addBefore(value, data);
                    break;

                case 6:
                    System.out.println("Enter value to be deleted");
                    int del = input.nextInt();
                    list.deleteValue(del);
                    break;

                case 7:
                    list.display();
                    break;

                default:
                    break;
            }

        }
    }
}