import sys

read = sys.stdin.readline

N = int(read().rstrip())

arr = list(map(int, read().rstrip().split()))

arr.sort()

M = int(read().rstrip())

check = list(map(int, read().rstrip().split()))


def binary_search(num):
    start = 0
    end = len(arr) - 1

    answer = None

    while start <= end:
        index = (start + end) // 2
        if arr[index] < num:
            start = index + 1
        elif arr[index] > num:
            end = index - 1
        else:
            answer = index
            break

    return answer


for i in range(M):
    result = binary_search(check[i])
    if result is not None:
        print(1)
    else:
        print(0)
