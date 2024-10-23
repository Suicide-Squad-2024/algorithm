import sys

read = sys.stdin.readline

N = int(read().rstrip())

picture = [list(read().rstrip()) for _ in range(N)]


def check_all_1(cur):
    for i in range(len(cur)):
        for j in range(len(cur[0])):
            if cur[i][j] == '0':
                return False

    return True


def check_all_0(cur):
    for i in range(len(cur)):
        for j in range(len(cur[0])):
            if cur[i][j] == '1':
                return False
    return True


def cut_picture(cur_picture):
    if check_all_0(cur_picture):
        return 0
    if check_all_1(cur_picture):
        return 1

    cur_picture_length = len(cur_picture)

    return f'({cut_picture([[cur_picture[j][i] for i in range(0, cur_picture_length // 2)] for j in range(0, cur_picture_length // 2)])}{cut_picture([[cur_picture[j][i] for i in range(cur_picture_length // 2, cur_picture_length)] for j in range(0, cur_picture_length // 2)])}{cut_picture([[cur_picture[j][i] for i in range(0, cur_picture_length // 2)] for j in range(cur_picture_length // 2, cur_picture_length)])}{cut_picture([[cur_picture[j][i] for i in range(cur_picture_length // 2, cur_picture_length)] for j in range(cur_picture_length // 2, cur_picture_length)])})'


print(cut_picture(picture))
