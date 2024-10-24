import sys
import heapq

read = sys.stdin.readline

N = int(read().rstrip())

array = []

heapq.heapify(array)

for _ in range(N):
    num = int(read().rstrip())
    if num == 0:
        if array:
            number = heapq.heappop(array)
            print(-number)
        else:
            print(0)
    else:
        heapq.heappush(array, -num)
