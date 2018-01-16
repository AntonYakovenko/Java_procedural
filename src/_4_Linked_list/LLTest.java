package _4_Linked_list;

public class LLTest {
    public static void main(String[] args) {
        Node tailA = LLUtils.genIter(1, 2, 3, 4, 5);
        System.out.println(LLUtils.toStringIter(tailA));
        Node tailB = LLUtils.genRec(1, 2, 3, 4, 5);
        System.out.println(LLUtils.toStringRec(tailB));
        System.out.println(LLUtils.isEqual(tailA, tailB));
        Node tailC = LLUtils.addLastRec(tailB, 6);
        System.out.println(LLUtils.toStringRec(tailC));
        Node tailD = LLUtils.insertInPositionRec(tailB, 5, 0);
        System.out.println(LLUtils.toStringRec(tailD));
        LLUtils.removeFromPositionRec(tailD, 5);
        System.out.println(LLUtils.toStringRec(tailD));
        System.out.println(LLUtils.isGrowing(tailB));

    }
}
