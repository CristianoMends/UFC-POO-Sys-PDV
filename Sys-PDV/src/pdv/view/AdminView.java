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

public class AdminView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnEstoque;
	private JButton btnCaixas;
	private JButton btnClientes;
	private JButton btnFuncionarios;

	public AdminView() {
		
		btnEstoque = new JButton("Estoque");
		btnEstoque.setToolTipText("Gerencie o estoque de produtos");
		
		btnCaixas = new JButton("Caixas");
		btnCaixas.setToolTipText("Gerencie os caixas e transacoes");
		
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
						.addComponent(btnCaixas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
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
					.addComponent(btnCaixas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEstoque, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		setBackground(Cor.AzulDodger.getColor());
		setLayout(groupLayout);
	}

	public JButton getBtnGerenciarCaixas() {
		return btnCaixas;
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
	public void setAcoesBtns(PrincipalView parent, EstoqueView estoqueView, VendasView vendasView, FuncionariosView funcionariosView, CaixasView caixasView, ClientesView clientesView) {
		getBtnGerenciarCaixas().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vendasView.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(caixasView);
				caixasView.setBounds(x, y, 790, 590);
				caixasView.setVisible(true);
			}
		});
		getBtnEstoque().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vendasView.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(estoqueView);
				estoqueView.setBounds(x, y, 790, 590);
				estoqueView.setVisible(true);
			}
		});
		getBtnFuncionarios().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vendasView.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(funcionariosView);
				funcionariosView.setBounds(x, y, 790, 590);
				funcionariosView.setVisible(true);
			}
		});
		getBtnClientes().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vendasView.estaVendendo()) {
					Pdv.showMensagem(getBtnEstoque(), "Finalize ou cancele a venda primeiro", "Aviso!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (parent.getPanel2().getWidth() / 2) - (800 / 2);
				int y = (int) (parent.getPanel2().getHeight() / 2) - (600 / 2);

				parent.getPanel2().removeAll();
				parent.getPanel2().revalidate();
				parent.getPanel2().repaint();

				parent.getPanel2().add(clientesView);
				clientesView.setBounds(x, y, 790, 590);
				clientesView.setVisible(true);
			}
		});
	}
}
