import sys

read = sys.stdin.readline

N, B = map(int, read().rstrip().split())

procession = [list(map(int, read().rstrip().split())) for _ in range(N)]


def matrix_multiply(a, b):
    global N
    result = [[0 for _ in range(N)] for _ in range(N)]

    for i in range(N):
        for j in range(N):
            for k in range(N):
                result[i][j] += a[i][k] * b[k][j]
            result[i][j] %= 1000
    return result


def solution(pro, b):
    if b == 1:
        return [[element % 1000 for element in row] for row in pro]
    else:
        result = solution(pro, b // 2)
        if b % 2 == 0:
            return matrix_multiply(result, result)
        else:
            return matrix_multiply(matrix_multiply(result, result), pro)


for i in solution(procession, B):
    print(*i)
