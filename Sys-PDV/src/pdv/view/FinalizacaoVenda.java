package pdv.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pdv.controller.Pdv;
import pdv.model.entidades.Venda;
import pdv.model.enums.FormaPagamento;
import java.awt.Font;

public class FinalizacaoVenda extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Venda venda;
	private VendasView tela;
	
	public FinalizacaoVenda(Venda venda, VendasView tela) {
		this.venda = venda;
		this.tela = tela;
		Double vTotal = venda.getTotal();
		
		setTitle("Janela Dinheiro");       
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 250, 200);
		        
        JTextField entregue = new JTextField(10);
        entregue.setBounds(181, 95, 114, 19);
        entregue.setText("0");
        panel_5.setLayout(null);
        JLabel lblPago = new JLabel("Pago: ");
        lblPago.setBounds(61, 97, 115, 15);
        panel_5.add(lblPago);
        panel_5.add(entregue);
        
        
        JLabel label_1 = new JLabel("Troco: ");
        label_1.setBounds(61, 116, 48, 15);
        panel_5.add(label_1);        
        
        JComboBox<FormaPagamento> comboBoxFormaPagamento = new JComboBox<>(FormaPagamento.values());
        comboBoxFormaPagamento.setBounds(61, 164, 154, 24);
        
        JLabel label_2 = new JLabel("Forma de Pagamento: ");
        label_2.setBounds(61, 142, 160, 15);
        panel_5.add(label_2);
        panel_5.add(comboBoxFormaPagamento);

        JButton btnFinalizarVenda = new JButton("Finalizar");
        btnFinalizarVenda.setBounds(111, 199, 124, 25);
        
        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(61, 79, 115, 15);
        panel_5.add(lblTotal);
        
        JTextField total = new JTextField(10);
        total.setText(String.format("R$ %.2f", vTotal));
        total.setEditable(false);
        total.setBounds(181, 77, 114, 19);
        panel_5.add(total);
        
        JTextField troco = new JTextField(10);
        troco.setEditable(false);
        troco.setText("0.00");
        troco.setBounds(181, 114, 114, 19);
        panel_5.add(troco);        
        
        Pdv.filtrarNumeros(entregue);
        panel_5.add(btnFinalizarVenda);        
        
        setSize(350,300);
        setLocationRelativeTo(null);
        getContentPane().add(panel_5);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(111, 235, 124, 25);
        panel_5.add(btnCancelar);
        
        JLabel lblNewLabel = new JLabel("Finalize a venda");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(120, 11, 140, 14);
        panel_5.add(lblNewLabel);
        setUndecorated(true);
        setVisible(true);
        
        btnFinalizarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Double vEntregue = Double.parseDouble(entregue.getText());
            	if(vEntregue < vTotal) {
            		JOptionPane.showMessageDialog(troco, "O valor pago é menor que o total da compra");
            		return;
            		//throw new MsgException("O valor pago é menor que o total da compra");
            	}
            	JOptionPane.showMessageDialog(troco, "Venda finalizada!");
            	lancarVenda();            	
            	dispose();
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Pdv.showMessageOpcao(btnCancelar, "Deseja cancelar?", "Aviso", JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
					dispose();
				}				
			}
		});
        
        entregue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Double vEntregue = Double.parseDouble(entregue.getText());
            	if(vEntregue > vTotal) {
                    troco.setText(String.format("R$ %.2f", (vEntregue - vTotal)));
            	}
            }
        });      
	}

	public void lancarVenda() {
		venda = new Venda();
		tela.atualizarVenda(venda);
		dispose();
	}
}
