import sys

read = sys.stdin.readline

w1 = read().rstrip()
w2 = read().rstrip()

dp = [[(0, '')] * (len(w1) + 1) for _ in range(len(w2) + 1)]

word = ''

for i in range(1, len(w2) + 1):
    for j in range(1, len(w1) + 1):
        if w1[j - 1] == w2[i - 1]:
            dp[i][j] = (dp[i - 1][j - 1][0] + 1, f'{dp[i - 1][j - 1][1]}{w1[j - 1]}')
        else:
            dp[i][j] = (max(dp[i - 1][j][0], dp[i][j - 1][0]),
                        f'{dp[i - 1][j][1] if dp[i - 1][j][0] >= dp[i][j - 1][0] else dp[i][j - 1][1]}')

lcs_len = dp[len(w2)][len(w1)][0]
print(lcs_len)

if lcs_len:
    print(dp[len(w2)][len(w1)][1])
