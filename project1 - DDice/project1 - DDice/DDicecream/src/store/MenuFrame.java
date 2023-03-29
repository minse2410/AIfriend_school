package store;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MenuFrame { // JLabel
	private IceMenu iceMenu;
	private JFrame menuFrame;

	public MenuFrame(IceMenu iceMenu) {
		this.iceMenu = iceMenu;
	}

	public void redrawMenu() {
		JPanel menePanel = createMenuPanel();
		
		Container pane = menuFrame.getContentPane();
		pane.remove(0);
		pane.add(menePanel);
		pane.revalidate();
		pane.repaint();
	}
	
	public void showMenu() {
		menuFrame.setVisible(true);
	}

	public void create() {
		menuFrame = new JFrame();
		menuFrame.setTitle("menu");
		menuFrame.setSize(815, 500);
		menuFrame.setLocation(350, 60);
		menuFrame.setResizable(false);
		menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel menuPanel = createMenuPanel();
		menuFrame.add(menuPanel);
		menuFrame.setVisible(false);

	}

	private JPanel createMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.LINE_AXIS));

		// 초코
		IceInfo[] chocoIceInfos = this.iceMenu.getChocoIceInfos();
		this.addIceInfosPanel(menuPanel, chocoIceInfos);

		// 딸기
		IceInfo[] strawIceInfos = this.iceMenu.getStrawIceInfos();
		this.addIceInfosPanel(menuPanel, strawIceInfos);
		// 녹차
		IceInfo[] greenIceInfos = this.iceMenu.getGreenIceInfos();
		this.addIceInfosPanel(menuPanel, greenIceInfos);

		// 바나나
		IceInfo[] bananaIceInfos = this.iceMenu.getBananaIceInfos();
		this.addIceInfosPanel(menuPanel, bananaIceInfos);

		return menuPanel;
	}

	private void addIceInfosPanel(JPanel menuPanel, IceInfo[] iceInfos) {
		JPanel tastePanel = new JPanel();
		tastePanel.setBackground(Color.WHITE);
		tastePanel.setAlignmentY(Component.TOP_ALIGNMENT);
		tastePanel.setPreferredSize(new Dimension(300,400));
		tastePanel.setLayout(new BoxLayout(tastePanel, BoxLayout.PAGE_AXIS));
		for (IceInfo iceInfo : iceInfos) {
			JLabel jlIceName = new JLabel(iceInfo.name);
			jlIceName.setFont(new Font("맑은고딕", Font.BOLD, 24));
			JLabel jlIcePrice = new JLabel(Integer.toString(iceInfo.price));
			jlIcePrice.setFont(new Font("맑은고딕", Font.BOLD, 19));
			tastePanel.add(jlIceName);
			tastePanel.add(jlIcePrice);
		}
		menuPanel.add(tastePanel);
	}


	
}