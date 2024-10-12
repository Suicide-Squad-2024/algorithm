import sys

read = sys.stdin.read

N_list = read().split()

for N in N_list:
    result = ['-'] * (3 ** int(N))

    def change_center_space(start, end):
        if end == start:
            return

        length = (end - start + 1) // 3
        for i in range(start + length, start + length * 2):
            result[i] = ' '

        change_center_space(start, start + length - 1)
        change_center_space(start + 2 * length, end)


    change_center_space(0, len(result)-1)
    print(''.join(result))
