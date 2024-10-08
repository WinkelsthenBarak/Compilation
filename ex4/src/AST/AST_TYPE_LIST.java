package AST;

public class AST_TYPE_LIST extends AST_Node {

    public AST_TYPE_NAME head;
    public AST_TYPE_LIST tail;

    public AST_TYPE_LIST(AST_TYPE_NAME head, AST_TYPE_LIST tail) {
        SerialNumber = AST_Node_Serial_Number.getFresh();
        this.head = head;
        this.tail = tail;
    }

    public void PrintMe() {
        System.out.print("AST TYPE LIST\n");
        if (head != null) head.PrintMe();
        if (tail != null) tail.PrintMe();
        AST_GRAPHVIZ.getInstance().logNode(SerialNumber, "TYPE LIST\n");
        if (head != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, head.SerialNumber);
        if (tail != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, tail.SerialNumber);
    }
}
