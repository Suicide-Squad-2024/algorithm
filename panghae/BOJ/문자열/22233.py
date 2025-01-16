import sys

read = sys.stdin.readline

keyword_count, post_count = map(int, read().rstrip().split())

memo = set([read().rstrip() for _ in range(keyword_count)])

for _ in range(post_count):
    keywords = read().rstrip().split(',')

    for keyword in keywords:
        if keyword in memo:
            memo.remove(keyword)
        else:
            continue

    print(len(memo))
