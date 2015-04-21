import sys
import os
def convert(number):
    dic = ['0','a','t','l','s','i','n']
    sign = ''
    if number == 0:
        return '0'
    
    if number < 0:
        number = -number
        sign = '-'
    
    res = ''
    while number != 0:
        mod = number %7
        number = number / 7
        res = dic[mod] + res
    return sign + res
