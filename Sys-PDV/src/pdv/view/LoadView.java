package pdv.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class LoadView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;

	public LoadView() {
		getContentPane().setLayout(null);
		JLabel lblCarregando = new JLabel("Carregando");
		lblCarregando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarregando.setBounds(0, 0, 500, 200);
		getContentPane().add(lblCarregando);

		progressBar = new JProgressBar(0, 100);
		progressBar.setForeground(new Color(0, 0, 0));
		progressBar.setBounds(0, 0, 500, 200);
		progressBar.setStringPainted(true);
		getContentPane().add(progressBar);

		setSize(500, 200);
		setLocationRelativeTo(null);
		setUndecorated(true);		
		setVisible(true);
	}

	private void carregar(PrincipalView frame) {
		Timer timer = new Timer(50, new ActionListener() {
			int progresso = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				progresso += 5;
				progressBar.setValue(progresso);

				if (progresso >= 100) {
					((Timer) e.getSource()).stop();
					dispose();
					new Login(null, frame);
				}
			}
		});

		timer.start();
	}
	public void setAcoes(PrincipalView frame) {
		carregar(frame);
	}
}
