import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

never_heard = set([read().rstrip() for _ in range(N)])

answer = []

for _ in range(M):
    person = read().rstrip()
    if person in never_heard:
        answer.append(person)

answer.sort()

print(len(answer))
for result in answer:
    print(result)
