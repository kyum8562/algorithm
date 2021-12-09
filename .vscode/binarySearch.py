# binary Searching
import random


def binary_search(target, arr):

    arr.sort()
    start = 0
    end = len(arr)-1

    while start <= end:
        mid = round((start + end)/2)

        if arr[mid] == target:
            return mid

        elif arr[mid] > target:
            end = mid - 1

        else:
            start = mid + 1

    return 0


if __name__ == "__main__":
    arr = [i for i in range(11)]
    target = random.randrange(0, len(arr)-1)
    idx = binary_search(target, arr)

    if idx:
        print(arr[idx])
    else:
        print("찾으시는 타겟 {}가 없습니다".format(target))


# Sorting (1) - Bubble Sort, n^2
# Sorting (2) - Select Sort, n^2
# Sorting (3) - Insert Sort, n^2
# Hash Table
# Stack
# Queue
# quick / heap sort : stable한 알고리즘
# merge : unstable한 알고리즘
# backTracking
# DP
# Greedy
