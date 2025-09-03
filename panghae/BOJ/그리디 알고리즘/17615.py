import sys

read = sys.stdin.readline

N = int(read().rstrip())

balls = list(read().rstrip())

R_count = balls.count('R')
B_count = balls.count('B')

# 3. 왼쪽 연속 R
left_R = 0
for c in balls:
    if c == 'R':
        left_R += 1
    else:
        break

# 4. 오른쪽 연속 R
right_R = 0
for c in reversed(balls):
    if c == 'R':
        right_R += 1
    else:
        break

# 5. 왼쪽 연속 B
left_B = 0
for c in balls:
    if c == 'B':
        left_B += 1
    else:
        break

# 6. 오른쪽 연속 B
right_B = 0
for c in reversed(balls):
    if c == 'B':
        right_B += 1
    else:
        break

print(min(R_count - left_R, R_count - right_R, B_count - left_B, B_count - right_B))
