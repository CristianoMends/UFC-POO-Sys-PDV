
package pdv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.util.*;
import pdv.model.*;
import pdv.view.*;

class MainViewController{
    private MainView mainView = new MainView();
    private Estoque estoque;
    private Venda venda;

    public MainViewController(Estoque estoque){
        this.estoque = estoque;

        mainView.getTextCod().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Produto produto = new Produto("Acucar", 5.50, 10);

              /*Produto  produto     = mainView.getProduto(Integer.parseInt(mainView.getTextCod().getText()), estoque);
               if(produto == null){
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!");
               }*/

               int      quantidade  = Integer.parseInt(mainView.getTextQtd().getText());
               double   total       = (double) (produto.getPreco() * quantidade); 
                
              // Produto p = new Produto(1, "Acucar", 5.50, 10);
                ItemVenda itemVenda = new ItemVenda(produto, quantidade, total);

                if(venda == null){ venda = new Venda(); }

                venda.adicionarItem(itemVenda);
                venda.setData(LocalDate.now());
              
                mainView.atualizarVenda(venda);
            }
        });

        mainView.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.add();     
            }
        });
        mainView.getBtnRem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rem();     
            }
        });

    }
    public MainView getMainView(){
        return this.mainView;
    }
    public void show(){
        mainView.showMainView();
    }
    public void iniciarVenda(){
        venda = null;
    } 
}