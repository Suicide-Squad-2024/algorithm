import sys

read = sys.stdin.readline

N = int(read().rstrip())

cities = list(map(int, read().rstrip().split()))

target = int(read().rstrip())

s = 1
e = target

answer = -1


def binary_search(start, end):
    global answer
    while start <= end:
        mid = (start + end) // 2

        def calc_total(num):
            return min(num, mid)

        if sum(map(calc_total, cities)) > target:
            end = mid - 1
        else:
            answer = mid
            start = mid + 1


binary_search(s, e)
print(min(answer, max(cities)))
