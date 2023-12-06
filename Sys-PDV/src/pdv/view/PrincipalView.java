package pdv.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pdv.controller.Pdv;
import pdv.model.enums.Cor;

public class PrincipalView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel backgroundLabel;
	private Dimension size;
	private JButton btnVender;
	private JButton btnAdministrar;
	private JPanel panel2;	

	public PrincipalView() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
				
		
		backgroundLabel = new JLabel(
				new ImageIcon(PrincipalView.class.getResource("/pdv/view/imagens/background.png")));
		backgroundLabel.setBounds(0, 0, 0, 0);

		JPanel panel = new JPanel();
		panel.setBackground(Cor.CinzaMedio.getColor());
		panel.setBounds(0, 0, 0, 0);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnVender = new JButton("Vender");
		btnVender.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVender.setToolTipText("Clique aqui para vender");
		btnVender.setBounds(10, 20, 100, 100);
		btnVender.setForeground(new Color(0, 0, 0));
		ImageIcon venderIcon = new ImageIcon(PrincipalView.class.getResource("/pdv/view/imagens/venda.png"));
		JLabel icon = new JLabel(imageResized(venderIcon, btnVender));
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVender.add(icon);
		panel.add(btnVender);

		btnAdministrar = new JButton("Gerenciar");
		btnAdministrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAdministrar.setToolTipText("Clique aqui para gerenciar");
		btnAdministrar.setBounds(120, 20, 120, 100);
		btnAdministrar.setForeground(new Color(0, 0, 0));
		ImageIcon AdminstrarIcon = new ImageIcon(PrincipalView.class.getResource("/pdv/view/imagens/adm.png"));
		JLabel icon2 = new JLabel(imageResized(AdminstrarIcon, btnAdministrar));
		icon2.setHorizontalAlignment(SwingConstants.CENTER);
		icon2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAdministrar.add(icon2);
		panel.add(btnAdministrar);

		panel2 = new JPanel();
		getPanel2().setBounds(0, 0, 10, 10);
		getPanel2().setOpaque(false);
		getPanel2().setLayout(null);
		getContentPane().add(getPanel2());
		getContentPane().add(backgroundLabel);
		ImageIcon icone = new ImageIcon(PrincipalView.class.getResource("/pdv/view/imagens/ponto-de-venda.png"));
        this.setIconImage(icone.getImage());

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				size = getContentPane().getSize();
				backgroundLabel.setSize(size);
				panel.setBounds(0, 0, (int) size.getWidth(), 150);
				getPanel2().setBounds(0, 151, (int) size.getWidth(), (int) (size.getHeight() - 150));
			}
		});
	}
	public ImageIcon imageResized(ImageIcon icon, JButton component) {
		int width = component.getWidth();
		int heigth = component.getHeight();
		Image imagemRedimensionada = icon.getImage().getScaledInstance(width - 50, heigth - 50, Image.SCALE_SMOOTH);
		return new ImageIcon(imagemRedimensionada);
	}


	public JButton getBtnVender() {
		return this.btnVender;
	}

	public JButton getBtnAdministrar() {
		return this.btnAdministrar;
	}

	public JFrame getFrame() {
		return this;
	}

	public JPanel getPanel2() {
		return panel2;
	}
	public void setEvents(TelaVendas telaVendas,AdmView admView) {		
		this.getBtnVender().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaVendas.estaVendendo()) {
					Pdv.showMensagem(getBtnVender(), "Finalize ou cancele a venda primeiro", "Aviso!", JOptionPane.WARNING_MESSAGE);
					return;
				}
				int x = (int) (getPanel2().getWidth() / 2) - (800 / 2);
	            int y = (int) (getPanel2().getHeight() / 2) - (600 / 2);			
				
	            getPanel2().removeAll();
	            getPanel2().revalidate();
	            getPanel2().repaint();
	            
				getPanel2().add(telaVendas);
				telaVendas.setBounds(x,y,790,590);
				telaVendas.setVisible(true);
			}
		});
		btnAdministrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!Pdv.verificarLogin(btnAdministrar)) {
            		return;
            	}
                if (telaVendas.estaVendendo()) {
                    Pdv.showMensagem(btnAdministrar, "Finalize ou cancele a venda primeiro", "Aviso!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int width = (int) (size.getWidth() - (size.getWidth() * 0.5));
                int height = (int) (size.getHeight() - (size.getHeight() * 0.3));
                int x = (int) (panel2.getWidth() / 2) - (width / 2);
                int y = (int) (panel2.getHeight() / 2) - (height / 2);

                panel2.removeAll();
                panel2.revalidate();
                panel2.repaint();

                panel2.add(admView);
                admView.setBounds(x, y, width, height);
                admView.setVisible(true);
            }
        });
	}
}
