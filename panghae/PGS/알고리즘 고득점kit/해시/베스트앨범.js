function solution(genres, plays) {
    let answer = [];

    const genreObj = {}

    for (let i = 0; i < genres.length; i += 1) {
        const currentGenre = genres[i];
        const currentMusicPlayed = plays[i];

        if (genreObj[currentGenre]) {
            genreObj[currentGenre][1] += currentMusicPlayed;
            genreObj[currentGenre][0].push([i, currentMusicPlayed]);
            genreObj[currentGenre][0].sort((a, b) => {
                if (a[1] > b[1]) {
                    return -1;
                } else if (a[1] === b[1]) {
                    if (a[0] > b[0]) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return 1;
                }
            });
        } else {
            genreObj[currentGenre] = [[[i, currentMusicPlayed]], currentMusicPlayed];
        }
    }

    const sortedGenreObj = Object.entries(genreObj).sort((a, b) => {
        if (a[1][1] > b[1][1]) {
            return -1;
        } else {
            return 1;
        }
    })

    sortedGenreObj.forEach((value) => {
        answer.push(...value[1][0].slice(0, 2).map(value => value[0]));
    });

    return answer;
}

console.log(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]));
console.log(solution(["classic", "pop", "valad", "valad", "pop"], [2000, 10, 1900, 1900, 20]));
console.log(solution(["classic", "pop", "valad", "valad", "pop"], [2000, 10, 50, 1900, 20]));
console.log(solution(["classic", "pop", "valad", "valad", "valad", "pop"], [2000, 10, 300, 500, 500, 20]));