package store;

// 아이스크림 모델링
public class IceInfo {
	String name;
	int price;
	String kind; //바,콘,컵
	
	public IceInfo() {}
	public IceInfo(String n, int p, String kind) {
		name = n;
		price = p;
		this.kind = kind;
	}
	public void changePrice(int newPrice) {
		this.price = newPrice;
	}
	
	
}
