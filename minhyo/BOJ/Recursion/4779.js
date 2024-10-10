

const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

input.forEach(a => {
    let len = 3 ** Number(a)
    let tmp = new Array(len).fill('-')

    function kanto(start, length) {

        if (length === 1) return //종료조건은 3으로 나눴을때 1 즉 N만큼 반복

        let part = length / 3

        for (let i = start + part; i < start + 2 * part; i++) {
            tmp[i] = ' ';
        }
        kanto(start, part); //왼쪽
        kanto(start + 2 * part, part); //오른쪽
    }

    kanto(0, len);

    console.log(tmp.join(''))
})