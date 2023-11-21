package pdv.controller;

import javax.swing.JOptionPane;

import pdv.model.exceptions.MsgException;

public class Launch {
    public static void main(String[] arg) {
    	try {
    		Pdv pdv = new Pdv();
    	}catch(MsgException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    	}
        
    }
}
