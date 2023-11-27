package pdv.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import pdv.model.enums.Cargo;
import pdv.model.enums.Cor;

public class FuncionariosView extends JPanel{
	private JButton btnAtualizar;
	private JTextArea textEstoque;
	private JTextField textCpf;
	private JTextField textEmail;
	private JTextField textEndereco;
	private JTextField textNome;
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JTextField textUsuario;
	private JTextField textSenha;
	private String cargo = null;
	
	public FuncionariosView() {
		setBackground(Cor.AzulDodger.getColor());
		setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 330, 800, 240);
		panel_2.setBackground(Cor.AzulDodger.getColor());
		panel_2.setOpaque(false);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setBounds(313, 12, 116, 15);
		lblCadastro.setOpaque(true);
		panel_2.add(lblCadastro);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Cor.BrancoPuro.getColor());
		lblNome.setBounds(29, 52, 70, 15);
		panel_2.add(lblNome);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setForeground(Cor.BrancoPuro.getColor());
		lblEndereco.setBounds(29, 79, 70, 15);
		panel_2.add(lblEndereco);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Cor.BrancoPuro.getColor());
		lblEmail.setBounds(29, 106, 116, 15);
		panel_2.add(lblEmail);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setForeground(Cor.BrancoPuro.getColor());
		lblCpf.setBounds(29, 136, 104, 15);
		panel_2.add(lblCpf);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(Cor.BrancoPuro.getColor());
		lblCargo.setBounds(29, 163, 104, 15);
		panel_2.add(lblCargo);

		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(82, 134, 250, 19);
		panel_2.add(textCpf);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(82, 104, 250, 19);
		panel_2.add(textEmail);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(82, 77, 250, 19);
		panel_2.add(textEndereco);

		this.textNome = new JTextField();
		this.textNome.setColumns(30);
		this.textNome.setBounds(82, 50, 250, 19);
		panel_2.add(textNome);
		 ButtonGroup buttonGroup = new ButtonGroup();

		this.btnCadastrar = new JButton("Cadastrar");
		this.btnCadastrar.setBounds(313, 203, 117, 25);
		panel_2.add(btnCadastrar);
		
		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(448, 49, 116, 19);
		panel_2.add(textUsuario);
		
		textSenha = new JTextField();
		textSenha.setEditable(false);
		textSenha.setColumns(10);
		textSenha.setBounds(448, 79, 116, 19);
		panel_2.add(textSenha);
		
		JRadioButton btnRd1 = new JRadioButton(Cargo.ADMINISTRADOR.getDescricao());
		btnRd1.setBounds(82, 158, 124, 20);
		panel_2.add(btnRd1);
		buttonGroup.add(btnRd1);
		JRadioButton btnRd2 = new JRadioButton(Cargo.VENDEDOR.getDescricao());
		btnRd2.setBounds(207, 158, 124, 20);
		panel_2.add(btnRd2);
		buttonGroup.add(btnRd2);
		
		btnRd1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                cargo = btnRd1.getText();
	                textUsuario.setEditable(true);
	                textSenha.setEditable(true);
	            }
	        });

		btnRd2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	cargo = btnRd2.getText();
	            }
	        });
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(392, 52, 100, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(392, 79, 100, 14);
		panel_2.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Cor.AzulDodger.getColor());
		panel_1.setBounds(0, 45, 800, 286);
		add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);

		JLabel lblEstoque = new JLabel("Funcionarios");
		lblEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoque.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEstoque.setForeground(Cor.CinzaMedio.getColor());
		lblEstoque.setBackground(Cor.BrancoPuro.getColor());
		lblEstoque.setBounds(310, 12, 117, 15);
		lblEstoque.setOpaque(true);
		panel_1.add(lblEstoque);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(77, 54, 608, 193);
		scrollPane.setBackground(Cor.CinzaMedio.getColor());
		panel_1.add(scrollPane);

		this.textEstoque = new JTextArea();
		this.textEstoque.setEditable(false);
		this.textEstoque.setOpaque(false);
		this.textEstoque.setBackground(Cor.CinzaMedio.getColor());
		this.textEstoque.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setColumnHeaderView(textEstoque);

		JLabel lblCodNome = new JLabel(
				"Cod |                  Nome                  |        Preço        |  QtdEstoque  | Categoria");
		lblCodNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCodNome.setForeground(Cor.BrancoPuro.getColor());
		lblCodNome.setBounds(77, 40, 608, 15);
		panel_1.add(lblCodNome);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 280, 800, 25);
		panel_1.add(separator);

		this.btnAtualizar = new JButton("Atualizar");
		this.btnAtualizar.setBounds(390, 249, 117, 25);
		panel_1.add(btnAtualizar);

		this.btnRemover = new JButton("remover");
		this.btnRemover.setBounds(230, 249, 117, 25);
		panel_1.add(this.btnRemover);
		panel_1.setBackground(Cor.AzulDodger.getColor());


		JPanel panel = new JPanel();
		panel.setBackground(Cor.CinzaMedio.getColor());
		panel.setBounds(0, 0, 800, 44);
		add(panel);
		panel.setLayout(null);

		JLabel lblPainelDoAdministrador = new JLabel("Gerenciador de Funcionarios");
		lblPainelDoAdministrador.setForeground(Cor.BrancoPuro.getColor());
		lblPainelDoAdministrador.setBounds(292, 12, 194, 15);
		panel.add(lblPainelDoAdministrador);
	}
	
	public void setAcoesBtns() {
		
	}
}
