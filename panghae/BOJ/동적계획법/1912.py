import sys

read = sys.stdin.readline

n = int(read().rstrip())

arr = list(map(int, read().rstrip().split()))

max_sum = current_sum = arr[0]

for i in range(1, n):
    current_sum = max(arr[i], current_sum + arr[i])
    max_sum = max(max_sum, current_sum)

print(max_sum)
