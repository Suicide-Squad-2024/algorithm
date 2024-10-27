import sys
import math
from collections import deque

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

q = deque([(N, 0)])

visited = [math.inf] * 100_001

min_count = 0
min_value = math.inf

while q:
    pos, time = q.popleft()

    if time > min_value:
        break
    if visited[pos] >= time:
        visited[pos] = time
        if pos == K:
            if min_value > time:
                min_value = time
                min_count = 1
            elif min_value == time:
                min_value = time
                min_count += 1

        for new_pos in [pos + 1, pos - 1, pos * 2]:
            if 0 <= new_pos < 100_001 and visited[new_pos] >= time + 1:
                q.append((new_pos, time + 1))

print(min_value)
print(min_count)
