package pdv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class EntradaView extends JFrame {

    private JProgressBar progressBar;

    public EntradaView(AdminView adminView) {
    	getContentPane().setLayout(null);
        JLabel labelBoasVindas = new JLabel("Bem-vindo");
        labelBoasVindas.setBounds(0, 0, 500, 100);
        labelBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().add(labelBoasVindas);

        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(0, 101, 500, 75);
        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);

        setSize(500, 250);
        setLocationRelativeTo(null);
        setUndecorated(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                simularCarregamento(adminView);
            }
        });
        setVisible(true);
    }

    private void simularCarregamento(AdminView adminView) {
        Timer timer = new Timer(50, new ActionListener() {
            int progresso = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progresso += 2;
                progressBar.setValue(progresso);

                if (progresso >= 100) {
                    ((Timer) e.getSource()).stop();
                    dispose();
                    while(true) {
                    	if(VendasView.exibirTelaLogin()) {
                            adminView.showAdminView();
                            break;
                    	}
                    }
                }
            }
        });

        timer.start();
    }
}
