package store;

import org.junit.jupiter.migrationsupport.conditions.IgnoreCondition;

/*
  1. 아이스크림 정보
  2. 아이스크림 종류, 맛 정보
  3. 아이스크림 추천하는 프로그램
 */
public class IceMenu {
	
	private int barPrice = 800;
	private int conPrice = 1200;
	private int cupPrice = 2000;
	
	//아이스크림 정보
	private IceInfo[] chocoIceInfos = new IceInfo[] {
			new IceInfo("초코강", 2000, IceKind.CUP),
			new IceInfo("다크트리", 800, IceKind.BAR),
			new IceInfo("초코의집", 2000, IceKind.CUP),
			new IceInfo("쵸코바", 800, IceKind.BAR),
			new IceInfo("우주초코별", 1200, IceKind.CON),
			new IceInfo("초코 항아리", 800, IceKind.BAR),
			new IceInfo("카카오유니콘", 1200, IceKind.CON)
	};
	private IceInfo[] strawIceInfos = new IceInfo[] {
			new IceInfo("SB크림", 1200, IceKind.CON),
			new IceInfo("딸기거품", 2000, IceKind.CUP),
			new IceInfo("루비바", 800, IceKind.BAR),
			new IceInfo("스쿠루바", 800, IceKind.BAR),
			new IceInfo("부끄부끄콘", 1200, IceKind.CON),
			new IceInfo("생딸기 강", 2000, IceKind.CUP)
	};
	private IceInfo[] greenIceInfos = new IceInfo[] {
			new IceInfo("비밀의 숲", 2000, IceKind.CUP),
			new IceInfo("녹차크림", 2000, IceKind.CUP),
			new IceInfo("Gcon", 1200, IceKind.CON),
			new IceInfo("버블버블", 1200, IceKind.CON),
			new IceInfo("크리스마스Bar", 800, IceKind.BAR),
			new IceInfo("GT진주", 2000, IceKind.CUP)
	};
	private IceInfo[] bananaIceInfos = new IceInfo[] {
			new IceInfo("몽키몽키", 1200, IceKind.CON),
			new IceInfo("옐로우바", 800, IceKind.BAR),
			new IceInfo("바나바", 800, IceKind.BAR),
			new IceInfo("벌의 집", 2000, IceKind.CUP),
			new IceInfo("BN진주", 2000, IceKind.CUP)
	};
	
	public IceInfo[] getChocoIceInfos() {
		return chocoIceInfos;
	}
	public IceInfo[] getStrawIceInfos() {
		return strawIceInfos;
	}
	public IceInfo[] getGreenIceInfos() {
		return greenIceInfos;
	}
	public IceInfo[] getBananaIceInfos() {
		return bananaIceInfos;
	}
	

	//종류 배열
	public String[] getKinds() {
		String[] kinds = new String[] { "바", "콘", "컵" };
		return kinds;
	}
	//맛 배열
	public String[] getTastes() {
		String[] tastes = new String[] { "초코", "딸기", "녹차", "바나나" };
		return tastes;
	}
	
	//iceinfos에서 종류가 kindChoose인 대상 뽑아서 return
	private IceInfo[] recommendInternal(String kindChoose, IceInfo[] iceInfos) {
		IceInfo[] result = new IceInfo[3];
		int idx = 0;
		for(int i = 0; i < iceInfos.length; i++) {
			if(kindChoose.equals(iceInfos[i].kind)) {
				result[idx] = iceInfos[i];
				idx++;
			}
		}
		return result;
	}
	
	//아이스크림 목록 추천
	public IceInfo[] recommend(String tasteChoose, String kindChoose) {	
		// 초코 추천
		if ("초코".equals(tasteChoose)) {
			return recommendInternal(kindChoose, chocoIceInfos);
		}
		
		// 딸기 추천
		if ("딸기".equals(tasteChoose)) {
			return recommendInternal(kindChoose, strawIceInfos);
		}
		
		// 녹차 추천
		if ("녹차".equals(tasteChoose)) {
			return recommendInternal(kindChoose, greenIceInfos);
		}
		
		// 바나나 추천
		if ("바나나".equals(tasteChoose)) {
			return recommendInternal(kindChoose, bananaIceInfos);
		}
		IceInfo[] result = new IceInfo[3]; //아이스크림 배열
		return result;
	}
	
