const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, M] = input[0].split(' ').map(Number)

let board = []

for (let i = 0; i < N; i++) {
    board.push(input[i + 1].split(' ').map(Number));
}

let prefixSum = Array.from(Array(N + 1), () => Array(N + 1).fill(0));

for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
        prefixSum[i][j] = board[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
    }
}
// 기존의 아이디어 ->  누적합이 아니라 보드의 범위를 구해서 계산 -> 시간초과, 누적합 사용
let xy = [];
for (let i = N; i < N + M; i++) {
    xy.push(input[i + 1].split(' ').map(Number));
}

for (let i = 0; i < M; i++) {
    const [x1, y1, x2, y2] = xy[i];

    let result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    console.log(result);
}