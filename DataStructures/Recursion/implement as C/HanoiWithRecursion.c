#include <stdio.h>

void hanoitower(int num, char from, char by, char to) {
    if(num == 1) {
        printf("원반 %d을 %c에서 %c로 옮기기\n", num, from, to);
    } else {
        hanoitower(num - 1, from, to, by);
        printf("원반 %d를 %c에서 %c로 옮기기\n", num, from, to);
        hanoitower(num - 1, by, from, to);
    }
}

int main() {
    int number;
    printf("Input number about Hanoi Tower : ");
    scanf("%d", &number);

    hanoitower(number, 'A', 'B', 'C');
    return 0;
}