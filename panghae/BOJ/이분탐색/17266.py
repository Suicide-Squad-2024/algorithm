import sys
import math

read = sys.stdin.readline

N = int(read().rstrip())
M = int(read().rstrip())

light_point = list(map(int, read().rstrip().split()))

max_height = N
min_height = 1


def can_cover_tunnel(height):
    if height - light_point[0] < 0:
        return False
    for i in range(1, M):
        if light_point[i] - light_point[i - 1] > 2 * height:
            return False
    if N - light_point[-1] > height:
        return False
    return True


result = N

while min_height <= max_height:
    mid = (min_height + max_height) // 2

    check_coverage = can_cover_tunnel(mid)

    if check_coverage:
        result = mid
        max_height = mid - 1
    else:
        min_height = mid + 1

print(result)
