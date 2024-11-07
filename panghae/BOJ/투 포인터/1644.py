import sys
import math

read = sys.stdin.readline

N = int(read().rstrip())

is_prime = [1 for _ in range(N + 1)]

is_prime[0], is_prime[1] = 0, 0

for i in range(2, int(math.sqrt(N)) + 1):
    if is_prime[i]:
        for j in range(2, N // i + 1):
            is_prime[i * j] = 0

prime_numbers = []

for i in range(2, N + 1):
    if is_prime[i]:
        prime_numbers.append(i)

if len(prime_numbers) == 0:
    print(0)
    exit()

count = 0
start = len(prime_numbers) - 1
end = len(prime_numbers) - 1
cur = prime_numbers[-1]

while 0 <= start <= end and 0 <= end < len(prime_numbers):
    if cur > N:
        cur -= prime_numbers[end]
        end -= 1
    else:
        if cur == N:
            count += 1
        start -= 1
        if start < 0:
            break
        cur += prime_numbers[start]

print(count)
