import heapq


def solution(jobs):
    added = 0
    time_spent = 0
    now = 0
    start = -1
    heap = []

    while added != len(jobs):
        for j in jobs:
            if start < j[0] <= now:
                heapq.heappush(heap, [j[1], j[0]])
        if heap:
            time, s = heapq.heappop(heap)
            start = now
            now += time
            time_spent += (now - s)
            added += 1
        else:
            now += 1
    return time_spent // len(jobs)


print(solution([[0, 3], [1, 9], [2, 6]]))
