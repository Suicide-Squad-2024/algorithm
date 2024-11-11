

const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split(' ').map(Number)


for (i = -999; i < 1000; i++) {
    for (j = -999; j < 1000; j++) {
        if (input[0] * i + input[1] * j === input[2] && input[3] * i + input[4] * j === input[5]) {
            console.log(i, j)
        }
    }
}