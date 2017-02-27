#include <stdio.h>

int LSearch(int arr[], int arrLen, int target) {
    int i;
    for(i = 0; i < arrLen; i++) {
        if(arr[i] == target) {
            return i;
        }
    }
    return -1;
}

int main() {
    int arr[] = {3, 4, 6, 7, 9};
    int idx, target;

    printf("Input number : ");
    scanf("%d", &target);

    idx = LSearch(arr, sizeof(arr)/ sizeof(int), target);

    if(idx == -1) {
        printf("탐색 실패\n");
    } else {
        printf("타켓 숫자 index : %d\n", idx);
    }
    return 0;
}