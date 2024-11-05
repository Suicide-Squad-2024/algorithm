import sys

read = sys.stdin.readline

n = int(read().rstrip())

numbers = list(map(int, read().rstrip().split()))

x = int(read().rstrip())

answer = 0

numbers.sort()

start = 0
end = n - 1

while start < end:
    current_sum = numbers[start] + numbers[end]
    if current_sum == x:
        answer += 1
        start += 1
        end -= 1
    elif current_sum < x:
        start += 1
    else:
        end -= 1

print(answer)
