import sys

read = sys.stdin.readline

N, K = map(int, read().rstrip().split())

coins = list(reversed([int(read().rstrip()) for _ in range(N)]))

count = 0

for coin in coins:
    if coin <= K:
        count += K // coin
        K = K % coin

print(count)
