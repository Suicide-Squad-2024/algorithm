const fs = require('fs');

// N은 체스판의 크기 (N x N)
const N = Number(fs.readFileSync("/dev/stdin").toString().trim());


let path = new Array(N).fill(0)

let res = 0

function isSafe(depth, col) { // 현재 퀸이 (depth, col)에 놓일 수 있는지 체크
    for (let i = 0; i < depth; i++) {
        if (path[i] === col || Math.abs(path[i] - col) === Math.abs(i - depth)) {
            return false// 같은 열이거나, 대각선에 위치할 경우 false
        }
    }
    return true;
}

function dfs(depth) {
    if (depth === N) {
        res++;
        return;
    }
    for (let col = 0; col < N; col++) {
        if (isSafe(depth, col)) {
            path[depth] = col; // 현재 행(depth)에 col 열에 퀸을 놓음
            dfs(depth + 1); // 다음 행으로 진행
        }
    }
}

dfs(0);
console.log(res);