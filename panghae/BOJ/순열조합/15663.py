import sys
from itertools import permutations

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

arr = list(map(int, read().rstrip().split()))

for value in sorted(list(set(permutations(arr, M)))):
    print(*value)
