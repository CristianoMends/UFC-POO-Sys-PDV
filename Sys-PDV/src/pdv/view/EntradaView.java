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
import java.awt.Color;
import java.awt.Font;

public class EntradaView extends JFrame {

    private JProgressBar progressBar;

    public EntradaView(AdminView adminView) {
    	getContentPane().setLayout(null);
        JLabel labelBoasVindas = new JLabel("Bem-vindo");
        labelBoasVindas.setFont(new Font("Dialog", Font.BOLD, 14));
        labelBoasVindas.setBounds(0, 0, 500, 100);
        labelBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().add(labelBoasVindas);
        
        JLabel lblCarregando = new JLabel("Carregando");
        lblCarregando.setHorizontalAlignment(SwingConstants.CENTER);
        lblCarregando.setBounds(10, 100, 351, 100);
        getContentPane().add(lblCarregando);
        
                progressBar = new JProgressBar(0, 100);
                progressBar.setForeground(new Color(0, 0, 0));
                progressBar.setBounds(0, 101, 500, 99);
                progressBar.setStringPainted(true);
                getContentPane().add(progressBar);

        setSize(500, 200);
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
                    new Login(null,adminView);
                }
            }
        });

        timer.start();
    }
}
