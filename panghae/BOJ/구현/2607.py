import sys

read = sys.stdin.readline

N = int(read().rstrip())

base_word = list(read().rstrip())

words = [read().rstrip() for _ in range(N - 1)]

answer = 0

for word in words:
    compare = base_word[:]
    count = 0

    for w in word:
        if w in compare:
            compare.remove(w)
        else:
            count += 1

    if count < 2 and len(compare) < 2:
        answer += 1

print(answer)
