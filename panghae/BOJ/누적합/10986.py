import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

values = list(map(int, read().rstrip().split()))

prefix_sum = [0] * M

add = 0

for value in values:
    add += value
    prefix_sum[add % M] += 1

answer = prefix_sum[0]

for i in range(M):
    answer += prefix_sum[i] *(prefix_sum[i] -1) // 2

print(answer)