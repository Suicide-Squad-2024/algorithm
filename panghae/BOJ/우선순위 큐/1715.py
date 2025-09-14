import sys
import heapq

read = sys.stdin.readline

N = int(read().rstrip())

cards = []

for _ in range(N):
    cards.append(int(read().rstrip()))

result = 0

heapq.heapify(cards)

while len(cards) != 1:
    item1 = heapq.heappop(cards)
    item2 = heapq.heappop(cards)

    result += item1 + item2
    heapq.heappush(cards, item1 + item2)

print(result)
