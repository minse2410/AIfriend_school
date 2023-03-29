package store;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class ManageFrame {

	private JFrame manageFrame;
	private JPanel cards;
	private CardLayout cardLayout;
	private IceMenu iceMenu;
	private MenuFrame menu;
	private String ps;

	public ManageFrame(IceMenu iceMenu, MenuFrame menu, String ps) {
		this.iceMenu = iceMenu;
		this.menu = menu;
		this.ps = ps;
	}

	public void create() {
		manageFrame = new JFrame();
		manageFrame.setTitle("manage");
		manageFrame.setSize(500, 350);
		manageFrame.setLocation(660, 450);
		manageFrame.setResizable(false);

		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);

		JPanel managePs = createManagePanel();
		cards.add(managePs, "checkPs");

		JPanel managePanel = createmanagePanel();
		cards.add(managePanel, "manage");

		JPanel setPricePanel = createSetPricePanel();
		cards.add(setPricePanel, "setPrice");

		JPanel addMenuPanel = createAddMenuPanel();
		cards.add(addMenuPanel, "addMenu");

		cardLayout.show(cards, "checkPs");
		manageFrame.setVisible(true);
		manageFrame.add(cards);

	}

	
	private JPanel createManagePanel() {
		JPanel managePsPanel = new JPanel();
		managePsPanel.setBackground(Color.WHITE);
		String ps = this.ps;

		TextField psInput = new TextField(10);
		psInput.setFont(new Font("", Font.BOLD, 15));

		JButton checkPsButton = new JButton("확인");
		checkPsButton.setBackground(Color.WHITE);
		checkPsButton.setFont(new Font("맑은고딕", Font.BOLD, 15));

		checkPsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String userInputPs = psInput.getText();
				if (userInputPs.equals(ps)) {
					cardLayout.show(cards, "manage");
				} else {
					JOptionPane.showMessageDialog(managePsPanel, "비밀번호가 다릅니다.", "", JOptionPane.OK_OPTION);
				}

			}
		});

		managePsPanel.add(psInput);
		managePsPanel.add(checkPsButton);
