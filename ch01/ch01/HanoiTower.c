#include <stdio.h>

void HanoiTower(char n, char a, char b, char c) {
	// n:���ǰ��� a:����� b:������ c:������
	if (n == 1) printf("���� : %d, %c => %c\n", n, a, c);
	else {
		HanoiTower(n - 1, a, c, b);
		printf("���� : %d, %c => %c\n", n, a, c);	// n:���ǹ�ȣ
		HanoiTower(n - 1, b, a, c);
	}
}

int main(void) {
	int n = 4;		// ���� ����
	HanoiTower(n, 'A', 'B', 'C');
	return 0;
}