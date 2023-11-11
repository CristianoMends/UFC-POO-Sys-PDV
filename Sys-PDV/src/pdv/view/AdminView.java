package pdv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pdv.model.Estoque;

public class AdminView extends JFrame{
	private static final long serialVersionUID = 1L;
	private Estoque estoque;

	public AdminView(Estoque estoque) {
		super("Tela de cadastro");
		this.estoque = estoque;
		getContentPane().setLayout(null);
		setBounds(250,250,800,600);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 778, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPainelDoAdministrador = new JLabel("Painel do Administrador");
		lblPainelDoAdministrador.setBounds(292, 12, 194, 15);
		panel.add(lblPainelDoAdministrador);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 778, 417);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRetirarProdutos = new JButton("Retirar produtos");
		btnRetirarProdutos.setBounds(276, 90, 191, 25);
		panel_1.add(btnRetirarProdutos);
		
		JButton btnVerEstoque = new JButton("Ver estoque");
		btnVerEstoque.setBounds(276, 129, 191, 25);
		panel_1.add(btnVerEstoque);
		
		JButton btnC = new JButton("Cadastrar produtos");
		btnC.setBounds(276, 166, 191, 25);
		panel_1.add(btnC);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(301, 201, 117, 25);
		panel_1.add(btnVoltar);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	 public File getImageFile() {
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	        int result = fileChooser.showOpenDialog(null);
	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            return selectedFile;
	        } else {
	            JOptionPane.showMessageDialog(fileChooser, "Nenhum arquivo selecionado!");
	            return null;
	        }
    }
	 public static void selectImageFile() {
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	        int result = fileChooser.showSaveDialog(null);
	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            createFile(selectedFile);
	        } else {
	            JOptionPane.showMessageDialog(fileChooser, "Nenhum diretório selecionado!");
	        }
	    }

	    public static void createFile(File file) {
	        try {
	            if (file.createNewFile()) {
	                FileWriter writer = new FileWriter(file);
	                writer.write("Conteúdo do arquivo.");
	                writer.close();
	                JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso em: " + file.getAbsolutePath());
	            } else {
	                JOptionPane.showMessageDialog(null, "O arquivo já existe.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void showPainelAdm() {
		 setVisible(true);
	 }
}
