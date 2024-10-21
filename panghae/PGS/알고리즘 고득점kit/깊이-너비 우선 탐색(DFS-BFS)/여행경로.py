from collections import deque, defaultdict


def solution(tickets):
    node_map = defaultdict(list)

    for ticket in tickets:
        origin, destination = ticket
        node_map[origin].append(destination)

    for key in node_map.keys():
        node_map[key].sort(reverse=True)

    stack = deque(['ICN'])

    travel = []
    while stack:
        current = stack.pop()

        if node_map[current]:
            stack.append(current)
            stack.append(node_map[current].pop())
        else:
            travel.append(current)

    travel.reverse()

    return travel


print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]))
