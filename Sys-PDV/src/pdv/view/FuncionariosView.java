package pdv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import pdv.controller.Pdv;
import pdv.model.entidades.Funcionario;
import pdv.model.enums.Cargo;
import pdv.model.enums.Cor;

public class FuncionariosView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAtualizar;
	private JTextField textCpf;
	private JTextField textEmail;
	private JTextField textEndereco;
	private JTextField textNome;
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JTextField textUsuario;
	private JTextField textSenha;
    private JTable table;
	private String cargo = null;
	
	public FuncionariosView() {
		setBackground(Cor.AzulDodger.getColor());
		setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Cor.AzulDodger.getColor());
		panelTop.setBounds(0, 5, 800, 300);
		panelTop.setOpaque(true);
		panelTop.setLayout(null);
		add(panelTop);
		
		JLabel lblGeFun = new JLabel("Gerenciador de Funcionarios");
		lblGeFun.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeFun.setForeground(Cor.BrancoPuro.getColor());
		lblGeFun.setBackground(Cor.CinzaMedio.getColor());
		lblGeFun.setFont(new Font("Dialog", Font.BOLD, 15));
		lblGeFun.setBounds(0, 0, 800, 15);
		panelTop.add(lblGeFun);

		JLabel lblEstoque = new JLabel("Funcionarios");
		lblEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoque.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEstoque.setForeground(Cor.CinzaMedio.getColor());
		lblEstoque.setBackground(Cor.BrancoPuro.getColor());
		lblEstoque.setBounds(0, 15, 800, 15);
		lblEstoque.setOpaque(true);
		panelTop.add(lblEstoque);		
		
		JPanel panelFunc = new JPanel();
		panelFunc.setBackground(Cor.CinzaMedio.getColor());
		panelFunc.setBounds(0, 30, 800, 240);
        panelFunc.setOpaque(true);
        panelFunc.setLayout(new BorderLayout());
		panelTop.add(panelFunc);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelFunc.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setEnabled(false);
        table.setForeground(Cor.BrancoPuro.getColor());
        table.setBackground(Cor.CinzaMedio.getColor());
        scrollPane.setViewportView(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Endereco");
        model.addColumn("Email");
        model.addColumn("Cpf");
        model.addColumn("Cargo");
        model.addColumn("Usuario");
        model.addColumn("Senha");
        table.setModel(model);	        
        
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBtn.setBounds(0,270,800,30);
        
		this.btnAtualizar = new JButton("Atualizar");
		panelBtn.add(btnAtualizar);

		this.btnRemover = new JButton("remover");
		panelBtn.add(this.btnRemover);
		panelTop.add(panelBtn);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBounds(0, 305, 800, 300);
		panelBottom.setBackground(Cor.AzulDodger.getColor());
		panelBottom.setOpaque(false);
		add(panelBottom);
		panelBottom.setLayout(null);

		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setBounds(0, 0, 800, 15);
		lblCadastro.setOpaque(true);
		panelBottom.add(lblCadastro);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Cor.BrancoPuro.getColor());
		lblNome.setBounds(25, 52, 70, 15);
		panelBottom.add(lblNome);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setForeground(Cor.BrancoPuro.getColor());
		lblEndereco.setBounds(25, 79, 70, 15);
		panelBottom.add(lblEndereco);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Cor.BrancoPuro.getColor());
		lblEmail.setBounds(25, 106, 116, 15);
		panelBottom.add(lblEmail);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setForeground(Cor.BrancoPuro.getColor());
		lblCpf.setBounds(25, 136, 104, 15);
		panelBottom.add(lblCpf);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(Cor.BrancoPuro.getColor());
		lblCargo.setBounds(25, 163, 104, 15);
		panelBottom.add(lblCargo);
		
		 try {
	            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
	            textCpf = new JFormattedTextField(cpfMask);
	            textCpf.setColumns(10);
	        } catch (ParseException e) {
	            textCpf = new JFormattedTextField(); // Em caso de erro, use um campo de texto regular
	        }
		
		textCpf.setBounds(82, 134, 250, 19);
		panelBottom.add(textCpf);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(82, 104, 250, 19);
		panelBottom.add(textEmail);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(82, 77, 250, 19);
		panelBottom.add(textEndereco);

		this.textNome = new JTextField();
		this.textNome.setColumns(30);
		this.textNome.setBounds(82, 50, 250, 19);
		panelBottom.add(textNome);
		ButtonGroup buttonGroup = new ButtonGroup();

		this.btnCadastrar = new JButton("Cadastrar");
		this.btnCadastrar.setBounds(313, 203, 117, 25);
		panelBottom.add(btnCadastrar);
		
		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(448, 49, 116, 19);
		panelBottom.add(textUsuario);
		
		textSenha = new JTextField();
		textSenha.setEditable(false);
		textSenha.setColumns(10);
		textSenha.setBounds(448, 79, 116, 19);
		panelBottom.add(textSenha);
		
		JRadioButton radioAdm = new JRadioButton(Cargo.ADMINISTRADOR.getDescricao());
		radioAdm.setBounds(82, 158, 124, 20);
		panelBottom.add(radioAdm);
		buttonGroup.add(radioAdm);
		JRadioButton radioVend = new JRadioButton(Cargo.VENDEDOR.getDescricao());
		radioVend.setBounds(207, 158, 124, 20);
		panelBottom.add(radioVend);
		buttonGroup.add(radioVend);		
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(392, 52, 100, 14);
		panelBottom.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(392, 79, 100, 14);
		panelBottom.add(lblNewLabel_1);

		radioAdm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargo = radioAdm.getText();
                textUsuario.setEditable(true);
                textSenha.setEditable(true);
            }
        });

	radioVend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cargo = radioVend.getText();
            	textUsuario.setText("");
            	textSenha.setText("");
                textUsuario.setEditable(false);
                textSenha.setEditable(false);	            	
            }
        });
	}
	
	 private void addFunTabela() {
		 
			ArrayList<Funcionario> funcionarios = Pdv.pessoaDao.getFuncionarios();
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
	        for (Funcionario f : funcionarios) {
	            Object[] rowData = {f.getId(), f.getNome(), f.getEndereco(), f.getEmail(), f.getCpf(), f.getCargo(), f.getUsuario(), f.getSenha()};
	            model.addRow(rowData);
	        }
	        if(model.getRowCount() == 0) {
	        	Pdv.showMensagem(btnAtualizar, "Não possui funcionario cadastrados!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
	        }
	 }
	 private void cadFun() {
		 
		 String nome = this.textNome.getText();
		 if(nome.length() == 0) {
			 Pdv.showMensagem(this.textNome, "Preencha o campo Nome!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
			 return;
		 }
		 String end  = this.textEndereco.getText();
		 if(end.length() == 0) {
			 Pdv.showMensagem(this.textEndereco, "Preencha o campo Endereco!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
			 return;
		 }
		 String email = this.textEmail.getText();
		 if(email.length() == 0) {
			 Pdv.showMensagem(this.textEmail, "Preencha o campo Email!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
			 return;
		 }
		 if(!email.contains("@gmail.com")) {
			 Pdv.showMensagem(this.textEmail, "O EMAIL digitado é inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 String cpf  = this.textCpf.getText();
		 if(cpf.length() < 10) {
			 Pdv.showMensagem(this.textCpf, "O CPF digitado é inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 String cargo = this.cargo;
		 if(cargo == null) {
			 Pdv.showMensagem(this.textCpf, "Selecione um cargo!", "Erro!", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 String usuario = null;
		 String senha = null;
		 if(Cargo.ADMINISTRADOR.getDescricao().equals(cargo)){
			 usuario = this.textUsuario.getText();
			 senha = this.textSenha.getText();
			 boolean contemNumero = false;
			 for (char caractere : senha.toCharArray()) {
			     if (Character.isDigit(caractere)) {
			         contemNumero = true;
			         break;
			     }
			 }
			 if (!contemNumero) {
				 Pdv.showMensagem(this.textSenha, "A senha precisar conter pelo menos 1 número!", "Erro!", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
		 }
		 if(!Pdv.pessoaDao.inserirFuncionario(new Funcionario(nome, end, email, cpf, cargo, usuario, senha))) {
			 Pdv.showMensagem(btnCadastrar, "Erro ao cadastrar funcionario", "Erro!", JOptionPane.ERROR_MESSAGE);
			 return;
		 }else {
			 Pdv.showMensagem(btnCadastrar, "Funcionario cadastrado com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
			 return;
		 }
	 }
	
	public void setAcoesBtns() {
		this.btnAtualizar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addFunTabela();
			}
		});
		this.btnCadastrar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadFun();
			}
		});
	}
}
