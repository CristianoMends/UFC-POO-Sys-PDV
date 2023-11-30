package pdv.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import pdv.controller.Pdv;
import pdv.model.entidades.ProdutoVenda;
import pdv.model.entidades.Venda;
import pdv.model.enums.Cargo;
import pdv.model.enums.FormaPg;
import java.awt.Font;

public class FinalizacaoVenda extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Venda venda;
	private VendasView tela;
	private String fpg = null;
	private String troco = "";
	private JTextField textTroco;
	
	public FinalizacaoVenda(Venda venda, VendasView tela) {
		this.venda = venda;
		this.tela = tela;
		Double vTotal = venda.getTotal();
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
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
        
        JLabel label_2 = new JLabel("Forma de Pagamento: ");
        label_2.setBounds(61, 142, 160, 15);
        panel_5.add(label_2);

        JButton btnFinalizarVenda = new JButton("Finalizar");
        btnFinalizarVenda.setBounds(111, 239, 124, 25);
        
        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(61, 79, 115, 15);
        panel_5.add(lblTotal);
        
        JTextField total = new JTextField(10);
        total.setText(String.format("R$ %.2f", vTotal));
        total.setEditable(false);
        total.setBounds(181, 77, 114, 19);
        panel_5.add(total);
        
        textTroco = new JTextField(10);
        textTroco.setEditable(false);
        textTroco.setText("0.00");
        textTroco.setBounds(181, 114, 114, 19);
        panel_5.add(textTroco);        
        
        Pdv.filtrarNumeros(entregue);
        panel_5.add(btnFinalizarVenda);        
        
        setSize(350,300);
        setLocationRelativeTo(null);
        getContentPane().add(panel_5);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(111, 264, 124, 25);
        panel_5.add(btnCancelar);
        
        JLabel lblNewLabel = new JLabel("Finalize a venda");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(120, 11, 140, 14);
        panel_5.add(lblNewLabel);
        JRadioButton rdDinheiro = new JRadioButton(FormaPg.DINHEIRO.getDescricao());
        panel_5.add(rdDinheiro);
        rdDinheiro.setBounds(61, 164, 86, 20);
        buttonGroup.add(rdDinheiro);
        
        JRadioButton rdCredito = new JRadioButton(FormaPg.CARTAO_CREDITO.getDescricao());
        panel_5.add(rdCredito);
        rdCredito.setBounds(149, 164, 86, 20);
        buttonGroup.add(rdCredito);	
        
        JRadioButton rdDebito = new JRadioButton(FormaPg.CARTAO_DEBITO.getDescricao());
        panel_5.add(rdDebito);
        rdDebito.setBounds(237, 164, 62, 20);
        buttonGroup.add(rdDebito);	
        setUndecorated(true);
        setVisible(true);
        
        btnFinalizarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!rdDinheiro.isSelected() && !rdCredito.isSelected() && !rdDebito.isSelected()) {
            		Pdv.showMensagem(btnFinalizarVenda, "Selecione uma forma de pagamento!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
            		return;
            	}
            	Double vEntregue = Double.parseDouble(entregue.getText());
            	if(vEntregue < vTotal) {
                	Pdv.showMensagem(btnFinalizarVenda, "O valor pago é menor que o total da compra", "Aviso!", JOptionPane.WARNING_MESSAGE);
            		return;
            	}
            	Pdv.showMensagem(btnFinalizarVenda, "Venda finalizada com sucesso!", "Aviso!", JOptionPane.WARNING_MESSAGE);
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
            	
            }
        });
        rdDinheiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Double vEntregue = Double.parseDouble(entregue.getText());
            	if(vEntregue > vTotal) {
                    troco = String.format("R$ %.2f", (vEntregue - vTotal));
            	}
            	fpg = rdDinheiro.getText();
            	textTroco.setText(troco);
            	textTroco.setEnabled(true);
            }
        });
        rdCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fpg = rdCredito.getText();
            	textTroco.setText("");
            	textTroco.setEnabled(false);
            }
        });
        rdDebito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fpg = rdDebito.getText();
            	textTroco.setText("");
            	textTroco.setEnabled(false);
            }
        });
	}

	public void lancarVenda() {
		for(ProdutoVenda item : Pdv.venda.getItens()) {
			int id = item.getProduto().getId();
			int qtdVendida = item.getQuantidade();
			Pdv.vendaDao.atualizarQuantidadeProduto(id, qtdVendida);
		}
		Pdv.venda.setMetodo(fpg);
		Pdv.venda.setData(LocalDate.now());
		Pdv.vendaDao.adicionarVenda(venda);
		venda = new Venda();
		tela.atualizarVenda(venda);
		dispose();
	}
}
