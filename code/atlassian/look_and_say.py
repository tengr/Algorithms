import sys
import os

def LookAndSay(start, n):
    num_str = str(start)
    for i in range(n):
        num_str = LookAndSay1(num_str)
        print num_str
    return num_str
    
def LookAndSay1(start):
    if len(start) == 0:
        return ''
    else:
        digit = start[0]
        count = 1
        res = ''
        for i in range(1,len(start)):
            if start[i] == digit:
                count += 1
            else:
                res += (str(count) + digit)
                digit = start[i]
                count = 1
        res += (str(count) + digit)
        return res

print (LookAndSay(11, 2))