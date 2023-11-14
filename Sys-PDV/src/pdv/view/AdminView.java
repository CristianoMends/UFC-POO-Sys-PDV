package pdv.view;

import java.awt.Dimension;
import java.awt.Toolkit;
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
		super("");
		this.estoque = estoque;
		getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) ((screenSize.getWidth() - 800) / 2);
        int centerY = (int) ((screenSize.getHeight() - 600) / 2);
		//setBounds(centerX,centerY,800,600);
		setBounds(100,50,800,600);
		
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
		
		JButton btnGerenciarProdutos = new JButton("Gerenciar produtos");
		btnGerenciarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGerenciarProdutos.setBounds(276, 90, 191, 25);
		panel_1.add(btnGerenciarProdutos);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(276, 164, 191, 25);
		panel_1.add(btnVender);
		
		JButton btnGerenciarCaixas = new JButton("Gerenciar caixas");
		btnGerenciarCaixas.setBounds(276, 127, 191, 25);
		panel_1.add(btnGerenciarCaixas);
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
