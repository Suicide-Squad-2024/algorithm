import sys

read = sys.stdin.readline

a, b, c, d, e, f = map(int, read().rstrip().split())

solved = False

for i in range(-999, 1000):
    for j in range(-999, 1000):
        if a * i + b * j == c and d * i + e * j == f:
            solved = True
            print(i, j)
            break
    if solved:
        break
