import sys
import math
from collections import Counter

read = sys.stdin.readline

words = list(read().rstrip())

a_count = Counter(words).get('a')

if not a_count:
    a_count = 0

words = words + words

start = 0
end = start + a_count

cur = words[start:end]

smallest = math.inf

while end <= len(words):
    if smallest < math.inf:
        cur = cur[1:] + [words[end - 1]]

    b_count = Counter(cur).get('b')

    if not b_count:
        smallest = 0
        break

    if b_count < smallest:
        smallest = b_count
    start += 1
    end += 1

print(smallest)
