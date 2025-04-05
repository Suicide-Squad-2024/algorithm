import sys

input = sys.stdin.readline

m, n = map(int, input().split())
length = list(map(int, input().split()))

start = 1
end = max(length)
answer = 0

while start <= end:
    mid = (start + end) // 2
    snack = 0
    for i in length:
        if i >= mid:
            snack += i // mid

    if snack >= m:
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)
