import sys
import math

read = sys.stdin.readline

N = int(read().rstrip())

road_length = list(map(int, read().rstrip().split()))
fuel_cost = list(map(int, read().rstrip().split()))

total = 0
current_cost = math.inf

for i in range(N - 1):
    if fuel_cost[i] < current_cost:
        current_cost = fuel_cost[i]
        total += fuel_cost[i] * road_length[i]
    else:
        total += current_cost * road_length[i]

print(total)
