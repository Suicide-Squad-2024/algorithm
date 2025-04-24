import sys
from collections import defaultdict

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

numbers = list(map(int, read().rstrip().split()))

start = 0
end = 0
answer = 0

num_count = defaultdict(int)

while end < N:
    if num_count[numbers[end]] >= K:
        num_count[numbers[start]] -= 1
        start += 1
    else:
        num_count[numbers[end]] += 1
        end += 1
        length = end - start
        answer = max(answer, length)

print(answer)
