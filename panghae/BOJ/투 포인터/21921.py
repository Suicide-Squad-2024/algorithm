import sys

read = sys.stdin.readline

N, X = map(int, read().rstrip().split())

visitor_list = list(map(int, read().rstrip().split()))

start = 0
end = X

pre_sum = sum(visitor_list[start:end])

start += 1

visitor_count = pre_sum

same_count = 1

while end < N:
    pre_sum = pre_sum - visitor_list[start - 1] + visitor_list[end]
    if visitor_count < pre_sum:
        visitor_count = pre_sum
        same_count = 1
    elif visitor_count == pre_sum:
        same_count += 1

    start += 1
    end += 1

if visitor_count == 0:
    print('SAD')
else:
    print(visitor_count)
    print(same_count)
