/***********/
/* PACKAGE */
/***********/
package AST;

/*******************/
/* GENERAL IMPORTS */
/*******************/

/*******************/
/* PROJECT IMPORTS */
/*******************/
import TYPES.*;
import TEMP.*;
import IR.*;

public class AST_EXP_BINOP extends AST_EXP
{
	int OP;
	public AST_EXP left;
	public AST_EXP right;
	
	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AST_EXP_BINOP(AST_EXP left,AST_EXP right,int OP)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		SerialNumber = AST_Node_Serial_Number.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== exp -> exp BINOP exp\n");

		/*******************************/
		/* COPY INPUT DATA NENBERS ... */
		/*******************************/
		this.left = left;
		this.right = right;
		this.OP = OP;
	}
	
	/*************************************************/
	/* The printing message for a binop exp AST node */
	/*************************************************/
	public void PrintMe()
	{
		String sOP="";
		
		/*********************************/
		/* CONVERT OP to a printable sOP */
		/*********************************/
		if (OP == 0) {sOP = "+";}
		if (OP == 1) {sOP = "-";}
		if (OP == 2) {sOP = "*";}
		if (OP == 3) {sOP = "/";}
		if (OP == 4) {sOP = "<";}
		if (OP == 5) {sOP = ">";}
		if (OP == 6) {sOP = "=";}

		/*************************************/
		/* AST NODE TYPE = AST SUBSCRIPT VAR */
		/*************************************/
		System.out.print("AST NODE BINOP EXP\n");
		System.out.format("BINOP EXP(%s)\n",sOP);

		/**************************************/
		/* RECURSIVELY PRINT left + right ... */
		/**************************************/
		if (left != null) left.PrintMe();
		if (right != null) right.PrintMe();

		/***************************************/
		/* PRINT Node to AST GRAPHVIZ DOT file */
		/***************************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			String.format("BINOP(%s)",sOP));
		
		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (left  != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,left.SerialNumber);
		if (right != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,right.SerialNumber);
	}
	
	public TYPE SemantMe()
	{
		TYPE t1 = null;
		TYPE t2 = null;
		
		if (left  != null) t1 = left.SemantMe();
		if (right != null) t2 = right.SemantMe();
		
		if ((t1 == TYPE_INT.getInstance()) && (t2 == TYPE_INT.getInstance()))
		{
			return TYPE_INT.getInstance();
		}
		System.exit(0);
		return null;
	}

	public TEMP IRme()
	{
		TEMP t1 = null;
		TEMP t2 = null;
		TEMP dst = TEMP_FACTORY.getInstance().getFreshTEMP();
				
		if (left  != null) t1 = left.IRme();
		if (right != null) t2 = right.IRme();
		
		if (OP == 0)
		{
			IR.
			getInstance().
			Add_IRcommand(new IRcommand_Binop_Add_Integers(dst,t1,t2));
		}
		if (OP == 1)
		{
			IR.
			getInstance().
			Add_IRcommand(new IRcommand_Binop_Substract_Integers(dst,t1,t2));
		}
		if (OP == 2)
		{
			IR.
			getInstance().
			Add_IRcommand(new IRcommand_Binop_Mul_Integers(dst,t1,t2));
		}
		if (OP == 3)
		{
			IR.
			getInstance().
			Add_IRcommand(new IRcommand_Binop_Divide_Integers(dst,t1,t2));
		}
		if (OP == 4)
		{
			IR.
			getInstance().
			Add_IRcommand(new IRcommand_Binop_LT_Integers(dst,t1,t2));
		}
		if (OP == 5)
		{
			IR.
			getInstance().
			Add_IRcommand(new IRcommand_Binop_GT_Integers(dst,t1,t2));
		}
		if (OP == 6)
		{
			IR.
			getInstance().
			Add_IRcommand(new IRcommand_Binop_EQ_Integers(dst,t1,t2));
		}
		return dst;
	}
}
