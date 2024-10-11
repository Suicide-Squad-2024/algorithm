import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

numbers = [i for i in range(1, N+1)]


def get_not_duplicated_numbers(num_list):
    if len(num_list) == M:
        print(*num_list)
        return

    for num in numbers:
        if num in num_list:
            continue
        get_not_duplicated_numbers([*num_list, num])


get_not_duplicated_numbers([])
