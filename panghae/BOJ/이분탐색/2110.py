import sys

read = sys.stdin.readline

N, C = map(int, read().rstrip().split())

houses = sorted([int(read().rstrip()) for _ in range(N)])

start = 1
end = houses[-1] - houses[0]

while start <= end:
    mid = (start + end) // 2
    count = 1
    current_pos = houses[0]
    for i in range(len(houses)):
        if houses[i] >= current_pos + mid:
            count += 1
            current_pos = houses[i]
    if count < C:
        end = mid - 1
    else:
        start = mid + 1

print(end)
