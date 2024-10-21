import sys
from collections import deque, defaultdict

read = sys.stdin.readline

N, M, V = map(int, read().rstrip().split())

vector_map = defaultdict(list)

for _ in range(M):
    start, end = map(int, read().rstrip().split())
    vector_map[start].append(end)
    vector_map[end].append(start)


def dfs():
    stack = deque([V])
    visited = []

    while stack:
        cur = stack.pop()
        if cur not in visited:
            visited.append(cur)

        for next_item in sorted(vector_map[cur], reverse=True):
            if next_item not in visited:
                stack.append(next_item)

    print(*visited)


def bfs():
    q = deque([V])
    visited = []

    while q:
        cur = q.popleft()
        if cur not in visited:
            visited.append(cur)

        for next_item in sorted(vector_map[cur]):
            if next_item not in visited:
                q.append(next_item)

    print(*visited)


dfs()
bfs()