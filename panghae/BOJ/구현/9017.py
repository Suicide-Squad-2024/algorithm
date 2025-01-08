import sys
from collections import Counter, defaultdict

read = sys.stdin.readline

T = int(read().rstrip())

for _ in range(T):
    N = int(read().rstrip())
    team_numbers = list(map(int, read().rstrip().split()))

    counter = Counter(team_numbers)
    team_sum = defaultdict(list)

    tmp = 0

    for i in range(N):
        if counter[team_numbers[i]] < 6:
            tmp += 1
            continue
        team_sum[team_numbers[i]].append(i - tmp)

    print(sorted(team_sum, key=lambda x: (sum(team_sum[x][0:4]), team_sum[x][4]))[0])
