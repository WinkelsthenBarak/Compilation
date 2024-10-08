package IR;

import MIPS.*;
import TEMP.*;

public class IRcommand_Binop_Add_Strings extends IRcommand_Binop {

    public IRcommand_Binop_Add_Strings(TEMP dst, TEMP t1, TEMP t2) {
        this.dst = dst;
        this.t1 = t1;
        this.t2 = t2;
        changeName("IRcommand_Binop");
    }

    public void MIPSme() {
        System.out.println("IRcommand_Binop_Add_Strings" + "- MIPSme");
        String l0 = IRcommand.getFreshLabel("concat_count_start");
        String l1 = IRcommand.getFreshLabel("concat_count_str1");
        String l2 = IRcommand.getFreshLabel("concat_count_str2");
        String l3 = IRcommand.getFreshLabel("concat_copy_start");
        String l4 = IRcommand.getFreshLabel("concat_copy_str1");
        String l5 = IRcommand.getFreshLabel("concat_copy_str2");
        String l6 = IRcommand.getFreshLabel("concat_end");
        String[] arr = {l0, l1, l2, l3, l4, l5, l6};
        MIPSGenerator.getInstance().concat_strings(dst, t1, t2, arr);
    }
}
