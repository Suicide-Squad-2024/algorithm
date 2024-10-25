import heapq


def solution(scoville, K):
    answer = 0
    scoville.sort()
    heapq.heapify(scoville)

    while True:
        value = heapq.heappop(scoville)
        if value >= K:
            break
        else:
            if not scoville:
                answer = -1
                break
            second_value = heapq.heappop(scoville)
            new = value + second_value * 2
            heapq.heappush(scoville, new)
            answer += 1

    return answer


print(solution([1, 2, 3, 9, 10, 12], 7))
