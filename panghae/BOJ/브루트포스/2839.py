import sys
import math

read = sys.stdin.readline

N = int(read().rstrip())

answer = math.inf
five_count = 0
five_limit = N // 5

while five_count <= five_limit:
    rest = N - five_count * 5
    three_count = rest // 3
    if rest % 3 == 0:
        answer = min(answer, five_count + three_count)
    five_count += 1

if answer == math.inf:
    print(-1)
else:
    print(answer)