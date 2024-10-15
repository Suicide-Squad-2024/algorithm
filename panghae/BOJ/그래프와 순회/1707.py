import sys
from collections import deque, defaultdict

read = sys.stdin.readline


def is_bipartite(V, nodes):
    visited = [0] * (V + 1)
    for start in range(1, V + 1):
        if visited[start] == 0:
            q = deque([(start, 1)])
            while q:
                point, color = q.popleft()
                if visited[point] == 0:
                    visited[point] = color
                    for item in nodes[point]:
                        q.append((item, -color))
                elif visited[point] != color:
                    return False
    return True


K = int(read().rstrip())

for _ in range(K):
    V, E = map(int, read().rstrip().split())
    nodes = defaultdict(list)
    for _ in range(E):
        u, v = map(int, read().rstrip().split())
        nodes[u].append(v)
        nodes[v].append(u)

    print('YES' if is_bipartite(V, nodes) else 'NO')