	public IceInfo find(String name) {
		for(int i = 0; i<chocoIceInfos.length; i++) {
			if (chocoIceInfos[i].name.equals(name)) {
				return chocoIceInfos[i];
			}
		}
		for(int i = 0; i<strawIceInfos.length; i++) {
			if(strawIceInfos[i].name.equals(name)) {
				return strawIceInfos[i];
			}
		}
		for(int i = 0; i<greenIceInfos.length; i++) {
			if (greenIceInfos[i].name.equals(name)) {
				return greenIceInfos[i];
			}
		}
		for(int i = 0; i<bananaIceInfos.length; i++) {
			if(bananaIceInfos[i].name.equals(name)) {
				return bananaIceInfos[i];
			}
		}
		return null;
	}
	public void addMenu(String taste, String name, String kind) {
		IceInfo dupNameIce = find(name);
		if(dupNameIce != null) {
			throw new IllegalArgumentException();
		}

		int price = 0;
		if("바".equals(kind)) {
			price = barPrice;
		}else if("콘".equals(kind)) {
			price = conPrice;
		}else if("컵".equals(kind)){
			price = cupPrice;
		}
		if("초코".equals(taste)) {
			IceInfo[] chocoInfos = new IceInfo[this.chocoIceInfos.length + 1];
			System.arraycopy(this.chocoIceInfos, 0, chocoInfos, 0, this.chocoIceInfos.length);
			chocoInfos[chocoInfos.length - 1] = new IceInfo(name, price , kind);
			this.chocoIceInfos = chocoInfos;
		}else if("딸기".equals(taste)) {
			IceInfo[] strawInfos = new IceInfo[this.strawIceInfos.length + 1];
			System.arraycopy(this.strawIceInfos, 0, strawInfos, 0, this.strawIceInfos.length);
			strawInfos[strawInfos.length - 1] = new IceInfo(name, price, kind);
			this.strawIceInfos = strawInfos;
		}else if("녹차".equals(taste)) {
			IceInfo[] greenInfos = new IceInfo[this.greenIceInfos.length + 1];
			System.arraycopy(this.greenIceInfos, 0, greenInfos, 0, this.greenIceInfos.length);
			greenInfos[greenInfos.length - 1] = new IceInfo(name, price, kind);
			this.greenIceInfos = greenInfos;
		}else if("바나나".equals(taste)){
			IceInfo[] bananaInfos = new IceInfo[this.bananaIceInfos.length + 1];
			System.arraycopy(this.bananaIceInfos, 0, bananaInfos, 0, this.bananaIceInfos.length);
			bananaInfos[bananaInfos.length - 1] = new IceInfo(name, price, kind);
			this.bananaIceInfos = bananaInfos;
		}
		
	}
	public void changePrice(String kind, int newPrice) {
		
		for(int i = 0; i<chocoIceInfos.length; i++) {
			if (chocoIceInfos[i].kind.equals(kind)) {
				IceInfo ii = chocoIceInfos[i];
				ii.changePrice(newPrice);//가격변경
			}
		}
		for(int i = 0; i<strawIceInfos.length; i++) {
			if (strawIceInfos[i].kind.equals(kind)) {
				IceInfo ii = strawIceInfos[i];
				ii.changePrice(newPrice);//가격변경
			}
		}
		for(int i = 0; i<greenIceInfos.length; i++) {
			if (greenIceInfos[i].kind.equals(kind)) {
				IceInfo ii = greenIceInfos[i];
				ii.changePrice(newPrice);//가격변경
			}
		}
		for(int i = 0; i<bananaIceInfos.length; i++) {
			if (bananaIceInfos[i].kind.equals(kind)) {
				IceInfo ii = bananaIceInfos[i];
				ii.changePrice(newPrice);//가격변경
			}
		}
		if("바".equals(kind)) {
			barPrice = newPrice;
		}else if("콘".equals(kind)) {
			conPrice = newPrice;
		}else if("컵".equals(kind)){
			cupPrice = newPrice;
		}
	}
	
	
}
