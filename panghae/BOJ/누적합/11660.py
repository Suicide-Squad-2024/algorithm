import sys

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

table = []

queries = []

prefix_sum = [[0 for _ in range(N+1)] for _ in range(N+1)]

for _ in range(N):
    row = list(map(int, read().rstrip().split()))
    table.append(row)

for _ in range(M):
    query = list(map(int, read().rstrip().split()))
    queries.append(query)

for i in range(1, N+1):
    for j in range(1, N+1):
        prefix_sum[i][j] = table[i-1][j-1] + prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1]

for query in queries:
    x1, y1, x2, y2 = query
    print(prefix_sum[x2][y2] - prefix_sum[x1-1][y2] - prefix_sum[x2][y1-1] + prefix_sum[x1-1][y1-1])