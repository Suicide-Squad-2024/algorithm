import sys

read = sys.stdin.readline

N = int(read().rstrip())
K = int(read().rstrip())

start = 1
end = N ** 2

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in range(1, N + 1):
        count += min(N, mid // i)
    if count >= K:
        end = mid - 1
    else:
        start = mid + 1

print(start)
