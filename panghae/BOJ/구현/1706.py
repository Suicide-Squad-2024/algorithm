import sys

read = sys.stdin.readline

words = []

R, C = map(int, read().rstrip().split())

board = [list(read().rstrip()) for _ in range(R)]

for i in range(R):
    line = board[i]
    tmp = ''
    for word in line:
        if word == '#':
            if len(tmp) >= 2:
                words.append(tmp)
            tmp = ''
        else:
            tmp += word
    if len(tmp) >= 2:
        words.append(tmp)

for j in range(C):
    row = [board[k][j] for k in range(R)]
    tmp = ''
    
    for word in row:
        if word == '#':
            if len(tmp) >= 2:
                words.append(tmp)
            tmp = ''
        else:
            tmp += word
    if len(tmp) >= 2:
        words.append(tmp)

words.sort()
print(words[0])
