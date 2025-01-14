import sys
from collections import defaultdict

read = sys.stdin.readline

T = int(read().rstrip())

for _ in range(T):
    teams, problems, team_id, entry_count = map(int, read().rstrip().split())
    scores = {i: [0] * (problems + 1) for i in range(1, teams + 1)}

    count = [0] * (teams + 1)
    order = [0] * (teams + 1)

    for i in range(entry_count):
        team, prob_num, score = list(map(int, read().rstrip().split()))
        scores[team][prob_num] = max(scores[team][prob_num], score)
        count[team] += 1
        order[team] = i

    print(sorted(scores, key=lambda x: [-sum(scores[x]), count[x], order[x]]).index(team_id) + 1)
