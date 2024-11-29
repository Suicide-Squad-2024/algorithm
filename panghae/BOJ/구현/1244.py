import sys
from typing import Final

read = sys.stdin.readline

MALE: Final = 1
FEMALE: Final = 2


def convert(str):
    return bool(int(str))


switch_count = int(read().rstrip())

switch_status = list(map(convert, read().rstrip().split()))

N = int(read().rstrip())

for _ in range(N):
    sex, switch_num = map(int, read().rstrip().split())
    if sex == MALE:
        for i in range(switch_num - 1, switch_count, switch_num):
            switch_status[i] = not switch_status[i]
    elif sex == FEMALE:
        cur = 1
        switch_num -= 1
        switch_status[switch_num] = not switch_status[switch_num]
        while 0 <= switch_num - cur and switch_num + cur < switch_count and switch_status[switch_num - cur] == \
                switch_status[switch_num + cur]:
            switch_status[switch_num - cur] = not switch_status[switch_num - cur]
            switch_status[switch_num + cur] = not switch_status[switch_num + cur]
            cur += 1

for i in range(0, switch_count, 20):
    print(*map(int, switch_status[i:i + 20]))
