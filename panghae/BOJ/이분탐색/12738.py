import sys

read = sys.stdin.readline

N = int(read().rstrip())

arr = list(map(int, read().rstrip().split()))

result = [arr[0]]


def binary_search(start, end, target):
    while start < end:
        mid = (start + end) // 2

        if result[mid] < target:
            start = mid + 1
        elif result[mid] > target:
            end = mid
        else:
            return mid

    return start


for i in range(1, N):
    if result[-1] < arr[i]:
        result.append(arr[i])
    else:
        index = binary_search(0, len(result) - 1, arr[i])
        result[index] = arr[i]

print(len(result))
