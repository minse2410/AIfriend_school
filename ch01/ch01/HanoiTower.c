#include <stdio.h>

void HanoiTower(char n, char a, char b, char c) {
	// n:원판개수 a:출발지 b:경유지 c:도착지
	if (n == 1) printf("원판 : %d, %c => %c\n", n, a, c);
	else {
		HanoiTower(n - 1, a, c, b);
		printf("원판 : %d, %c => %c\n", n, a, c);	// n:원판번호
		HanoiTower(n - 1, b, a, c);
	}
}

int main(void) {
	int n = 4;		// 원판 개수
	HanoiTower(n, 'A', 'B', 'C');
	return 0;
}