from collections import deque


def solution(numbers, target):
    answer = 0
    q = deque()

    q.append((0, 0))

    while q:
        num, index = q.popleft()

        if index == len(numbers):
            answer += 1 if num == target else 0
        else:
            q.append((num + numbers[index], index+1))
            q.append((num - numbers[index], index+1))

    return answer


print(solution([1, 1, 1, 1, 1], 3))
print(solution([4, 1, 2, 1], 4))
