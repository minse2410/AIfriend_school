#include <stdio.h>

int factorial(int n) {
	if (n == 1) return 1;
	else return n*factorial(n-1);
}

int main(void) {
	int n = 5;
	int i;
	int factorial = 1;

	for (i = n; i >= 1; i--)
		factorial *= i;

	printf("%d!=%d", n, factorial);

	return 0;
}

// 원형함수