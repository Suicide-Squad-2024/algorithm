from collections import deque


def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0

    field = [[0 for _ in range(102)] for _ in range(102)]

    for r in rectangle:
        x1, y1, x2, y2 = map(lambda x: x * 2, r)
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                if x1 < i < x2 and y1 < j < y2:
                    field[i][j] = 2
                elif field[i][j] != 2:
                    field[i][j] = 1

    visited = [[False for _ in range(102)] for _ in range(102)]

    q = deque([(characterX * 2, characterY * 2, 0)])

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    while q:
        x, y, count = q.popleft()

        if not visited[x][y]:
            visited[x][y] = True
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx == itemX * 2 and ny == itemY * 2:
                    return (count + 1) // 2
                if 0 <= nx < 102 and 0 <= ny < 102 and not visited[nx][ny] and field[nx][ny] == 1:
                    q.append((nx, ny, count + 1))
    return answer


print(solution([[1, 1, 7, 4], [3, 2, 5, 5], [4, 3, 6, 9], [2, 6, 8, 8]], 1, 3, 7, 8))
print(solution([[1, 1, 8, 4], [2, 2, 4, 9], [3, 6, 9, 8], [6, 3, 7, 7]], 9, 7, 6, 1))
print(solution([[1, 1, 5, 7]], 1, 1, 4, 7))
print(solution([[2, 1, 7, 5], [6, 4, 10, 10]], 3, 1, 7, 10))
print(solution([[2, 2, 5, 5], [1, 3, 6, 4], [3, 1, 4, 6]], 1, 4, 6, 3))
