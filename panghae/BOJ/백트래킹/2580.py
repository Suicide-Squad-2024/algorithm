import sys

read = sys.stdin.readline

sudoku_map = [list(map(int, read().rstrip().split())) for _ in range(9)]

zero_point = []

for i in range(9):
    for j in range(9):
        if sudoku_map[i][j] == 0:
            zero_point.append((i, j))


def check_block(x, y, n):
    new_x = (x // 3) * 3
    new_y = (y // 3) * 3

    for i in range(3):
        for j in range(3):
            if sudoku_map[new_x + i][new_y + j] == n:
                return False
    return True


def check_row(x, n):
    for i in range(9):
        if sudoku_map[x][i] == n:
            return False
    return True


def check_column(y, n):
    for i in range(9):
        if sudoku_map[i][y] == n:
            return False
    return True


def dfs(n):
    if n == len(zero_point):
        for item in sudoku_map:
            print(*item)
        exit()

    for i in range(1, 10):
        x = zero_point[n][0]
        y = zero_point[n][1]
        if check_block(x, y, i) and check_row(x, i) and check_column(y, i):
            sudoku_map[x][y] = i
            dfs(n + 1)
            sudoku_map[x][y] = 0


dfs(0)

