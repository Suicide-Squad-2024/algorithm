import sys

read = sys.stdin.readline

# 플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면 새로운 방을 생성하고 입장시킨다.
# 이떄 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능하다.

# 입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기시킨다.
# 이때 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장한다.

# 방의 정원이 모두 차면 게임을 시작시킨다.

player_count, room_max_person = map(int, read().rstrip().split())

rooms = []

for _ in range(player_count):
    level, name = map(str, read().rstrip().split())
    level = int(level)
    if len(rooms):
        inserted = False
        for room in rooms:
            if room['level_range_start'] <= level <= room['level_range_end'] and len(
                    room['participant']) < room_max_person:
                room['participant'].append([level, name])
                inserted = True
                break
        if not inserted:
            rooms.append({'level_range_start': level - 10 if level - 10 >= 1 else 1,
                          'level_range_end': level + 10 if level + 10 <= 500 else 500, 'participant': [[level, name]]})

    else:
        rooms.append({'level_range_start': level - 10 if level - 10 >= 1 else 1,
                      'level_range_end': level + 10 if level + 10 <= 500 else 500, 'participant': [[level, name]]})

for room in rooms:
    if len(room['participant']) == room_max_person:
        print('Started!')
    else:
        print('Waiting!')
    result = sorted(room['participant'], key=lambda x: x[1])

    for r in result:
        print(r[0], r[1])
