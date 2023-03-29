package store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IceMenu_AddMenu_Test {
	
	@Test
	void duplicateName() {
		IceMenu iceMenu = new IceMenu();
		assertDupCheck(iceMenu, "쵸코바");
		assertDupCheck(iceMenu, "딸기거품");
		assertDupCheck(iceMenu, "비밀의 숲");
		assertDupCheck(iceMenu, "바나바");
	}

	private void assertDupCheck(IceMenu iceMenu, String name) {
		IllegalArgumentException realEx = null;
		try{
			iceMenu.addMenu("초코", name, IceKind.BAR);
		}catch (IllegalArgumentException ex) {
			realEx = ex;
		}
		Assertions.assertNotNull(realEx);
	}
	
	@Test
	void choco_bar() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] chocoIceInfos1 = iceMenu.getChocoIceInfos();

		iceMenu.addMenu("초코", "이름2", "바");
		IceInfo[] chocoIceInfos2 = iceMenu.getChocoIceInfos();
		Assertions.assertEquals(chocoIceInfos1.length + 1, chocoIceInfos2.length);
		IceInfo iceInfo = chocoIceInfos2[chocoIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(800, iceInfo.price);
	}

	@Test
	void choco_con() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] chocoIceInfos1 = iceMenu.getChocoIceInfos();

		iceMenu.addMenu("초코", "이름2", "콘");
		IceInfo[] chocoIceInfos2 = iceMenu.getChocoIceInfos();
		Assertions.assertEquals(chocoIceInfos1.length + 1, chocoIceInfos2.length);
		IceInfo iceInfo = chocoIceInfos2[chocoIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(1200, iceInfo.price);
	}

	@Test
	void choco_cup() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] chocoIceInfos1 = iceMenu.getChocoIceInfos();

		iceMenu.addMenu("초코", "이름2", "컵");
		IceInfo[] chocoIceInfos2 = iceMenu.getChocoIceInfos();
		Assertions.assertEquals(chocoIceInfos1.length + 1, chocoIceInfos2.length);
		IceInfo iceInfo = chocoIceInfos2[chocoIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(2000, iceInfo.price);
	}

	@Test
	void strawberry_bar() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] strawIceInfos1 = iceMenu.getStrawIceInfos();

		iceMenu.addMenu("딸기", "이름2", "바");
		IceInfo[] strawIceInfos2 = iceMenu.getStrawIceInfos();
		Assertions.assertEquals(strawIceInfos1.length + 1, strawIceInfos2.length);
		IceInfo iceInfo = strawIceInfos2[strawIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(800, iceInfo.price);
	}
	
	@Test
	void strawberry_con() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] strawIceInfos1 = iceMenu.getStrawIceInfos();

		iceMenu.addMenu("딸기", "이름2", "콘");
		IceInfo[] strawIceInfos2 = iceMenu.getStrawIceInfos();
		Assertions.assertEquals(strawIceInfos1.length + 1, strawIceInfos2.length);
		IceInfo iceInfo = strawIceInfos2[strawIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(1200, iceInfo.price);
	}
	
	@Test
	void strawberry_cup() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] strawIceInfos1 = iceMenu.getStrawIceInfos();

		iceMenu.addMenu("딸기", "이름2", "컵");
		IceInfo[] strawIceInfos2 = iceMenu.getStrawIceInfos();
		Assertions.assertEquals(strawIceInfos1.length + 1, strawIceInfos2.length);
		IceInfo iceInfo = strawIceInfos2[strawIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(2000, iceInfo.price);
	}
	
	@Test
	void greentea_bar() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] greenIceInfos1 = iceMenu.getGreenIceInfos();

		iceMenu.addMenu("녹차", "이름2", "바");
		IceInfo[] greenIceInfos2 = iceMenu.getGreenIceInfos();
		Assertions.assertEquals(greenIceInfos1.length + 1, greenIceInfos2.length);
		IceInfo iceInfo = greenIceInfos2[greenIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(800, iceInfo.price);
	}
	@Test
	void greentea_con() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] greenIceInfos1 = iceMenu.getGreenIceInfos();

		iceMenu.addMenu("녹차", "이름2", "콘");
		IceInfo[] greenIceInfos2 = iceMenu.getGreenIceInfos();
		Assertions.assertEquals(greenIceInfos1.length + 1, greenIceInfos2.length);
		IceInfo iceInfo = greenIceInfos2[greenIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(1200, iceInfo.price);
	}
	@Test
	void greentea_cup() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] greenIceInfos1 = iceMenu.getGreenIceInfos();

		iceMenu.addMenu("녹차", "이름2", "컵");
		IceInfo[] greenIceInfos2 = iceMenu.getGreenIceInfos();
		Assertions.assertEquals(greenIceInfos1.length + 1, greenIceInfos2.length);
		IceInfo iceInfo = greenIceInfos2[greenIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(2000, iceInfo.price);
	}

	@Test
	void banana_bar() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] bananaIceInfos1 = iceMenu.getBananaIceInfos();

		iceMenu.addMenu("바나나", "이름2", "바");
		IceInfo[] bananaIceInfos2 = iceMenu.getBananaIceInfos();
		Assertions.assertEquals(bananaIceInfos1.length + 1, bananaIceInfos2.length);
		IceInfo iceInfo = bananaIceInfos2[bananaIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(800, iceInfo.price);
	}
	
	@Test
	void banana_con() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] bananaIceInfos1 = iceMenu.getBananaIceInfos();

		iceMenu.addMenu("바나나", "이름2", "콘");
		IceInfo[] bananaIceInfos2 = iceMenu.getBananaIceInfos();
		Assertions.assertEquals(bananaIceInfos1.length + 1, bananaIceInfos2.length);
		IceInfo iceInfo = bananaIceInfos2[bananaIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(1200, iceInfo.price);
	}
	@Test
	void banana_cup() {
		IceMenu iceMenu = new IceMenu();
		IceInfo[] bananaIceInfos1 = iceMenu.getBananaIceInfos();

		iceMenu.addMenu("바나나", "이름2", "컵");
		IceInfo[] bananaIceInfos2 = iceMenu.getBananaIceInfos();
		Assertions.assertEquals(bananaIceInfos1.length + 1, bananaIceInfos2.length);
		IceInfo iceInfo = bananaIceInfos2[bananaIceInfos2.length - 1];
		Assertions.assertEquals("이름2", iceInfo.name);
		Assertions.assertEquals(2000, iceInfo.price);
	}
	
	

}
