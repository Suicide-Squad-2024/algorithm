import sys

read = sys.stdin.readline

N = int(read().rstrip())

taller = list(map(int, read().rstrip().split()))

answer = [0] * N

for i in range(N):
    count = 0
    for j in range(N):
        if answer[j] == 0 and count == taller[i]:
            answer[j] = i + 1
            break
        elif answer[j] == 0:
            count += 1

print(*answer)
