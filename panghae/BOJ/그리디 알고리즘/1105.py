import sys

read = sys.stdin.readline

L, R = read().rstrip().split()

ret = 0

if len(L) == len(R):
    for i in range(len(L)):
        if L[i] == R[i]:
            if L[i] == '8':
                ret += 1
        else:
            break

print(ret)
