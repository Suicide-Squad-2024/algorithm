def solution(m, n, puddles):
    board = [[1] * m for _ in range(n)]

    for puddle in puddles:
        y, x = puddle
        if y == 1:
            for i in range(x, n):
                board[i][y - 1] = 0
        if x == 1:
            for i in range(y, m):
                board[x - 1][i] = 0

        board[x - 1][y - 1] = 0

    for i in range(1, n):
        for j in range(1, m):
            board[i][j] = board[i - 1][j] + board[i][j - 1] if board[i][j] != 0 else 0

    return board[n - 1][m - 1] % 1_000_000_007


print(solution(4, 3, [[2, 2]]))
