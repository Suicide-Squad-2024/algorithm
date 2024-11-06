import sys
import math

read = sys.stdin.readline

N, S = map(int, read().rstrip().split())

num_list = list(map(int, read().rstrip().split()))

left = 0
right = 0
partial_sum = num_list[0]
min_length = math.inf

while right < len(num_list):
    if partial_sum < S:
        right += 1
        if right == N:
            break
        partial_sum += num_list[right]
    else:
        partial_sum -= num_list[left]
        min_length = min(min_length, right - left + 1)
        left += 1

if min_length > S:
    print(0)
else:
    print(min_length)
