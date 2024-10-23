const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, M, K] = input[0].split(' ').map(Number)

let board = []

for (let i = 0; i < N; i++) {
    board.push(input[i + 1].split(''));
}

let bFirst = Array.from(Array(N), () => new Array(M).fill(0))
let wFirst = Array.from(Array(N), () => new Array(M).fill(0))


for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
        if ((i + j) % 2 === 0) {
            if (board[i][j] !== 'B') bFirst[i][j] = 1;
            if (board[i][j] !== 'W') wFirst[i][j] = 1;
        } else { // 홀수 좌표
            if (board[i][j] !== 'W') bFirst[i][j] = 1;
            if (board[i][j] !== 'B') wFirst[i][j] = 1;
        }
    }
}
//B로시작할 때 W로 시작할 때 2가지를 나누어서 누적합을 구함 -> K*K로 나누어서 누적합이 가장 작은 값을 구함, 누적합 아이디어를 미리 알고 있어서 빨리 풀 수 있었던거 같음..
prefixSum = Array.from(Array(M + 1), () => new Array(N + 1).fill(0))


let bFirstSum = Array.from(Array(N + 1), () => new Array(M + 1).fill(0));
let wFirstSum = Array.from(Array(N + 1), () => new Array(M + 1).fill(0));

for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= M; j++) {
        bFirstSum[i][j] = bFirstSum[i - 1][j] + bFirstSum[i][j - 1] - bFirstSum[i - 1][j - 1] + bFirst[i - 1][j - 1];
        wFirstSum[i][j] = wFirstSum[i - 1][j] + wFirstSum[i][j - 1] - wFirstSum[i - 1][j - 1] + wFirst[i - 1][j - 1];
    }
}

let minChanges = Infinity;

for (let i = 0; i <= N - K; i++) {
    for (let j = 0; j <= M - K; j++) {
        let bChanges = bFirstSum[i + K][j + K] - bFirstSum[i][j + K] - bFirstSum[i + K][j] + bFirstSum[i][j];
        let wChanges = wFirstSum[i + K][j + K] - wFirstSum[i][j + K] - wFirstSum[i + K][j] + wFirstSum[i][j];

        minChanges = Math.min(minChanges, bChanges, wChanges);
    }
}

console.log(minChanges);