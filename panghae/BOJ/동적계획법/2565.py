import sys

read = sys.stdin.readline

line_count = int(read().rstrip())

lines = []

for _ in range(line_count):
    lines.append(tuple(map(int, read().rstrip().split())))

lines.sort(key=lambda x: x[1])

dp = [1] * line_count

for i in range(1, line_count):
    for j in range(i):
        if lines[i][0] > lines[j][0]:
            dp[i] = max(dp[i], dp[j] + 1)

print(line_count - max(dp))
