import sys
import os

def compute( instructions):
    res = [0,0,0,0,0,0,0,0,0,0]
    dic = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F']
    pos = 0
    num = 1
    for i in range(len(instructions)):
        inst = instructions[i]
        if inst == 'P':
            pos = 0
            num = 1
        elif inst == 'M':
            if pos < 9:
                pos += 1
        elif inst == 'L':
            if res[pos] < 15 and num > 0:
                res[pos] += 1
                num = 0
    out = ''
    for j in range(len(res)):
        out += dic[res[j]]
    return out