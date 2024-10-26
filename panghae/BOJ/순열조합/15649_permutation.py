import sys
from itertools import permutations

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

num_list = [i for i in range(1,N+1)]

for value in permutations(num_list, M):
    print(*value)
