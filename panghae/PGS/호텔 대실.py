def solution(book_time):
    def change_min(str_time):
        return int(str_time[0:2]) * 60 + int(str_time[3:])

    book_times = sorted([[change_min(i[0]), change_min(i[1]) + 10] for i in book_time])

    rooms = []

    for time in book_times:
        if not rooms:
            rooms.append(time)
            continue

        for index, room in enumerate(rooms):
            if time[0] >= room[-1]:
                rooms[index] = room + time
                break
        else:
            rooms.append(time)

    return len(rooms)
