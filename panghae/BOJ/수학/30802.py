import sys

read = sys.stdin.readline

N = int(read().rstrip())

sizes = map(int, read().rstrip().split())

T, P = map(int, read().rstrip().split())

t_count = 0

for size in sizes:
    if size % T == 0:
        t_count += size // T
    else:
        t_count += (size // T + 1)

print(t_count)
print(N // P, N % P)
