package pdv.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pdv.controller.Pdv;

public class Login extends JFrame {
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private JLabel lblDigitaSeuLogin;
	private JLabel lblNewLabel;
	private JButton btnEntrar;
	private JButton btnSair;
	private JFrame telaAtual;
	private JFrame telaRequisitada;

	public Login(JFrame telaAtual, JFrame telaRequistada) {
		this.telaAtual = telaAtual;
		this.telaRequisitada = telaRequistada;
		if(telaAtual != null) {telaAtual.setVisible(false);}	

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(38, 129, 70, 15);
		getContentPane().add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setBounds(38, 143, 223, 20);
		getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(38, 175, 70, 15);
		getContentPane().add(lblSenha);

		textSenha = new JPasswordField();
		textSenha.setBounds(38, 191, 223, 20);

		getContentPane().add(textSenha);

		lblDigitaSeuLogin = new JLabel("Digite seu login para continuar!");
		lblDigitaSeuLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigitaSeuLogin.setBounds(0, 20, 300, 15);
		getContentPane().add(lblDigitaSeuLogin);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		Image icon = new ImageIcon(VendasView.class.getResource("/pdv/view/imagens/login.png")).getImage()
				.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(icon));
		lblNewLabel.setBounds(0, 51, 300, 80);
		getContentPane().add(lblNewLabel);

		this.btnEntrar = new JButton("Entrar");
		this.btnEntrar.setBounds(100, 223, 100, 25);
		getContentPane().add(btnEntrar);
		this.btnEntrar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(hasLogin(getTextUsuario().getText(), getTextSenha().getText()))) {
					Pdv.showMensagem(btnEntrar, "Usuario ou senha invalida!\nTente Novamente", "Erro",JOptionPane.WARNING_MESSAGE);
					return;
				}
				setVisible(false);
				if(telaRequisitada != null) { telaRequisitada.setVisible(true); }				
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(100, 250, 100, 25);
		getContentPane().add(btnSair);
		this.btnSair.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int op = Pdv.showMessageOpcao(btnSair, "Deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION);
				if(op == JOptionPane.YES_OPTION) {
					if(telaAtual != null) {
						telaAtual.setVisible(true);										
					}
					dispose();
				}				
			}
		});
		
		setSize(300, 300);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	public void hidden() {
		setVisible(false);
	}
	public JTextField getTextUsuario() {
		return this.textUsuario;
	}
	public JTextField getTextSenha() {
		return this.textSenha;
	}
	
	public boolean hasLogin(String usuario, String senha) {
		if(usuario.equals(Pdv.USUARIO) && senha.equals(Pdv.SENHA)) {		
			return true;
		}
		
		return false;
	}
}
