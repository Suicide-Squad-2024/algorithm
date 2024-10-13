import sys
import math
from itertools import combinations

read = sys.stdin.readline

N = int(read().rstrip())

point_map = [list(map(int, read().rstrip().split())) for _ in range(N)]

members = [i for i in range(N)]

answer = math.inf

total = 0

for row in point_map:
    total += sum(row)


def dfs(count, selected):
    global answer
    if count == N // 2:
        point = 0
        opponent = 0
        for value in combinations(selected, 2):
            x, y = value
            point += point_map[x][y] + point_map[y][x]

        for value in combinations(list(set(members) - set(selected)), 2):
            x, y = value
            opponent += point_map[x][y] + point_map[y][x]

        answer = min(abs(opponent - point), answer)
        return
    start = max(selected) if len(selected) else 0
    for i in range(start + 1, N):
        dfs(count+1, [*selected, i])


dfs(0, [])
print(answer)