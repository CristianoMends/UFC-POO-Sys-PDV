package pdv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pdv.controller.Pdv;
import pdv.model.enums.Cor;

public class AdminView extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnCaixas;
	private JButton btnEstoque;
	private JButton btnFuncionarios;

	public AdminView() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Cor.CinzaMedio.getColor());
		panel.setBounds(0, 0, 800, 44);
		add(panel);
		panel.setLayout(null);

		JLabel lblPainelDoAdministrador = new JLabel("Painel Gerenciador");
		lblPainelDoAdministrador.setForeground(Cor.BrancoPuro.getColor());
		lblPainelDoAdministrador.setBounds(292, 12, 194, 15);
		panel.add(lblPainelDoAdministrador);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 800, 600);
		add(panel_1);
		panel_1.setBackground(Cor.AzulDodger.getColor());
		panel_1.setLayout(null);

		this.btnEstoque = new JButton("Estoque");
		this.btnEstoque.setBounds(276, 90, 200, 25);
		panel_1.add(btnEstoque);

		this.btnCaixas = new JButton("Caixas");
		this.btnCaixas.setBounds(276, 127, 200, 25);
		panel_1.add(btnCaixas);

		btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBounds(276, 164, 200, 25);
		panel_1.add(btnFuncionarios);
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
	public void setAcoesBtns(PrincipalView parent, EstoqueView estoqueView, VendasView vendasView, FuncionariosView funcionariosView) {
		getBtnGerenciarCaixas().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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
	}
}
