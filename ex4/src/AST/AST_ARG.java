package AST;

public class AST_ARG extends AST_Node {
    public AST_TYPE type;
    public String id;

    public AST_ARG(AST_TYPE type, String id) {
        SerialNumber = AST_Node_Serial_Number.getFresh();
        this.type = type;
        this.id = id;
    }

    public void PrintMe() {
        System.out.format("AST NODE ARG(%s)\n", id);
        if (type != null) {type.PrintMe();}
        AST_GRAPHVIZ.getInstance().logNode(SerialNumber, String.format("ARG(%s)", id));
        if (type != null) {AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, type.SerialNumber);}
    }
}
