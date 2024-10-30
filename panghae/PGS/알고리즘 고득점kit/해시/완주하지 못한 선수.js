function solution(participant, completion) {
    let answer = '';
    const participant_obj = {};
    const completion_obj = {};

    for (const name of participant) {
        if (participant_obj[name]) {
            participant_obj[name] += 1
        } else {
            participant_obj[name] = 1
        }
    }

    for (const name of completion) {
        if (completion_obj[name]) {
            completion_obj[name] += 1
        } else {
            completion_obj[name] = 1
        }
    }

    Object.entries(participant_obj).forEach(([key, value]) => {
        if (completion_obj?.[key]) {
            if (completion_obj[key] !== value) {
                answer = key;
            }
        } else {
            answer = key;
        }
    });

    return answer
}

console.log(solution(["leo", "kiki", "eden"], ["eden", "kiki"]));
console.log(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]));
console.log(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]));