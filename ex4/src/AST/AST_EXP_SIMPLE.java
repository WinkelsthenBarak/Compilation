package AST;

import IR.*;
import TEMP.*;
import TYPES.*;
import SYMBOL_TABLE.*;

public class AST_EXP_SIMPLE extends AST_EXP {
    public AST_EXP exp;

    public AST_EXP_SIMPLE(AST_EXP exp) {
        SerialNumber = AST_Node_Serial_Number.getFresh();
        System.out.print("exp -> (exp)\n");
        this.exp = exp;
    }


    public void PrintMe() {
        System.out.print("AST EXP SIMPLE NODE\n");
        if (exp != null) exp.PrintMe();
        AST_GRAPHVIZ.getInstance().logNode(SerialNumber, "EXP SIMPLE");
        AST_GRAPHVIZ.getInstance().logEdge(SerialNumber, exp.SerialNumber);
    }

    public TYPE SemantMe() {
        System.out.println("EXP SIMPLE - SemantMe");
        return exp.SemantMe();
    }

    public TEMP IRme() {
        System.out.println("EXP SIMPLE - IRme");
        return exp.IRme();
    }
}
