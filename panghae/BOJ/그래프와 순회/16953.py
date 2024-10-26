import sys
from collections import deque

read = sys.stdin.readline

A, B = map(int, read().rstrip().split())

q = deque([(A, 0)])

actions = ['multiple', 'add']

while q:
    num, count = q.popleft()

    for action in actions:
        if action == 'multiple':
            n_num = num * 2
            if n_num == B:
                print(count + 2)
                exit()
            elif n_num > B:
                continue
            q.append((n_num, count + 1))
        else:
            n_num = int(str(num) + '1')
            if n_num == B:
                print(count + 2)
                exit()
            elif n_num > B:
                continue
            q.append((n_num, count + 1))

print(-1)
