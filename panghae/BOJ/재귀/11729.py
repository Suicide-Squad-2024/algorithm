import sys

read = sys.stdin.readline

N = int(read().rstrip())

count = 0

moves = []


def hanoi(n, start, center, target):
    global count
    if n == 1:
        moves.append((start, target))
        return
    hanoi(n-1, start, target, center)
    moves.append((start, target))
    hanoi(n-1, center, start, target)


hanoi(N,1,2,3)
print(len(moves))
for move in moves:
    print(move[0], move[1])