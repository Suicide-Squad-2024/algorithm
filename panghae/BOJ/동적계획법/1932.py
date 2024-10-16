import sys

read = sys.stdin.readline

N = int(read().rstrip())

arr = [list(map(int, read().rstrip().split())) for _ in range(N)]


for i in range(N-2, -1, -1):
    for j in range(len(arr[i])):
        arr[i][j] += max(arr[i+1][j], arr[i+1][j+1])

print(arr[0][0])