const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')

const [N, M] = input[0].split(' ').map(Number)

const A = input[1].split(' ').map(Number)

let prefixSum = new Array(N + 1).fill(0); //[0]은 0이라고생각
let modCount = new Array(M).fill(0);
modCount[0] = 1;  // 처음 누적합이 0인 경우도 포함해야 함

let count = 0;
for (let i = 0; i < N; i++) {
    prefixSum[i + 1] = (prefixSum[i] + A[i]) % M;

    // 동일한 나머지를 가진 구간의 개수 누적
    count += modCount[prefixSum[i + 1]];


    // 현재 나머지를 배열에 기록
    modCount[prefixSum[i + 1]]++;
}

console.log(count);