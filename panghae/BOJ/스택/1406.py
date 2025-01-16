import sys
from collections import deque

read = sys.stdin.readline

left_stack = deque(list(read().rstrip()))
right_stack = deque()

M = int(read().rstrip())

for _ in range(M):
    input_val = read().rstrip()

    if len(input_val) == 3:
        _, word = input_val.split()
        left_stack.append(word)
    elif input_val == 'L':
        if left_stack:
            item = left_stack.pop()
            right_stack.append(item)
    elif input_val == 'D':
        if right_stack:
            item = right_stack.pop()
            left_stack.append(item)
    else:  # B
        if left_stack:
            left_stack.pop()

answer = list(left_stack) + list(right_stack)[::-1]
print(*answer, sep='')
