import sys

read = sys.stdin.readline

K, N = map(int, read().rstrip().split())

lines = sorted([int(read().rstrip()) for _ in range(K)])

start = 1
end = lines[-1]

answer = 0

while start <= end:
    length = (start + end) // 2
    count = sum([i // length for i in lines])
    if count < N:
        end = length - 1
    else:
        start = length + 1

print(end)
