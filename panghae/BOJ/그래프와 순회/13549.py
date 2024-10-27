import sys
from collections import deque

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

q = deque([(N, 0)])

visited = [False] * 100_001

while q:
    pos, time = q.popleft()

    if pos == K:
        print(time)
        break

    if not visited[pos]:
        visited[pos] = True

        for new_pos in [pos + 1, pos - 1, pos * 2]:
            if 0 <= new_pos < 100_001 and not visited[new_pos]:
                if new_pos == pos * 2:
                    q.appendleft((new_pos, time))
                else:
                    q.append((new_pos, time + 1))
