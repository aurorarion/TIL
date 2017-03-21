#include <stdio.h>

int RecurBSearch(int arr[],int start,int end,int target) {
    if(start > end) {
        return -1;
    }

    int mid = (start + end) / 2;
    if(arr[mid] == target) {
        return mid;
    } else if(arr[mid] > target) {
        return RecurBSearch(arr, start, mid - 1, target);
    } else {
        return RecurBSearch(arr, mid + 1, end, target);
    }
}

int main() {
    int arr[] = {1, 3, 4, 6, 7, 8, 9, 10, 13, 15, 16, 18};
    int target;

    printf("Input target number : ");
    scanf("%d", &target);
    int result = RecurBSearch(arr, 0, sizeof(arr) / sizeof(int) - 1, target);
    if(result == -1) {
        printf("target number isn't found\n");
    } else {
        printf("target number index : %d", result);
    }

    return 0;
}