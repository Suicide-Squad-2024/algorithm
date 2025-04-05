import sys
from collections import defaultdict, deque

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

nodes = defaultdict(list)

answer = 0

for _ in range(M):
    u, v = map(int, read().rstrip().split())
    nodes[u].append(v)
    nodes[v].append(u)

visited = [False] * N


def bfs(start_node):
    global answer
    q = deque()

    q.append(start_node)
    visited[start_node - 1] = True

    while q:
        node = q.popleft()

        for item in nodes[node]:
            if not visited[item - 1]:
                visited[item - 1] = True
                q.append(item)
    answer += 1


while True:
    start_node = 0
    for index, item in enumerate(visited):
        if not item:
            start_node = index + 1
            break
    else:
        break

    bfs(start_node)

print(answer)
