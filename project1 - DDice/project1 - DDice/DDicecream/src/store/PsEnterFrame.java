package store;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PsEnterFrame {

	private Store store;

	public PsEnterFrame(Store store) {
		this.store = store;
	}

	public void create() {
		JFrame psEnterFrame = new JFrame();
		psEnterFrame = new JFrame();
		psEnterFrame.setTitle("psEnter");
		psEnterFrame.setSize(380, 150);
		psEnterFrame.setLocation(580, 400);
		psEnterFrame.setResizable(false);

		JPanel PsEnter = createPsEnterPanel();
		psEnterFrame.add(PsEnter);

		psEnterFrame.setVisible(true);

	}

	// 비밀번호 입력받는 페널
	private JPanel createPsEnterPanel() {

		JPanel psEnterPanel = new JPanel();
		psEnterPanel.setBackground(Color.WHITE);

		JLabel jl1 = new JLabel("비밀번호 입력 : ");
		jl1.setFont(new Font("맑은고딕", Font.BOLD, 15));

		TextField psEnter = new TextField(10);
		psEnter.setFont(new Font("", Font.BOLD, 15));

		JButton psButton = new JButton("확인");
		psButton.setBackground(Color.WHITE);
		psButton.setFont(new Font("맑은고딕", Font.BOLD, 15));

		psButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (psEnter.getText().isEmpty()) {
					JOptionPane.showMessageDialog(psEnterPanel, "비밀번호를 입력하십시오", "", JOptionPane.OK_OPTION);
				} else {
					PsEnterFrame.this.store.showStore();
					PsEnterFrame.this.store.setPs(psEnter.getText());
				}
			}
		});

		psEnterPanel.add(jl1);
		psEnterPanel.add(psEnter);
		psEnterPanel.add(psButton);

		return psEnterPanel;
	}

}
