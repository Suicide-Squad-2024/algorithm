import sys
from collections import deque

read = sys.stdin.readline

T = int(read().rstrip())

dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]


def bfs(cur_x, cur_y, g_x, g_y, limit):
    q = deque([(cur_x, cur_y, 0)])
    visited = [[False] * l for _ in range(l)]

    while q:
        x, y, count = q.popleft()

        if not visited[x][y]:
            visited[x][y] = True

            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < limit and 0 <= ny < limit and not visited[nx][ny]:
                    if nx == g_x and ny == g_y:
                        return count + 1
                    q.append((nx, ny, count+1))


for _ in range(T):
    l = int(read().rstrip())
    knight_x, knight_y = map(int, read().rstrip().split())
    goal_x, goal_y = map(int, read().rstrip().split())
    result = bfs(knight_x, knight_y, goal_x, goal_y, l)
    print(result if result else 0)
