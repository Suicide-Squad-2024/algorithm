import sys
from collections import Counter

read = sys.stdin.readline

S = list(read().rstrip())

counter = Counter(S)

count = 0

for s in S:
    if count == counter['1'] // 2:
        break
    if s == '1':
        S.remove(s)
        count += 1

count = 0
S = S[::-1]
for s in S:
    if count == counter['0'] // 2:
        break
    if s == '0':
        S.remove(s)
        count += 1

print(''.join(S[::-1]))
