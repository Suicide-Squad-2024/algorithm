from collections import deque


def solution(maps):
    answer = -1
    q = deque()

    q.append((0, 0, 1))

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    while q:
        x, y, count = q.popleft()

        if x == len(maps) -1 and y == len(maps[0]) - 1:
            answer = count
            break

        if maps[x][y] == 1:
            maps[x][y] = 0

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and maps[nx][ny] == 1:
                    q.append((nx, ny, count + 1))

    return answer


print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))