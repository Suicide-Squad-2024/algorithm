

const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

// console.log(input)

const N = Number(input[0])
const half = N / 2

let team = []

for (let i = 1; i < input.length; i++) {
    team.push(input[i].split(' ').map(Number))
}

// console.log(team)

// combination을 활용
let check = new Array(N).fill(false);  // 스타트 팀에 포함 여부를 나타내는 배열

let f = []
let result = Infinity
function dfs(depth, index) {
    if (depth === half) { //종료조건은 스타트팀이 전체의 절반이 되었을때
        let startT = 0
        let linkT = 0
        for (let i = 0; i < N; i++) {
            for (let j = 0; j < N; j++) {
                if (check[i] && check[j]) {
                    startT += team[i][j]
                } else if (!check[i] && !check[j]) {
                    linkT += team[i][j]
                }
            }
        }

        const tmpR = Math.abs(startT - linkT)
        result = Math.min(result, tmpR)

        return
    }

    for (let i = index; i < N; i++) {
        if (!check[i]) {
            check[i] = true
            dfs(depth + 1, i + 1)
            check[i] = false
        }
    }
}
dfs(0, 0)
console.log(result)