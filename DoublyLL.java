import java.util.*;

public class DoublyLL {
    class node {
        int data;
        node next;
        node prev;

        node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    node First = null;

    // method to addFirst in the list
    void addFirst(int data) {
        node newNode = new node(data);
        if (First == null) {
            First = newNode;
        } else {
            newNode.next = First;
            First.prev = newNode;
            First = newNode;
        }
    }

    // method to addLast in the list
    void addLast(int data) {
        node newNode = new node(data);
        if (First == null) {
            First = newNode;
        } else {
            node temp = First;
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.prev = temp;
            temp.next = newNode;
        }
    }

    // method to deleteFirst in the list
    void deleteFirst() {
        if (First == null) {
            System.out.println("List is Empty!");
        } else if (First.next == null) {
            System.out.println("Deleted Node data: " + First.data);
            First = null;
        } else {
            System.out.println("Deleted Node data: " + First.data);
            First = First.next;
            First.prev = null;
        }
    }

    // method to deleteLast in the list
    void deleteLast() {
        if (First == null) {
            System.out.println("List is Empty!");
        } else if (First.next == null) {
            System.out.println("Deleted Node data: " + First.data);
            First = null;
        } else {
            node temp = First;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            System.out.println("Deleted Node data: " + temp.next.data);
            temp.next.prev = null;
            temp.next = null;
        }
    }

    // method to display the list
    void display() {
        if (First == null) {
            System.out.println("List is Empty!");
        } else {
            node temp = First;
            System.out.print("Null <-- ");
            while (temp.next != null) {
                System.out.print(temp.data + " <--> ");
                temp = temp.next;
            }
            System.out.println(temp.data + " --> Null");
        }
    }

    // method to display the list in reverse order
    void displayReverse() {
        if (First == null) {
            System.out.println("List is Empty!");
        } else {
            node temp = First;
            while (temp.next != null) {
                temp = temp.next;
            }
            System.out.print("Null <-- ");
            while (temp.prev != null) {
                System.out.print(temp.data + " <--> ");
                temp = temp.prev;
            }
            System.out.println(temp.data + " --> Null");
        }
    }

    // method to add after a given node
    void addAfter(int data, int after) {
        node newNode = new node(data);
        if (First == null) {
            System.out.println("List is Empty!");
        } else {
            node temp = First;
            while (temp != null && temp.data != after) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Given Node is not present in the list!");
            } else if (temp.next == null) {
                newNode.prev = temp;
                temp.next = newNode;
                newNode.next = null;

            } else {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
            }
        }
    }

    // method to add before a given node
    void addBefore(int data, int before) {
        node newNode = new node(data);
        if (First == null) {
            System.out.println("List is Empty!");
        } else {
            node temp = First;
            while (temp != null && temp.data != before) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Given Node is not present in the list!");
            } else if (temp.prev == null) {
                newNode.next = temp;
                temp.prev = newNode;
                newNode.prev = null;
                First = newNode;

            } else {
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;
            }
        }
    }

    // method to delete a given node
    void deleteNode(int data) {
        if (First == null) {
            System.out.println("List is Empty!");
        } else {
            node temp = First;
            while (temp != null && temp.data != data) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Given Node is not present in the list!");
            } else if (temp.next == null) {
                System.out.println("Deleted Node data: " + temp.data);
                if (temp.prev != null) {
                    temp.prev.next = null;
                } else {
                    First = null;
                }
            } else if (temp.prev == null) {
                System.out.println("Deleted Node data: " + temp.data);
                temp.next.prev = null;
                First = temp.next;
            } else {
                System.out.println("Deleted Node data: " + temp.data);
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }

}

// --#--#--#---#---#--#---#----#---#-- MAIN METHOD
// --#--#--#---#---#--#---#----#---#--

class LinkedList {
    public static void main(String[] args) {

        DoublyLL list = new DoublyLL();
        System.out.println("Enter 1 to addFirst");
        System.out.println("Enter 2 to addLast");
        System.out.println("Enter 3 to deleteFirst");
        System.out.println("Enter 4 to deleteLast");
        System.out.println("Enter 5 to display");
        System.out.println("Enter 6 to displayReverse");
        System.out.println("Enter 7 to addAfter");
        System.out.println("Enter 8 to addBefore");
        System.out.println("Enter 9 to deleteNode");
        System.out.println("Enter 10 to exit");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 10) {
            System.out.println(" ");
            System.out.println("Enter your choice: ");
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
                    list.display();
                    break;

                case 6:
                    list.displayReverse();
                    break;

                case 7:
                    System.out.println("Enter data: ");
                    int dataafter = input.nextInt();
                    System.out.println("Enter after which node: ");
                    int after = input.nextInt();
                    list.addAfter(dataafter, after);
                    break;

                case 8:
                    System.out.println("Enter data: ");
                    int databefore = input.nextInt();
                    System.out.println("Enter before which node: ");
                    int before = input.nextInt();
                    list.addBefore(databefore, before);
                    break;

                case 9:
                    System.out.println("Enter data: ");
                    int datadelete = input.nextInt();
                    list.deleteNode(datadelete);
                    break;

                case 10:
                    System.out.println("Exiting............");
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }
}