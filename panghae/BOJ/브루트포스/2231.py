import sys

read = sys.stdin.readline

N = int(read().rstrip())

answer = 0

for i in range(1, 1_000_001):
    numbers = sum(list(map(int, str(i))))
    if numbers + i == N:
        answer = i
        break

print(answer)
