package pdv.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pdv.controller.Pdv;
import pdv.model.entidades.Funcionario;
import pdv.model.enums.Cargo;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private JLabel lblDigitaSeuLogin;
	private JLabel lblNewLabel;
	private JButton btnEntrar;
	private JButton btnSair;
	private JFrame telaAtual;
	private PrincipalView telaRequisitada;

	public Login(JFrame telaAtual, PrincipalView telaRequistada) {
		setTelaAtual(telaAtual);
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

		Image icon = new ImageIcon(TelaVendas.class.getResource("/pdv/view/imagens/login.png")).getImage()
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
				entrar();			
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
		textUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textSenha.requestFocusInWindow();  // Certifica-se de que o campo de texto tem o foco
                }
            }
        });
		textSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnEntrar.requestFocusInWindow();  // Certifica-se de que o campo de texto tem o foco
                    entrar();
                }
            }
        });
		//setFocusable(true); 
		setSize(300, 300);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		ImageIcon icone = new ImageIcon(PrincipalView.class.getResource("/pdv/view/imagens/ponto-de-venda.png"));
        this.setIconImage(icone.getImage());
	}
	public JTextField getTextUsuario() {
		return this.textUsuario;
	}
	public JTextField getTextSenha() {
		return this.textSenha;
	}
	public void entrar() {
		Funcionario fun = funLogin(getTextUsuario().getText(), getTextSenha().getText());
		if(fun == null) {
			Pdv.showMensagem(btnEntrar, "Usuario ou senha invalida!\nTente Novamente", "Erro",JOptionPane.WARNING_MESSAGE);
			return;
		}
		setVisible(false);
		Pdv.showMensagem(btnEntrar, "Olá "+fun.getNome()+" , Seja bem vindo ao Sistema Pdv!", "Bem Vindo!", JOptionPane.PLAIN_MESSAGE);
		Pdv.setAdmAtual(fun);
		telaRequisitada.setVisible(true);
	}
	
	public Funcionario funLogin(String usuario, String senha) {
		ArrayList<Funcionario> f = Pdv.pessoaDao.getFuncionarios();
		for(Funcionario fun : f) {
			if(usuario.equals(fun.getUsuario()) && senha.equals(fun.getSenha())) {
				return fun;
			}
		}
		return null;
	}
	public JFrame getTelaAtual() { return telaAtual; }
	public void setTelaAtual(JFrame telaAtual) { this.telaAtual = telaAtual; }
}
