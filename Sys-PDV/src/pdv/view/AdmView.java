package pdv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pdv.controller.Pdv;
import pdv.model.enums.Cor;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdmView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnEstoque;
	private JButton btnEstatisticas;
	private JButton btnClientes;
	private JButton btnFuncionarios;

	public AdmView() {
		
		btnEstoque = new JButton("Estoque");
		btnEstoque.setToolTipText("Gerencie o estoque de produtos");
		
		btnEstatisticas = new JButton("Estatisticas");
		btnEstatisticas.setToolTipText("Gerencie os caixas e transacoes");
		
		btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setToolTipText("Gerencie os funcionarios");
		
		btnClientes = new JButton("Clientes");
		btnClientes.setToolTipText("Gerencie os clientes");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(126)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEstoque, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(btnEstatisticas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(btnClientes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(btnFuncionarios, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addGap(124))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFuncionarios, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEstatisticas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEstoque, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		setBackground(Cor.AzulDodger.getColor());
		setLayout(groupLayout);
	}
	
	public void setEvents(PrincipalView parent, AdmEstoque admEstoque, TelaVendas telaVendas, AdmFuncionario AdmFuncionario, AdmEstatisticas admEstatisticas, AdmCliente admCliente) {
		getBtnGerenciarCaixas().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaVendas.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(admEstatisticas);
				admEstatisticas.setBounds(x, y, 790, 590);
				admEstatisticas.setVisible(true);
			}
		});
		getBtnEstoque().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaVendas.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(admEstoque);
				admEstoque.setBounds(x, y, 790, 590);
				admEstoque.setVisible(true);
			}
		});
		getBtnFuncionarios().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaVendas.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(AdmFuncionario);
				AdmFuncionario.setBounds(x, y, 790, 590);
				AdmFuncionario.setVisible(true);
			}
		});
		getBtnClientes().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaVendas.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(admCliente);
				admCliente.setBounds(x, y, 790, 590);
				admCliente.setVisible(true);
			}
		});
	}
	public JButton getBtnGerenciarCaixas() {
		return btnEstatisticas;
	}

	public JButton getBtnEstoque() {
		return btnEstoque;
	}
	public JButton getBtnFuncionarios() {
		return this.btnFuncionarios;
	}
	public JButton getBtnClientes() {
		return this.btnClientes;
	}
}
