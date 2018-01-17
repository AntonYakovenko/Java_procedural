package _4_Linked_list;

import java.util.Arrays;

public class ListLoop {
    public static void main(String[] args) {
        Node list = genRec(0, 1, 2, 3, 4, 5, 6, 7);
        System.out.println(toStringIter(list));
        System.out.println(checkLoop(list));
        Node loopList = setLoop(list);
        System.out.println(checkLoop(loopList));
        //System.out.println(toStringIter(loopList));
    }

    public static Node genRec(int... values) {
        if (values.length == 0)
            return null;
        else {
            int[] newArray = Arrays.copyOfRange(values, 1, values.length);
            return new Node(values[0], genRec(newArray));
        }
    }

    public static Node setLoop(Node tail) {
        if (tail == null) {
            return null;
        }
        Node curr = tail;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tail;
        return tail;
    }

    public static String toStringIter(Node tail) {
        String result = "";
        while (tail != null) {
            result += tail.value + " -> ";
            tail = tail.next;
        }
        return result + "null";
    }

    public static boolean checkLoop(Node tail) {
        if (tail == null) {
            return false;
        }
        Node fast = tail.next;
        Node slow = tail;
        while (true) {
            if (fast == slow) {
                return true;
            }
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
        }
    }
}
