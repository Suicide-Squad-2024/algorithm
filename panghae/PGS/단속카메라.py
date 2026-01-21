import math


def solution(routes):
    routes.sort(key=lambda x: x[1])

    camera_count = 0
    cur_camera_pos = math.inf

    for route in routes:
        start, end = route
        if cur_camera_pos == math.inf:
            cur_camera_pos = end
            camera_count += 1
        else:
            if start <= cur_camera_pos:
                continue
            else:
                cur_camera_pos = end
                camera_count += 1

    return camera_count
