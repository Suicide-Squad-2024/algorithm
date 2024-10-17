from collections import deque


def solution(begin, target, words):
    answer = 0

    if target not in words:
        return answer

    def count_difference(w1, w2):
        return sum(i != j for i, j in zip(w1, w2))

    q = deque([(begin, 0)])

    while q:
        word, count = q.popleft()

        if word == target:
            answer = count
            break

        for w in words:
            if count_difference(word, w) == 1:
                q.append((w, count + 1))

    return answer


print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]))
