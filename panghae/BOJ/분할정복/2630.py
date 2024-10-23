import sys

read = sys.stdin.readline

N = int(read().rstrip())

paper = [list(map(int, read().rstrip().split())) for _ in range(N)]


def check_paper_blue(cur):
    for i in range(len(cur)):
        for j in range(len(cur[0])):
            if cur[i][j] == 0:
                return False

    return True


def check_paper_white(cur):
    for i in range(len(cur)):
        for j in range(len(cur[0])):
            if cur[i][j] == 1:
                return False

    return True


blue = 0
white = 0


def cut_paper(cur_paper):
    if check_paper_white(cur_paper):
        global white
        white += 1
        return
    if check_paper_blue(cur_paper):
        global blue
        blue += 1
        return

    cur_paper_length = len(cur_paper)

    cut_paper(
        [[cur_paper[j][i] for i in range(0, cur_paper_length // 2)] for j in
         range(0, cur_paper_length // 2)])
    cut_paper(
        [[cur_paper[j][i] for i in range(cur_paper_length // 2, cur_paper_length)] for j in
         range(0, cur_paper_length // 2)])
    cut_paper(
        [[cur_paper[j][i] for i in range(0, cur_paper_length // 2)] for j in
         range(cur_paper_length // 2, cur_paper_length)])
    cut_paper(
        [[cur_paper[j][i] for i in range(cur_paper_length // 2, cur_paper_length)] for j in
         range(cur_paper_length // 2, cur_paper_length)])


cut_paper(paper)

print(white)
print(blue)
