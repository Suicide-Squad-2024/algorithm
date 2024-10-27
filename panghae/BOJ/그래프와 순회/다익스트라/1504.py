import sys
import heapq
import math
from collections import defaultdict

read = sys.stdin.readline

N, E = map(int, read().rstrip().split())

node_map = defaultdict(dict)

for i in range(E):
    a, b, c = map(int, read().rstrip().split())

    node_map[a][b] = c
    node_map[b][a] = c

v1, v2 = map(int, read().rstrip().split())


def dijkstra(start, end):
    distances = [math.inf] * (N + 1)
    distances[start] = 0

    q = [(distances[start], start)]

    heapq.heapify(q)

    while q:
        cur_distance, cur_pos = heapq.heappop(q)
        if cur_pos == end:
            return distances[end]

        if distances[cur_pos] < cur_distance:
            continue

        for new_pos, new_distance in node_map[cur_pos].items():
            distance = cur_distance + new_distance
            if distance < distances[new_pos]:
                distances[new_pos] = distance
                heapq.heappush(q, (distance, new_pos))

    return math.inf


path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N)
path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N)

result = min(path1, path2)

if math.isinf(result):
    print(-1)
else:
    print(result)
