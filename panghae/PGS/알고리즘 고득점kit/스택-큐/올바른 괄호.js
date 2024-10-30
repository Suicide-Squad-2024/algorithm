function solution(s) {
    let answer = true;
    const q = [];

    for (const w of s.split('')) {
        if (w === '(') {
            q.push(w);
        } else {
            if (q.length) {
                q.pop();
            } else {
                answer = false;
                break;
            }
        }
    }

    if (q.length) {
        answer = false;
    }
    return answer;
}

console.log(solution("()()"));
console.log(solution("(())()"));
console.log(solution(")()("));
console.log(solution("(()("));