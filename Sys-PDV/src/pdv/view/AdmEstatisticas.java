package pdv.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import pdv.controller.Pdv;
import pdv.model.entidades.Produto;
import pdv.model.enums.Cor;

public class AdmEstatisticas extends JPanel{
    private JTable table1;
    private JTable table2;
    private JTable table4;

	public AdmEstatisticas() {
		setSize(790, 454);
		setBackground(Cor.AzulDodger.getColor());
		
		JPanel panel1 = new JPanel();
		
		JLabel lblNewLabel = new JLabel("Estatísticas Gerais");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JPanel panel2 = new JPanel();
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 390, Short.MAX_VALUE)
				.addGroup(gl_panel2.createSequentialGroup()
					.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 84, Short.MAX_VALUE)
				.addGroup(gl_panel2.createSequentialGroup()
					.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel2.setLayout(gl_panel2);
		
		JPanel panel4 = new JPanel();
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel4 = new GroupLayout(panel4);
		gl_panel4.setHorizontalGroup(
			gl_panel4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 390, Short.MAX_VALUE)
				.addGroup(gl_panel4.createSequentialGroup()
					.addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel4.setVerticalGroup(
			gl_panel4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 84, Short.MAX_VALUE)
				.addGroup(gl_panel4.createSequentialGroup()
					.addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel4.setLayout(gl_panel4);
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		JLabel lblNewLabel_1 = new JLabel("Faturamento Total");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Vendas Mensais por vendedor");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Produtos em falta");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(199)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(201, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
							.addComponent(btnAtualizar)
							.addGap(352))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(2)
					.addComponent(lblNewLabel_1)
					.addGap(2)
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(2)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addGap(2)
					.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnAtualizar)
					.addContainerGap(47, Short.MAX_VALUE))
		);
				
		JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table1 = new JTable();
        table1.setEnabled(false);
        table1.setFont(new Font("Dialog", Font.PLAIN, 11));
        table1.setForeground(Cor.BrancoPuro.getColor());
        table1.setBackground(Cor.CinzaMedio.getColor());
        scrollPane1.setViewportView(table1);


        table2 = new JTable();
        table2.setEnabled(false);
        table2.setFont(new Font("Dialog", Font.PLAIN, 11));
        table2.setForeground(Cor.BrancoPuro.getColor());
        table2.setBackground(Cor.CinzaMedio.getColor());
        scrollPane2.setViewportView(table2);

        table4 = new JTable();
        table4.setEnabled(false);
        table4.setFont(new Font("Dialog", Font.PLAIN, 11));
        table4.setForeground(Cor.BrancoPuro.getColor());
        table4.setBackground(Cor.CinzaMedio.getColor());
        scrollPane4.setViewportView(table4);
        
        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Dia Atual");
        model1.addColumn("Mês atual");
        table1.setModel(model1);
        
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("ID");
        model2.addColumn("Nome");
        model2.addColumn("Total Vendido");
        model2.addColumn(model2);
        table2.setModel(model2);
        
        DefaultTableModel model3 = new DefaultTableModel();
        model3.addColumn("Dia Atual");
        model3.addColumn("Mês atual");
        
        DefaultTableModel model4 = new DefaultTableModel();
        model4.addColumn("ID");
        model4.addColumn("Nome");
        model4.addColumn("Preço");
        model4.addColumn("QtdEstoque");
        model4.addColumn("Categoria");
        table4.setModel(model4);
        
        
        
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel1.setLayout(gl_panel1);
		setLayout(groupLayout);
		atualizarTabelas();
		btnAtualizar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarTabelas();				
			}
		});
	}
	
	 private void atualizarTabelas() {
		 	DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
	        model1.setRowCount(0);
	        Object[] rowData1 = Pdv.estDao.getTotaisVendasDiaMes();
	        model1.addRow(rowData1);
	        
		 	DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
	        model2.setRowCount(0);
            List<Object[]> row = Pdv.estDao.getTotVendidos();
            for(Object[] o : row) {
            	model2.addRow(o);
            }
            
            DefaultTableModel model4 = (DefaultTableModel) table4.getModel();
            model4.setRowCount(0);
            List<Produto> produtosEmFalta = Pdv.estDao.getProdutosEmFalta();
            
            for (Produto produto : produtosEmFalta) {
	            Object[] rowData = {produto.getId(), produto.getNome(), produto.getPreco(), produto.getQtdEstoque(), produto.getCategoria()};
	            model4.addRow(rowData);
	        }
	}
}
