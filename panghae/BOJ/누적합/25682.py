import sys

read = sys.stdin.readline

N, M, K = map(int, read().rstrip().split())

chess_board = []

prefix_sum = [[(0, 0) for _ in range(M + 1)] for _ in range(N + 1)]  # (start white, start black)

for i in range(N):
    row_input = list(read().rstrip())
    row_output = []
    for j, item in enumerate(row_input):
        if (i + j) % 2 == 0:
            if item == 'W':
                row_output.append((1, 0))
            else:
                row_output.append((0, 1))
        else:
            if item == 'W':
                row_output.append((0, 1))
            else:
                row_output.append((1, 0))
    chess_board.append(row_output)

for i in range(1, N+1):
    for j in range(1, M+1):
        white = chess_board[i-1][j-1][0] + prefix_sum[i-1][j][0] + prefix_sum[i][j-1][0] - prefix_sum[i-1][j-1][0]
        black = chess_board[i-1][j-1][1] + prefix_sum[i-1][j][1] + prefix_sum[i][j-1][1] - prefix_sum[i-1][j-1][1]
        prefix_sum[i][j] = (white, black)

answer = K ** 2

for k in range(N - K + 1):
    for w in range(M - K + 1):
        white = prefix_sum[k + K][w + K][0] - prefix_sum[k + K][w][0] - prefix_sum[k][w + K][0] + prefix_sum[k][w][0]
        black = prefix_sum[k + K][w + K][1] - prefix_sum[k + K][w][1] - prefix_sum[k][w + K][1] + prefix_sum[k][w][1]

        answer = min(answer, white, black)

print(answer)

