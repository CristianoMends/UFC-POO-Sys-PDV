package pdv.view;

import javax.swing.JPanel;

import pdv.model.enums.Cor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CaixasView extends JPanel{
	
	public CaixasView() {
		setSize(790, 590);
		setBackground(Cor.AzulDodger.getColor());
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(478, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(313, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
