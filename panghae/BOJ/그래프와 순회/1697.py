import sys
from collections import deque

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

visited = [False] * 100_001
q = deque([(N, 0)])

while q:
    pos, time = q.popleft()

    if pos == K:
        print(time)
        break

    for new_pos in [pos + 1, pos - 1, pos * 2]:
        if 0 <= new_pos < 100_001 and not visited[new_pos]:
            visited[new_pos] = True
            q.append((new_pos, time + 1))
