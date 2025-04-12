import sys
from collections import deque

read = sys.stdin.readline

n, m = map(int, read().rstrip().split())  # n 세로, m 가로

board = [list(map(int, read().rstrip().split())) for _ in range(n)]

answer = [[[-1, False] for _ in range(m)] for _ in range(n)]

start_point = None

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            start_point = [i, j]
        elif board[i][j] == 0:
            answer[i][j][0] = 0
            answer[i][j][1] = False

q = deque()

q.append([start_point, 1])

answer[start_point[0]][start_point[1]][0] = 0
answer[start_point[0]][start_point[1]][1] = True

while q:
    point, count = q.popleft()
    x, y = point

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 1 and answer[nx][ny][0] == -1 and not answer[nx][ny][1]:
            q.append([[nx, ny], count + 1])
            answer[nx][ny][0] = count
            answer[nx][ny][1] = True

for row in answer:
    for i in row:
        print(i[0], end=' ')
    print()
