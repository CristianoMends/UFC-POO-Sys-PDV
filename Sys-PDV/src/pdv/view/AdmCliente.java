package pdv.view;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import pdv.controller.Pdv;
import pdv.model.entidades.Cliente;
import pdv.model.entidades.Pessoa;
import pdv.model.enums.Cor;

public class AdmCliente extends JPanel{
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
    private JTable table;
	private String cargo = null;
	
	public AdmCliente() {
		setSize(800,600);
		setBackground(Cor.AzulDodger.getColor());
		setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Cor.AzulDodger.getColor());
		panelTop.setBounds(0, 5, 800, 300);
		panelTop.setOpaque(true);
		panelTop.setLayout(null);
		add(panelTop);

		JLabel lblEstoque = new JLabel("Clientes");
		lblEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoque.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEstoque.setForeground(Cor.CinzaMedio.getColor());
		lblEstoque.setBackground(Cor.BrancoPuro.getColor());
		lblEstoque.setBounds(0, -11, 800, 41);
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
	}
	
	 private void addCliTabela() {		 
			ArrayList<Cliente> clientes = Pdv.pessoaDao.getClientes();
			if(clientes.size() == 0) {
				Pdv.showMensagem(btnAtualizar, "Não possuem clientes cadastrados", "Aviso!", JOptionPane.WARNING_MESSAGE);
				return;
			}
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
	        for (Cliente f : clientes) {
	            Object[] rowData = {f.getId(), f.getNome(), f.getEndereco(), f.getEmail(), f.getCpf()};
	            model.addRow(rowData);
	        }
	        if(model.getRowCount() == 0) {
	        	Pdv.showMensagem(btnAtualizar, "Não possui clientes cadastrados!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
	        }
	 }
	 private void cadCli() {
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
		 
		 if(!Pdv.pessoaDao.inserirCliente(new Cliente(nome, end, email, cpf))) {
			 Pdv.showMensagem(btnCadastrar, "Erro ao cadastrar cliente", "Erro!", JOptionPane.ERROR_MESSAGE);
			 return;
		 }else {
			 Pdv.showMensagem(btnCadastrar, "Cliente cadastrado com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
			 this.textCpf.setText("");
			 this.textEmail.setText("");
			 this.textEndereco.setText("");
			 this.textNome.setText("");
			 return;
		 }
	 }
	 
	 public void removerCliente() {
		String input = Pdv.showInput(btnRemover, "Digite o id do cliente", "", JOptionPane.QUESTION_MESSAGE);
		try {
			int cod = Integer.parseInt(input);

			boolean encontrado = false;
			for (Pessoa p : Pdv.pessoaDao.getClientes()) {
				if (p.getId() == cod) {
					Pdv.pessoaDao.removerCliente(cod);
					Pdv.showMensagem(btnRemover, "Cliente removido com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				Pdv.showMensagem(btnRemover, "Cliente com o ID informado não foi encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			Pdv.showMensagem(btnRemover, "Valor invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
	 }
	
	public void setEvents() {
		this.btnAtualizar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addCliTabela();
			}
		});
		this.btnCadastrar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadCli();
			}
		});
		this.btnRemover.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				removerCliente();				
			}
		});
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
