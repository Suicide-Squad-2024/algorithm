import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

woods = list(map(int, read().rstrip().split()))

min_len = 0
max_len = max(woods)

result = 0


def binary_search(start, end, target):
    global result
    while start <= end:
        mid = (start + end) // 2

        def get_wood_length(origin):
            return origin - mid if origin - mid > 0 else 0

        res = sum(map(get_wood_length, woods))
        if res < target:
            end = mid - 1
        else:
            start = mid + 1
            result = mid


binary_search(min_len, max_len, M)
print(result)
