package pdv.controller;
import javax.swing.*;

import pdv.model.MsgException;

public class Launch {
    public static void main(String[] arg) {
    	try {
    		Pdv pdv = new Pdv();
 	       	pdv.showMainView();
    	}catch(MsgException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
    	}
	       
        
    }
}
