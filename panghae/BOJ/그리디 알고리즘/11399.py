import sys

read = sys.stdin.readline

N = int(read().rstrip())

cost = list(map(int, read().rstrip().split()))

cost.sort()

time = 0

time_list = []

for i in range(N):
    time += cost[i]
    time_list.append(time)

print(sum(time_list))
