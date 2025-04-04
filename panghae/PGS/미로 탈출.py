from collections import deque


def solution(maps):
    # 시작점(S), 레버(L), 출구(E) 위치 찾기
    start = None
    lever = None
    end = None
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == 'S':
                start = (i, j)
            elif maps[i][j] == 'L':
                lever = (i, j)
            elif maps[i][j] == 'E':
                end = (i, j)

    # 레버 당기기 전 BFS (S → L)
    visited_pre = [[False] * len(maps[0]) for _ in range(len(maps))]
    q = deque([(start[0], start[1], 0)])
    visited_pre[start[0]][start[1]] = True
    time_to_lever = -1
    while q:
        x, y, time = q.popleft()
        if (x, y) == lever:
            time_to_lever = time
            break
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):
                if not visited_pre[nx][ny] and maps[nx][ny] != 'X':
                    visited_pre[nx][ny] = True
                    q.append((nx, ny, time + 1))

    if time_to_lever == -1:
        return -1

    # 레버 당긴 후 BFS (L → E)
    visited_post = [[False] * len(maps[0]) for _ in range(len(maps))]
    q = deque([(lever[0], lever[1], time_to_lever)])
    visited_post[lever[0]][lever[1]] = True
    while q:
        x, y, time = q.popleft()
        if (x, y) == end:
            return time
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):
                if not visited_post[nx][ny] and maps[nx][ny] != 'X':
                    visited_post[nx][ny] = True
                    q.append((nx, ny, time + 1))

    return -1
