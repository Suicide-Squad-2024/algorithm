import sys
import math

read = sys.stdin.readline

N = int(read().rstrip())

liq_list = list(map(int, read().rstrip().split()))

left = 0
right = len(liq_list) - 1
mixed_near_0 = math.inf
value = [None, None]

liq_list.sort()

while left < right:
    mixed = liq_list[left] + liq_list[right]

    if abs(mixed) < abs(mixed_near_0):
        mixed_near_0 = mixed
        value[0] = left
        value[1] = right

    if mixed > 0:
        right -= 1
    elif mixed < 0:
        left += 1
    else:
        break

print(liq_list[value[0]], liq_list[value[1]])
