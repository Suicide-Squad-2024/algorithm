import sys

read = sys.stdin.readline

N, new_score, P = map(int, read().rstrip().split())


def convert(num_str):
    return (int(num_str), 0)


scores = list(map(convert, read().rstrip().split()))

scores.append((new_score, 1))

scores.sort(key=lambda x: (-x[0], x[1]))

current_rank = 1

for index, (score, key) in enumerate(scores):
    if index + 1 > P:
        print(-1)
        exit()
    if index != 0:
        if score != scores[index - 1][0]:
            current_rank = index + 1

    if score == new_score and key == 1:
        print(current_rank)
        exit()
