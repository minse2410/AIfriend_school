package store;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

import javax.naming.SizeLimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import org.w3c.dom.Text;

import javax.swing.JTextField;
import javax.swing.ListModel;

public class Store {

	// 고른 맛,종류 저장
	private JPanel cards;
	private String chooseTaste; 
	private String chooseKind;
	private int priceSum;

	// 아이스크림메뉴
	private IceMenu iceMenu = new IceMenu();
	private DefaultListModel recommendListModel = new DefaultListModel();

	// 선택 list
	private List<JCheckBox> checks = new ArrayList<>();
	private DefaultListModel chooseIceListModel = new DefaultListModel();
	private CardLayout cardLayout;

	private JLabel jl1 = new JLabel("합계 금액 : " + priceSum);
	private JLabel changeLabel = new JLabel("");
	private JFrame frame;

	private TextField payInput;
	
	private MenuFrame menu;
	private PsEnterFrame psEnter;
	private String ps;
	
	public void showStore() {
		frame.setVisible(true);
		menu.showMenu();
	}
	
	public void setPs(String ps) {
		this.ps = ps;
	}

	public void start() {

		frame = new JFrame();
		frame.setTitle("아이스크림 가게");
		frame.setSize(815, 280);
		frame.setLocation(350, 550); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());

		// 상단 메뉴 화면 생성
		JPanel topMenuPanel = createTopMenu();
		container.add(topMenuPanel, BorderLayout.NORTH);

