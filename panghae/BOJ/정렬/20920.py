import sys
from collections import Counter

read = sys.stdin.readline

N, M = map(int, read().rstrip().split())

words = [read().rstrip() for _ in range(N)]


def filter_word(word):
    return len(word) >= M


filtered_words = list(filter(filter_word, words))
counter = Counter(filtered_words)

print(*sorted(list(set(filtered_words)), key=lambda x: (-counter[x], -len(x), x)), sep='\n')