//		managePsPanel.add();

		return managePsPanel;
	}

	// 변경 선택 panel
	private JPanel createmanagePanel() {
		JPanel managePanel = new JPanel();
		managePanel.setBackground(Color.WHITE);

		JButton setPriceButton = new JButton("가격변경");
		setPriceButton.setBackground(Color.WHITE);
		setPriceButton.setFont(new Font("맑은고딕", Font.BOLD, 15));

		setPriceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(cards, "setPrice");

			}
		});

		JButton addMenuButton = new JButton("메뉴추가");
		addMenuButton.setBackground(Color.WHITE);
		addMenuButton.setFont(new Font("맑은고딕", Font.BOLD, 15));

		addMenuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(cards, "addMenu");

			}
		});

		managePanel.add(setPriceButton);
		managePanel.add(addMenuButton);

		return managePanel;
	}

	// 가격변경 panel
	private JPanel createSetPricePanel() {
		JPanel setPricePanel = new JPanel();
		setPricePanel.setBackground(Color.WHITE);

		// 라디오버튼(아이스크림 종류 선택)
		ButtonGroup group = new ButtonGroup();
		JRadioButton barRadioButton = new JRadioButton("Bar가격 변경");
		barRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		barRadioButton.setBackground(Color.WHITE);
		group.add(barRadioButton);
		JRadioButton conRadioButton = new JRadioButton("Cone가격 변경");
		conRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		conRadioButton.setBackground(Color.WHITE);
		group.add(conRadioButton);
		JRadioButton cupRadioButton = new JRadioButton("Cup가격 변경");
		cupRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		cupRadioButton.setBackground(Color.WHITE);
		group.add(cupRadioButton);

		// 가격 입력 칸
		JLabel jl1 = new JLabel("변경할 가격 입력 : ");
		jl1.setFont(new Font("맑은고딕", Font.BOLD, 15));
		TextField tfNewIcePrice = new TextField(10);
		tfNewIcePrice.setFont(new Font("맑은고딕", Font.BOLD, 15));

		// 추가 완료 버튼
		JButton finishSetPrice = new JButton("가격 변경");
		finishSetPrice.setBackground(Color.WHITE);
		finishSetPrice.setFont(new Font("맑은고딕", Font.BOLD, 15));

		finishSetPrice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputPrice = tfNewIcePrice.getText();
				try {
					int price = Integer.parseInt(inputPrice);
					String kind = "";
					if (barRadioButton.isSelected()) {
						kind = "바";
					} else if (conRadioButton.isSelected()) {
						kind = "콘";
					} else if (cupRadioButton.isSelected()) {
						kind = "컵";
					}
					if (!kind.equals("")) {
						ManageFrame.this.iceMenu.changePrice(kind, price);
						// 메뉴프레임에 다시 그리라 함
						menu.redrawMenu();

						JOptionPane.showMessageDialog(setPricePanel, "가격 변경 완료.", "", JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(setPricePanel, "종류를 선택하세요.", "", JOptionPane.OK_OPTION);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(setPricePanel, "수만 입력하세요.", "에러", JOptionPane.OK_OPTION);
				}
			}
		});

		setPricePanel.add(barRadioButton);
		setPricePanel.add(conRadioButton);
		setPricePanel.add(cupRadioButton);
		setPricePanel.add(jl1);
		setPricePanel.add(tfNewIcePrice);
		setPricePanel.add(finishSetPrice);

		return setPricePanel;
	}

	// 메뉴 추가 panel
	private JPanel createAddMenuPanel() {
		JPanel addMenuPanel = new JPanel();
		addMenuPanel.setBackground(Color.WHITE);

		// 라디오버튼(아이스크림 종류 선택)
		ButtonGroup group = new ButtonGroup();
		JRadioButton barRadioButton = new JRadioButton("Bar종류 추가");
		barRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		barRadioButton.setBackground(Color.WHITE);
		group.add(barRadioButton);
		JRadioButton conRadioButton = new JRadioButton("Cone종류 추가");
		conRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		conRadioButton.setBackground(Color.WHITE);
		group.add(conRadioButton);
		JRadioButton cupRadioButton = new JRadioButton("Cup종류 추가");
		cupRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		cupRadioButton.setBackground(Color.WHITE);
		group.add(cupRadioButton);

		ButtonGroup group2 = new ButtonGroup();
		JRadioButton chocoRadioButton = new JRadioButton("초코맛 추가");
		chocoRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		chocoRadioButton.setBackground(Color.WHITE);
		group2.add(chocoRadioButton);
		JRadioButton strawRadioButton = new JRadioButton("딸기맛 추가");
		strawRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		strawRadioButton.setBackground(Color.WHITE);
		group2.add(strawRadioButton);
		JRadioButton greenRadioButton = new JRadioButton("녹차맛 추가");
		greenRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		greenRadioButton.setBackground(Color.WHITE);
		group2.add(greenRadioButton);
		JRadioButton bananaRadioButton = new JRadioButton("바나나맛 추가");
		bananaRadioButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		bananaRadioButton.setBackground(Color.WHITE);
		group2.add(bananaRadioButton);

		// 메뉴 입력칸(메뉴 이름 : 이름 입력)
		JLabel jl1 = new JLabel("제품의 입력 : ");
		jl1.setFont(new Font("맑은고딕", Font.BOLD, 15));
		TextField tfNewIceName = new TextField(10);
		tfNewIceName.setFont(new Font("맑은고딕", Font.BOLD, 15));

		// 추가 완료 버튼
		JButton finishAddMenu = new JButton("메뉴 추가");
		finishAddMenu.setBackground(Color.WHITE);
		finishAddMenu.setFont(new Font("맑은고딕", Font.BOLD, 15));

		finishAddMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputName = tfNewIceName.getText();

				String kind = "";
				String taste = "";
				if (barRadioButton.isSelected()) {
					kind = "바";
				} else if (conRadioButton.isSelected()) {
					kind = "콘";
				} else if (cupRadioButton.isSelected()) {
					kind = "컵";
				}
				if (chocoRadioButton.isSelected()) {
					taste = "초코";
				} else if (strawRadioButton.isSelected()) {
					taste = "딸기";
				} else if (greenRadioButton.isSelected()) {
					taste = "녹차";
				} else if (bananaRadioButton.isSelected()) {
					taste = "바나나";
				}
				if (!kind.equals("")) {
					ManageFrame.this.iceMenu.addMenu(taste, inputName, kind);
					// 메뉴프레임에 다시 그리라 함
					menu.redrawMenu();

					JOptionPane.showMessageDialog(addMenuPanel, "메뉴 추가 완료.", "", JOptionPane.OK_OPTION);
				} else {
					JOptionPane.showMessageDialog(addMenuPanel, "종류를 선택하세요.", "", JOptionPane.OK_OPTION);
					//실행x , 가격 바꾸고 메뉴 추가하면 가격 변경 안됨
				}

			}
		});

		addMenuPanel.add(barRadioButton);
		addMenuPanel.add(conRadioButton);
		addMenuPanel.add(cupRadioButton);
		addMenuPanel.add(chocoRadioButton);
		addMenuPanel.add(strawRadioButton);
		addMenuPanel.add(greenRadioButton);
		addMenuPanel.add(bananaRadioButton);
		addMenuPanel.add(jl1);
		addMenuPanel.add(tfNewIceName);
		addMenuPanel.add(finishAddMenu);

		return addMenuPanel;
	}
}
