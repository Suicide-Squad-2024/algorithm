import sys

read = sys.stdin.readline

n = int(read().rstrip())

procession = [[1, 1], [1, 0]]


def matrix_multiply(A, B):
    result = [[0] * len(B[0]) for _ in range(len(A))]

    for i in range(len(A)):
        for j in range(len(B[0])):
            for k in range(2):
                result[i][j] += A[i][k] * B[k][j]
            result[i][j] %= 1_000_000_007
    return result


def solution(num):
    if num == 1:
        return procession
    else:
        result = solution(num // 2)
        if num % 2 == 0:
            return matrix_multiply(result, result)
        else:
            return matrix_multiply(matrix_multiply(result, result), procession)


print(matrix_multiply(solution(n), [[1], [0]])[1][0])
