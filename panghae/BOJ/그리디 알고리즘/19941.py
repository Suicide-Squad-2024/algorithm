import sys

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

position = list(read().rstrip())

answer = 0

for index, pos in enumerate(position):
    if pos == 'P':
        start = index - K if index >= K else 0
        end = index + K if len(position) > index + K else len(position) - 1

        for i in range(start, end + 1):
            if position[i] == 'H':
                answer += 1
                position[i] = 'X'
                break

print(answer)
