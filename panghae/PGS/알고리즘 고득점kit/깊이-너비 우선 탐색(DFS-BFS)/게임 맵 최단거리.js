function solution(maps) {
    let answer = -1;

    const xLength = maps.length;
    const yLength = maps[0].length;

    const dx = [-1, 0, 1, 0];
    const dy = [0, 1, 0, -1];

    let q = [[[0, 0], 1]];

    while (q.length) {
        const [[x, y], count] = q.shift();

        for (let i = 0; i < 4; i += 1) {
            const nx = x + dx[i];
            const ny = y + dy[i];
            if (0 <= nx && nx < xLength && 0 <= ny && ny < yLength && maps[nx][ny] === 1) {
                if (nx === xLength - 1 && ny === yLength - 1) {
                    answer = count + 1;
                    q = [];
                    break;
                }
                q.push([[nx, ny], count + 1]);
                maps[nx][ny] = 0;
            }
        }
    }

    return answer;
}

console.log(solution([[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 1], [0, 0, 0, 0, 1]]));
console.log(solution([[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 0], [0, 0, 0, 0, 1]]));