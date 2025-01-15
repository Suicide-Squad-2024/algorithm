import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

state = [read().rstrip().split() for _ in range(N)]

combat_power = [int(read().rstrip()) for _ in range(M)]

for power in combat_power:
    start = 0
    end = N - 1
    result = ''

    while start <= end:
        mid = (start + end) // 2
        if int(state[mid][1]) >= power:
            result = state[mid][0]
            end = mid - 1
        else:
            start = mid + 1

    print(result)
