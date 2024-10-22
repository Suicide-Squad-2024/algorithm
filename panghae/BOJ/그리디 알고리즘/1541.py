import sys

read = sys.stdin.readline

lines = read().rstrip().split('-')

value = 0

for i, line in enumerate(lines):
    tmp = 0
    for num in list(map(int, line.split('+'))):
        tmp += num
    if i == 0:
        value += tmp
    else:
        value -= tmp

print(value)