		// 주문 처리하는 화면 생성
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);

		// 메뉴 보여주는 프레임
		this.menu = new MenuFrame(this.iceMenu);
		menu.create();
		
		//페시워드 입력받는 프레임
		this.psEnter = new PsEnterFrame(this);
		psEnter.create();

		// panel
		JPanel startPanel = createStartPanel();
		cards.add(startPanel, "start");

		JPanel tastePanel = createTastePanel();
		cards.add(tastePanel, "taste");

		JPanel kindPanel = createKindPanel();
		cards.add(kindPanel, "kind");

		JPanel recommendPanel = createRecommendPanel();
		cards.add(recommendPanel, "recommend");

		JPanel iceOrderPanel = createIceOrderPanel();
		cards.add(iceOrderPanel, "iceOrder");

		JPanel icePayPanel = createIcePayPanel();
		cards.add(icePayPanel, "icePay");

		JPanel finalPanel = createFinalPanel();
		cards.add(finalPanel, "final");

		container.add(cards, BorderLayout.CENTER);

		cardLayout.show(cards, "start");
		frame.setVisible(false);
	}

	// 홈버튼 페널
	private JPanel createTopMenu() {

		JPanel topMenuPanel = new JPanel();
		topMenuPanel.setBackground(Color.WHITE);


		JButton homeButton = new JButton("HOME");
		homeButton.setBackground(Color.WHITE);
		homeButton.setFont(new Font("맑은고딕", Font.BOLD, 15));

		//홈버튼
		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 체크박스에 체크 초기화
				for (int i = 0; i < checks.size(); i++) {
					JCheckBox jCheckBox = checks.get(i);
					jCheckBox.setSelected(false);
				}

				// home -> 초기화
				chooseIceListModel.clear();
				priceSum = 0;
				payInput.setText("");
				recommendListModel.clear();

				cardLayout.show(cards, "start");

			}
		});
		
		//관리자 모드 버튼
		JButton manageButton = new JButton("관리자 모드");
		manageButton.setBackground(Color.WHITE);
		manageButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		
		manageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ManageFrame manage = new ManageFrame(Store.this.iceMenu, Store.this.menu, Store.this.ps);
				manage.create();
			}
		});

		topMenuPanel.add(homeButton);
		topMenuPanel.add(manageButton);

		return topMenuPanel;
	}

	
	// panel : 첫화면
	private JPanel createStartPanel() {
		
		//배경
		JPanel startPanel = new JPanel() {
			Image background = new ImageIcon(StoreMain.class.getResource("../images/BackGround.jpg")).getImage();

			public void paintComponent(Graphics g) {// 그리는 함수
				g.drawImage(background, 0, -120, null);// background를 그려줌
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		startPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));  //JButton 위치 조정
		
		// 버튼 : 추천받으러 가기
		JButton goTasteButton = new JButton("추천 받으러 가기");
		goTasteButton.setBackground(Color.WHITE);
		goTasteButton.setForeground(new Color(0, 0, 0));
		goTasteButton.setPreferredSize(new Dimension(200, 100));
		goTasteButton.setFont(new Font("맑은고딕", Font.BOLD, 20));
		startPanel.add(goTasteButton);

		//action : 맛 고르는 페널로
		goTasteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "taste");
			}
		});

		// 버튼 : 바로 주문하러 가기
		JButton goOrderButton = new JButton("주문하러 가기");
		startPanel.add(goOrderButton);
		goOrderButton.setBackground(Color.WHITE);
		goOrderButton.setPreferredSize(new Dimension(200, 100));
		goOrderButton.setForeground(new Color(0, 0, 0));
		goOrderButton.setFont(new Font("맑은고딕", Font.BOLD, 20));

		//action : 메뉴 체크페널로
		goOrderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				redrawIceOrderPanel();
				cardLayout.show(cards, "iceOrder");
			}
		});

		return startPanel;
	}

	
	// panel : 맛 고르기
	private JPanel createTastePanel() {
		JPanel tastePanel = new JPanel() {
			Image background = new ImageIcon(StoreMain.class.getResource("../images/BackGround.jpg")).getImage();

			public void paintComponent(Graphics g) {
				g.drawImage(background, 0, -120, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
		tastePanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

		//Button 4개 (for써서)
		String[] tastes = iceMenu.getTastes();
		for (int i = 0; i < tastes.length; i++) {
			String taste = tastes[i];
			JButton goKindButton = new JButton(taste);
			goKindButton.setPreferredSize(new Dimension(150, 75));
			goKindButton.setFont(new Font("맑은고딕", Font.BOLD, 20));
			
			//Button 색지정 (if써서)
			if (i == 0) {
				goKindButton.setBackground(new Color(255, 204, 153));
			} else if (i == 1) {
				goKindButton.setBackground(new Color(255, 204, 255));
			} else if (i == 2) {
				goKindButton.setBackground(new Color(204, 255, 153));
			} else {
				goKindButton.setBackground(new Color(255, 255, 204));
			}
			tastePanel.add(goKindButton);

			goKindButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					chooseTaste = taste;   //필드에 맛 고른 정보 넣음
					cardLayout.show(cards, "kind");
				}
			});
		}
		return tastePanel;
	}

	// panel : 종류 고르기
	private JPanel createKindPanel() {
		JPanel kindPanel = new JPanel() {
			Image background = new ImageIcon(StoreMain.class.getResource("../images/BackGround.jpg")).getImage();

			public void paintComponent(Graphics g) {// 
				g.drawImage(background, 0, -120, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		kindPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

		//Button 3개 (for써서)
		String kinds[] = iceMenu.getKinds();
		for (int i = 0; i < kinds.length; i++) {
			String kind = kinds[i];
			JButton goRecommendButton = new JButton(kind);
			goRecommendButton.setPreferredSize(new Dimension(150, 75));
			goRecommendButton.setBackground(Color.WHITE);
			goRecommendButton.setFont(new Font("맑은고딕", Font.BOLD, 20));
			kindPanel.add(goRecommendButton);

			goRecommendButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					chooseKind = kind;
					cardLayout.show(cards, "recommend");

					// 추천목록을 list에 저장
					IceInfo[] infos = iceMenu.recommend(chooseTaste, chooseKind);
					for (int j = 0; j < infos.length; j++) {
						IceInfo info = infos[j];
						if (info != null) {
							recommendListModel.addElement(info.name);
						}
					}
				}
			});
		}
		return kindPanel;
	}

	// panel : 추천
	private JPanel createRecommendPanel() {
		JPanel recommendPanel = new JPanel() {
			Image background = new ImageIcon(StoreMain.class.getResource("../images/BackGround.jpg")).getImage();

			public void paintComponent(Graphics g) {
				g.drawImage(background, 0, -120, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
		
		JButton goIcecreamChooseButton = new JButton("주문하러 가기");
		goIcecreamChooseButton.setPreferredSize(new Dimension(135, 36));
		goIcecreamChooseButton.setBackground(Color.WHITE);
		goIcecreamChooseButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		recommendPanel.add(goIcecreamChooseButton);

		//action : 주문 체크박스 가기
		goIcecreamChooseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				redrawIceOrderPanel();
				cardLayout.show(cards, "iceOrder");
			}
		});

		// 추천해주는 코드
		JList recommendList = new JList(recommendListModel);
		recommendList.setFont(new Font("맑은고딕",Font.BOLD, 15));
		recommendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		recommendList.setLayoutOrientation(JList.VERTICAL);
		recommendList.setVisibleRowCount(-1);

		//scroller
		JScrollPane listScroller = new JScrollPane(recommendList);
		listScroller.setPreferredSize(new Dimension(350, 130));

		recommendPanel.add(listScroller);
		return recommendPanel;
	}
	
	//
	private void redrawIceOrderPanel() {
		checks.clear();
		
		JPanel iceOrderPanel = new JPanel();
		iceOrderPanel.setLayout(new BoxLayout(iceOrderPanel, BoxLayout.LINE_AXIS));

		// 초코
		IceInfo[] chocoIceInfos = this.iceMenu.getChocoIceInfos();
		this.addIceInfosPanel(iceOrderPanel, chocoIceInfos);

		// 딸기
		IceInfo[] strawIceInfos = this.iceMenu.getStrawIceInfos();
		this.addIceInfosPanel(iceOrderPanel, strawIceInfos);
		// 녹차
		IceInfo[] greenIceInfos = this.iceMenu.getGreenIceInfos();
		this.addIceInfosPanel(iceOrderPanel, greenIceInfos);

		// 바나나
		IceInfo[] bananaIceInfos = this.iceMenu.getBananaIceInfos();
		this.addIceInfosPanel(iceOrderPanel, bananaIceInfos);
		
		orderPanel.remove(0);
		orderPanel.add(iceOrderPanel, 0);
		orderPanel.revalidate();
		orderPanel.repaint();
	}
	
	JPanel orderPanel; //panel 필드로 뺌
	// panel : 시키기
	private JPanel createIceOrderPanel() {
		orderPanel = new JPanel();
		orderPanel.setBackground(Color.WHITE);
		
		JPanel iceOrderPanel = new JPanel();
		iceOrderPanel.setLayout(new BoxLayout(iceOrderPanel, BoxLayout.LINE_AXIS));

		// 초코
		IceInfo[] chocoIceInfos = this.iceMenu.getChocoIceInfos();
		this.addIceInfosPanel(iceOrderPanel, chocoIceInfos);

		// 딸기
		IceInfo[] strawIceInfos = this.iceMenu.getStrawIceInfos();
		this.addIceInfosPanel(iceOrderPanel, strawIceInfos);
		// 녹차
		IceInfo[] greenIceInfos = this.iceMenu.getGreenIceInfos();
		this.addIceInfosPanel(iceOrderPanel, greenIceInfos);

		// 바나나
		IceInfo[] bananaIceInfos = this.iceMenu.getBananaIceInfos();
		this.addIceInfosPanel(iceOrderPanel, bananaIceInfos);

		orderPanel.add(iceOrderPanel);

		JButton goOrderButton = new JButton("결제하러가기");
		goOrderButton.setBackground(Color.WHITE);
		goOrderButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		orderPanel.add(goOrderButton);
		
		goOrderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < checks.size(); i++) {
					JCheckBox checkBox = checks.get(i);
					if (checkBox.isSelected()) {
						IceInfo iceInfo = iceMenu.find(checkBox.getText());
						priceSum += iceInfo.price;
						chooseIceListModel.addElement(checkBox.getText() + "  :  " + iceInfo.price);
					}
				}
				jl1.setText("합계 금액 : " + priceSum);
				cardLayout.show(cards, "icePay");

			}
		});
		return orderPanel;
	}

	// 체크박스 만드는 코드
	private void addIceInfosPanel(JPanel iceOrderPanel, IceInfo[] iceInfos) {
		JPanel tasteJpanel = new JPanel();
		tasteJpanel.setLayout(new BoxLayout(tasteJpanel, BoxLayout.PAGE_AXIS));
		for (int i = 0; i < iceInfos.length; i++) {
			JCheckBox check = new JCheckBox(iceInfos[i].name);
			check.setFont(new Font("맑은고딕" , Font.BOLD, 14));
			check.setPreferredSize(new Dimension(115, 25));
			tasteJpanel.add(check);
			checks.add(check);
		}
		tasteJpanel.setAlignmentY(Component.TOP_ALIGNMENT);
		iceOrderPanel.add(tasteJpanel);
	}

	// panel : 계산하기
	private JPanel createIcePayPanel() {
		JPanel payPanel = new JPanel() {
			Image background = new ImageIcon(StoreMain.class.getResource("../images/BackGround.jpg")).getImage();

			public void paintComponent(Graphics g) {
				g.drawImage(background, 0, -120, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		// 선택한 아이스크림 보여주기
		JList chooseIceList = new JList(chooseIceListModel);
		chooseIceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chooseIceList.setLayoutOrientation(JList.VERTICAL);
		chooseIceList.setVisibleRowCount(-1);
		chooseIceList.setFont(new Font("맑은고딕" , Font.BOLD, 17));

		//scroller
		JScrollPane listScroller = new JScrollPane(chooseIceList);
		listScroller.setPreferredSize(new Dimension(250, 110));

		payPanel.add(listScroller);
		
		JPanel showTextPanel = new JPanel();  // 정렬 위한 페널
		showTextPanel.setBackground(Color.WHITE);
	
		showTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		showTextPanel.setPreferredSize(new Dimension(185,120));

		// 얼마인지 보여주기
		jl1.setFont(new Font("맑은고딕" , Font.BOLD, 17));
		showTextPanel.add(jl1);
		JLabel jl2 = new JLabel("돈 입력");
		jl2.setPreferredSize(new Dimension(100,17));
		jl2.setFont(new Font("맑은고딕" , Font.BOLD, 17));
		showTextPanel.add(jl2);

		// 금액 입력받기
		payInput = new TextField(10);
		payInput.setFont(new Font("", Font.BOLD, 15));
		showTextPanel.add(payInput);

		// 계산 버튼
		JButton calculationDoneButton = new JButton("계산하기");
		calculationDoneButton.setBackground(Color.WHITE);
		calculationDoneButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
		showTextPanel.add(calculationDoneButton);

		payPanel.add(showTextPanel);

		// action : 잔돈 나오게
		calculationDoneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int putMoney = Integer.parseInt(payInput.getText());
				int changeMoney = putMoney - priceSum;
				if (priceSum <= putMoney) {
					changeLabel.setText("잔돈 : " + changeMoney + "원");
					changeLabel.setFont(new Font("맑은고딕", Font.PLAIN, 26));
					cardLayout.show(cards, "final");
				} else {
					JOptionPane.showMessageDialog(frame, "금액이 부족합니다.", "오류", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		return payPanel;
	}

	// 결제완료 페널
	private JPanel createFinalPanel() {
		JPanel finalPanel = new JPanel();
		finalPanel.setBackground(Color.WHITE);
		
		JPanel innerPanel = new JPanel();
		innerPanel.setBackground(Color.WHITE);
		innerPanel.setPreferredSize(new Dimension(200,100));

		JLabel text1 = new JLabel("결재완료");
		text1.setFont(new Font("맑은고딕", Font.BOLD, 45));
		innerPanel.add(text1);

		innerPanel.add(changeLabel);
		finalPanel.add(innerPanel);
		
		return finalPanel;
	}

}
