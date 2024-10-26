import sys
import math

read = sys.stdin.readline

N = int(read().rstrip())

prev_max = [0, 0, 0]
prev_min = [0, 0, 0]

for i in range(N):
    a, b, c = map(int, read().rstrip().split())

    cur_max = [
        a + max(prev_max[0], prev_max[1]),
        b + max(prev_max[0], prev_max[1], prev_max[2]),
        c + max(prev_max[1], prev_max[2])
    ]
    cur_min = [
        a + min(prev_min[0], prev_min[1]),
        b + min(prev_min[0], prev_min[1], prev_min[2]),
        c + min(prev_min[1], prev_min[2])
    ]

    prev_max = cur_max
    prev_min = cur_min

print(max(prev_max), min(prev_min))
