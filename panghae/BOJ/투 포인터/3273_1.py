import sys

read = sys.stdin.readline

n = int(read().rstrip())

numbers = list(map(int, read().rstrip().split()))

x = int(read().rstrip())

numbers.sort()

i = 0
j = len(numbers) - 1
answer = 0

while i < j:
    tmp = numbers[i] + numbers[j]

    if tmp < x:
        i += 1
    elif tmp > x:
        j -= 1
    else:
        answer += 1
        j -= 1

print(answer)
