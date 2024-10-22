import sys

read = sys.stdin.readline

N = int(read().rstrip())

meetings = [list(map(int, read().rstrip().split())) for _ in range(N)]

meetings.sort(key=lambda x: (x[1], x[0]))

selected = []

for meeting in meetings:
    if not selected:
        selected.append(meeting)
    else:
        top = selected[-1]
        if top[1] <= meeting[0]:
            selected.append(meeting)

print(len(selected))
