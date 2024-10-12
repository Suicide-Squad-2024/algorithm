import sys
from itertools import combinations_with_replacement

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

numbers = [i for i in range(1, N+1)]

for value in combinations_with_replacement(numbers, M):
    print(*value)
