import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

chess_board = [[0] * M for _ in range(N)]

for i in range(N):
    row = read().rstrip()
    for j, item in enumerate(row):
        chess_board[i][j] = 1 if item == 'W' else 0

least_count = 64


def is_even(x):
    return x % 2 == 0


def check_count_white(start_x, start_y):
    global least_count
    count = 0
    for i in range(8):
        for j in range(8):
            if is_even(i) and is_even(j):
                if chess_board[start_x + i][start_y+j] == 0:
                    count += 1
            elif is_even(i) and not is_even(j):
                if chess_board[start_x + i][start_y + j] == 1:
                    count += 1
            elif not is_even(i) and is_even(j):
                if chess_board[start_x + i][start_y + j] == 1:
                    count += 1
            else:
                if chess_board[start_x + i][start_y + j] == 0:
                    count += 1

    if least_count > count:
        least_count = count


def check_count_black(start_x, start_y):
    global least_count
    count = 0
    for i in range(8):
        for j in range(8):
            if is_even(i) and is_even(j):
                if chess_board[start_x + i][start_y + j] == 1:
                    count += 1
            elif is_even(i) and not is_even(j):
                if chess_board[start_x + i][start_y + j] == 0:
                    count += 1
            elif not is_even(i) and is_even(j):
                if chess_board[start_x + i][start_y + j] == 0:
                    count += 1
            else:
                if chess_board[start_x + i][start_y + j] == 1:
                    count += 1
    if least_count > count:
        least_count = count


for i in range(0, N-7):
    for j in range(0, M-7):
        check_count_black(i, j)
        check_count_white(i, j)

print(least_count)