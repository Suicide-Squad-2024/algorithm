import sys

read = sys.stdin.readline

N, d, k, c = map(int, read().rstrip().split())
# 접시 수, 초밥 가지 수, 연속해서 먹는 접시 수, 쿠폰 번호

rail = [int(read().rstrip()) for _ in range(N)]

rail = list(reversed(rail[-1:-k - 1:-1])) + rail

start = 0
end = start + k

longest = 0

while end <= len(rail):
    row = rail[start:end]
    sushi = set(row)
    sushi_count = len(sushi)

    if c in sushi:
        total = sushi_count
    else:
        total = sushi_count + 1

    if total > longest:
        longest = total

    start += 1
    end += 1

print(longest)
