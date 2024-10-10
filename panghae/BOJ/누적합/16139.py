import sys

read = sys.stdin.readline

string_value = read().rstrip()

N = int(read().rstrip())

prefix_sum = [[0] for _ in range(26)]

word_count = [0] * 26

for string in string_value:
    word_count[ord(string) - 97] += 1
    for i in range(26):
        prefix_sum[i].append(word_count[i])

for _ in range(N):
    word, s_start, s_last = read().rstrip().split()

    start = int(s_start)
    last = int(s_last)
    index = ord(word) - 97

    sys.stdout.write(f'{prefix_sum[index][last+1] - prefix_sum[index][start]}\n')