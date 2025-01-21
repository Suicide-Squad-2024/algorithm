import sys

read = sys.stdin.readline

numbers = ''.join(read().rstrip().split())

clock_num_already_used = [False for _ in range(1111, 10000)]


def get_clock_num(x):
    num_list = []
    for i in range(len(x)):
        new_num = x[i:] + x[0:i]
        num_list.append(int(new_num))

    num_list.sort()
    return num_list[0]


base = get_clock_num(numbers)

answer = 0

for j in range(1111, int(base) + 1):
    str_num = str(j)
    if '0' in str_num:
        continue
    result = get_clock_num(str_num)

    if result <= int(base) and not clock_num_already_used[result - 1111]:
        clock_num_already_used[result - 1111] = True
        answer += 1

print(answer)
