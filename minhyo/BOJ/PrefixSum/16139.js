const fs = require('fs');


const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n')


const S = input[0]
const q = Number(input[1])
const queries = input.slice(2);

const prefixSum = Array.from({ length: 26 }, () => Array(S.length + 1).fill(0));



// 누적 합 배열 채우기
for (let i = 0; i < S.length; i++) {
    const charCode = S.charCodeAt(i) - 97; // 'a'의 charCode는 97이므로 97을 뺀다
    for (let j = 0; j < 26; j++) {
        // j번째 알파벳의 누적합을 복사
        prefixSum[j][i + 1] = prefixSum[j][i];

    }// 마지막에 나온 친구는 누적 하지 않고 끝에만 더해주면 되기 때문에 먼저 for문을 돌림
    // 해당 위치의 문자를 반영하여 누적합 업데이트
    prefixSum[charCode][i + 1]++;
}

let result = [];
for (let i = 0; i < q; i++) {
    const [alpha, l, r] = queries[i].split(' ');
    const alphaIndex = alpha.charCodeAt(0) - 97; // 알파벳의 인덱스 계산
    // 구간 [l, r]에서 alpha가 등장한 횟수는 prefix[r+1] - prefix[l]
    const count = prefixSum[alphaIndex][Number(r) + 1] - prefixSum[alphaIndex][Number(l)]; //이전에 나온부분은 필요없기 때문에 - prefixSum[alphaIndex][Number(l)]
    result.push(count);
}

// 결과 출력
console.log(result.join('\n'));

// for(let i = 2; i<input.length; i++){
//     let tmp = input[i].split(' ')
//     let res = 0
//     for(let a = Number(tmp[1]); a<(Number(tmp[2])+1); a++){
//         if(S[a]===tmp[0]){
//             res++
//         }
//     }
//     console.log(res)
// } //첫번째 답 50점, 누적합을 사용하지 않았음