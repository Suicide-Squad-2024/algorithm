import sys

read = sys.stdin.readline

A, B, C = map(int, read().rstrip().split())


def remain(base, times):
    if times == 1:
        return base % C
    else:
        result = remain(base, times // 2)
        if times % 2 == 0:
            return result * result % C
        else:
            return result * result * base % C


print(remain(A, B))
