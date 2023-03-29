package store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IceMenu_changePrice_Test {

	@Test
	void changePriceTest() {
		IceMenu iceMenu = new IceMenu();
		iceMenu.changePrice(IceKind.BAR, 900);
		
		 IceInfo[] chocoIceInfos = iceMenu.getChocoIceInfos();
		 for(IceInfo ii : chocoIceInfos) {
			 if(ii.kind.equals(IceKind.BAR)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] strawIceInfos = iceMenu.getStrawIceInfos();
		 for(IceInfo ii : strawIceInfos) {
			 if(ii.kind.equals(IceKind.BAR)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] greenIceInfos = iceMenu.getGreenIceInfos();
		 for(IceInfo ii : greenIceInfos) {
			 if(ii.kind.equals(IceKind.BAR)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] bananaIceInfos = iceMenu.getBananaIceInfos();
		 for(IceInfo ii : strawIceInfos) {
			 if(ii.kind.equals(IceKind.BAR)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 
	}
	@Test
	void changePriceTest2() {
		IceMenu iceMenu = new IceMenu();
		iceMenu.changePrice(IceKind.CON, 900);
		
		 IceInfo[] chocoIceInfos = iceMenu.getChocoIceInfos();
		 for(IceInfo ii : chocoIceInfos) {
			 if(ii.kind.equals(IceKind.CON)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] strawIceInfos = iceMenu.getStrawIceInfos();
		 for(IceInfo ii : strawIceInfos) {
			 if(ii.kind.equals(IceKind.CON)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] greenIceInfos = iceMenu.getGreenIceInfos();
		 for(IceInfo ii : greenIceInfos) {
			 if(ii.kind.equals(IceKind.CON)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] bananaIceInfos = iceMenu.getBananaIceInfos();
		 for(IceInfo ii : strawIceInfos) {
			 if(ii.kind.equals(IceKind.CON)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 
	}
	@Test
	void changePriceTest3() {
		IceMenu iceMenu = new IceMenu();
		iceMenu.changePrice(IceKind.CUP, 900);
		
		 IceInfo[] chocoIceInfos = iceMenu.getChocoIceInfos();
		 for(IceInfo ii : chocoIceInfos) {
			 if(ii.kind.equals(IceKind.CUP)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] strawIceInfos = iceMenu.getStrawIceInfos();
		 for(IceInfo ii : strawIceInfos) {
			 if(ii.kind.equals(IceKind.CUP)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] greenIceInfos = iceMenu.getGreenIceInfos();
		 for(IceInfo ii : greenIceInfos) {
			 if(ii.kind.equals(IceKind.CUP)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 IceInfo[] bananaIceInfos = iceMenu.getBananaIceInfos();
		 for(IceInfo ii : strawIceInfos) {
			 if(ii.kind.equals(IceKind.CUP)) {
				 Assertions.assertEquals(900, ii.price, "가격이 안 바뀜 : " +  ii.name);
			 }
		 }
		 
	}
	

}
