import sys

read = sys.stdin.readline

N = int(read().rstrip())

arr = list(map(int, read().rstrip().split()))

lis = [arr[0]]


def binary_search(target, lis):
    start = 0
    end = len(lis) - 1

    while start <= end:
        mid = (start + end) // 2
        if lis[mid] == target or lis[mid - 1] < lis[mid] < lis[mid]:
            return mid
        elif target < lis[mid]:
            end = mid - 1
        else:
            start = mid + 1

    return start


for i in range(1, N):
    target = arr[i]
    if lis[-1] < target:
        lis.append(target)
    else:
        index = binary_search(target, lis)
        lis[index] = target

print(len(lis))
