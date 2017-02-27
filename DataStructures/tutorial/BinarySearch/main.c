#include <stdio.h>

int BSearch(int arr[], int arrLen, int target) {
	int start = 0;
	int end = arrLen - 1;
	while(start <= end) {
		int mid = (start + end) / 2;
		if(arr[mid] == target) {
			return mid;
		} else {
			if(arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
	}
	return -1;
}

int main(void) {
	int arr[] = {1, 3, 5, 6, 8, 9, 10, 13, 16};
	int idx, target;
	
	printf("Input number : ");
	scanf("%d", &target);
	
	idx = BSearch(arr, sizeof(arr)/sizeof(int), target);
	if(idx == -1) {
		printf("Searching Fail\n");
	} else {
		printf("target number index : %d", idx);
	}
	return 0;
}
