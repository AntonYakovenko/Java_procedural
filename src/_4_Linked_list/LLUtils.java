package _4_Linked_list;

import java.util.Arrays;

public class LLUtils {
    public static Node genIter(int... values) {
        Node tail = null;
        for (int k = values.length - 1; k >= 0; k--) {
            tail = new Node(values[k], tail);
        }
        return tail;
    }

    public static Node genRec(int... values) {
        if (values.length == 0)
            return null;
        else {
            int[] newArray = Arrays.copyOfRange(values, 1, values.length);
            return new Node(values[0], genRec(newArray));
        }
    }

    public static String toStringIter(Node tail) {
        String result = "";
        while (tail != null) {
            result += tail.value + " -> ";
            tail = tail.next;
        }
        return result + "null";
    }

    public static String toStringRec(Node tail) {
        if (tail == null)
            return "null";
        else {
            return tail.value + " -> " + toStringRec(tail.next);
        }
    }

    public static boolean isEqual(Node t0, Node t1) {
        if (t0 != null && t1 != null) {
            return (t0.value == t1.value) && isEqual(t0.next, t1.next);
        } else {
            return t0 == t1;
        }
    }

    public static Node addLastIter(Node tail, int value) {
        Node current = tail;
        if (current == null) {
            return new Node(value, null);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value, null);
        }
        return tail;
    }

    private static Node findLastPos(Node tail) {
        if (tail == null) {
            return null;
        } else if (tail.next == null) {
            return tail;
        } else {
            return findLastPos(tail.next);
        }
    }

    private static Node findIndexPos(Node tail, int index) {
        if (index == 1) {
            return tail;
        } else {
            return findIndexPos(tail.next, --index);
        }
    }

    private static Node findPosBeforeIndex(Node tail, int index) {
        if (index == 2) {
            return tail;
        } else {
            return findIndexPos(tail.next, --index);
        }
    }

    public static Node addLastRec(Node tail, int value) {
        Node lastPosElement = findLastPos(tail);
        lastPosElement.next = new Node(value, null);
        return tail;
    }

    public static Node insertInPositionRec(Node tail, int index, int value) {
        if (tail == null) {
            return null;
        } else if (index == 0) {
            tail = new Node(value, tail);
        } else {
            Node indexPosElement = findIndexPos(tail, index);
            indexPosElement.next = new Node(value, indexPosElement.next);
        }
        return tail;
    }

    public static Node insertInPositionIter(Node tail, int index, int value) {
        Node current = tail;
        if (index == 0) {
            tail = new Node(value, tail);
        } else if (current == null) {
            return new Node(value, null);
        } else {
            for (int i = 1; i < index; i++) {
                current = current.next;
                if (current.next == null) {
                    throw new IllegalArgumentException("Illegal index");
                }
            }
            current.next = new Node(value, current.next.next);
        }
        return tail;
    }

    public static Node removeLastIter(Node tail) {
        Node current = tail;
        if (current == null) {
            return null;
        } else if (current.next == null) {
            return null;
        } else {
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        return tail;
    }

    private static Node findPosBeforeLast(Node tail) {
        if (tail == null) {
            return null;
        } else if (tail.next.next == null) {
            return tail;
        } else {
            return findPosBeforeLast(tail.next);
        }
    }

    public static Node removeLastRec(Node tail) {
        Node beforeLastPosElement = findPosBeforeLast(tail);
        beforeLastPosElement.next = null;
        return tail;
    }

    public static Node removeFromPositionRec(Node tail, int index) {
        if (tail == null) {
            return null;
        } else if (index == 0) { //W
            tail = tail.next;    //T
            return tail;         //F
        } else if (index == 1) {
            Node current = tail;
            current.next = current.next.next;
            return tail;
        } else {
            Node indexPosElement = findPosBeforeIndex(tail, index);
            indexPosElement.next = indexPosElement.next.next;
            return tail;
        }
    }

    /*public static boolean isGrowing(Node tail) {
        return tail.next == null || tail.value < tail.next.value && isGrowing(tail.next);
    }*/

    public static boolean isGrowing(Node tail) {
        if (tail.next == null) {
            return true;
        } else if (tail.value >= tail.next.value) {
            return false;
        } else {
            return isGrowing(tail.next);
        }
    }
    
}
