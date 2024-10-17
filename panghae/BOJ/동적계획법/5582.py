import sys

read = sys.stdin.readline

word1 = read().rstrip()
word2 = read().rstrip()

dp = [[0 for _ in range(len(word1) + 1)] for _ in range(len(word2) + 1)]

answer = 0

for i in range(1, len(word2) + 1):
    for j in range(1, len(word1) + 1):
        if word1[j - 1] == word2[i - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = 0

print(max([max(i) for i in dp]))
