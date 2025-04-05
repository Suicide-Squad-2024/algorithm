import sys

read = sys.stdin.readline

n = int(read().rstrip())

levels = list(map(int, read().rstrip().split()))

levels.sort()

teams = []

for i in range(n):
    teams.append(levels[i] + levels[2 * n - 1 - i])

print(min(teams))
