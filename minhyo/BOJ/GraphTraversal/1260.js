const fs = require('fs');

const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');
const [N, M, V] = input[0].split(' ').map(Number);

let path = new Array(N).fill(null).map(() => []);

for (let i = 1; i <= M; i++) {
    let [u, v] = input[i].split(' ').map(Number);
    path[u - 1].push(v);
    path[v - 1].push(u);
}

// 정렬
for (let i = 0; i < N; i++) {
    path[i].sort((a, b) => a - b);


}

//console.log(path)



// DFS
let visitedDFS = new Array(N).fill(false);
let dfsResult = [];

function dfs(node) {
    visitedDFS[node] = true;
    dfsResult.push(node + 1);

    for (let neighbor of path[node]) { //forEach
        if (!visitedDFS[neighbor - 1]) {
            dfs(neighbor - 1);
        }
    }
}

// BFS
let visitedBFS = new Array(N).fill(false);
let bfsResult = [];

function bfs(start) {
    const queue = [start];

    visitedBFS[start] = true;

    while (queue.length > 0) {
        const node = queue.shift();
        bfsResult.push(node + 1);
        for (let neighbor of path[node]) {

            if (!visitedBFS[neighbor - 1]) {
                visitedBFS[neighbor - 1] = true;
                queue.push(neighbor - 1);
            }
        }
    }
}

dfs(V - 1);
bfs(V - 1);

console.log(dfsResult.join(' '));
console.log(bfsResult.join(' '));
