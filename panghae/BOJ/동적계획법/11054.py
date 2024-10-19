import sys

read = sys.stdin.readline

N = int(read().rstrip())

arr = list(map(int, read().rstrip().split()))
reverse_arr = list(reversed(arr))

i_dp = [1] * N
d_dp = [1] * N

for i in range(1, N):
    for j in range(i):
        if arr[i] > arr[j]:
            i_dp[i] = max(i_dp[i], i_dp[j] + 1)
        if reverse_arr[i] > reverse_arr[j]:
            d_dp[i] = max(d_dp[i], d_dp[j] + 1)

d_dp.reverse()

print(max(i + j - 1 for i, j in zip(i_dp, d_dp)))
