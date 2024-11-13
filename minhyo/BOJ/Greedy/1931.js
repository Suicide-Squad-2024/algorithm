const fs = require('fs')

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const N = Number(input[0])

let time = []

for (let i = 1; i < input.length; i++) {
    let tmp = input[i].split(' ').map(Number)
    time.push(tmp)
}

time.sort((a, b) => {
    if (a[1] !== b[1]) {
        return a[1] - b[1]
    } else {
        return a[0] - b[0]
    }
}); // 종료시간을 기준으로 오름차순


let count = 0
let lastEnd = 0

for (let i = 0; i < N; i++) {
    if (time[i][0] >= lastEnd) {
        count += 1
        lastEnd = time[i][1]
    }
}

console.log(count)