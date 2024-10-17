from collections import deque


def solution(n, computers):
    answer = 0

    visited = [False] * n

    for i in range(n):
        if not visited[i]:
            q = deque([i])

            while q:
                node = q.popleft()
                if not visited[node]:
                    visited[node] = True

                    for j, com in enumerate(computers[node]):
                        if not visited[j] and com == 1 and i != j:
                            q.append(j)

            answer += 1

    return answer


print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))