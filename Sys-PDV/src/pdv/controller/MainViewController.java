
package pdv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import pdv.model.Estoque;
import pdv.model.Produto;
import pdv.view.MainView;

class MainViewController{
    private MainView mainView = new MainView();
    private Estoque estoque;

    public MainViewController(Estoque estoque){
        this.estoque = estoque;

        mainView.getTextCod().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               
            }
        });

    }
    public MainView getMainView(){
        return this.mainView;
    } 
}