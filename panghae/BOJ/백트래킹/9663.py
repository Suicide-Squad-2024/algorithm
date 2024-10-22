import sys

read = sys.stdin.readline

N = int(read().rstrip())

board = [-1] * N


def is_safe(row, col):
    for i in range(row):
        if board[i] == col or abs(board[i] - col) == abs(row - i):
            return False
    return True


def dfs(row):
    if row == N:
        return 1
    count = 0
    for col in range(N):
        if is_safe(row, col):
            board[row] = col
            count += dfs(row + 1)
    return count


print(dfs(0))