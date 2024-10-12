import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

numbers = [i for i in range(1, N+1)]


def dfs(num_list):
    if len(num_list) == M:
        print(*num_list)
        return

    for num in numbers:
        if num_list:
            if  num_list[-1] <= num :
                dfs([*num_list, num])
        else:
            dfs([num])


dfs([])