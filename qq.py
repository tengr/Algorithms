#! /usr/env/python
import numpy as np
patterns = [
    #无间隔
    ('AAAAAAAA', False),
    ('AAAAAAA*', False),
    ('AAAAAA**', False),
    ('AAAAA***', False),
    ('AAAA****', False),
    ('****AAAA', False),
    ('***AAAAA', False),
    ('**AAAAAA', False),
    ('*AAAAAAA', False),
    
    #1位间隔
    ('A*AAAAAA', False),
    ('AA*AAAAA', False),
    ('AAA*AAAA', False),
    ('AAAA*AAA', False),
    ('AAAAA*AA', False),
    ('AAAAAA*A', False),
    
    #2位间隔
    ('A**AAAAA', False),
    ('AA**AAAA', False),
    ('AAA**AAA', False),
    ('AAAA**AA', False),
    ('AAAAA**A', False),
    
    #3位间隔
    ('A***AAAA', False),
    ('AA***AAA', False),
    ('AAA***AA', False),
    ('AAAA***A', False),
    
    #4位重复数间隔
    ('ABBBBAAA', False),
    ('AABBBBAA', False),
    ('AAABBBBA', False),
    ('ABBBBABB', False),
    ('ACBBBBAC', False),
    
    #5位重复数间隔
    ('ABBBBBAA', False),
    ('ABBBBBAB', False),
    ('AABBBBBA', False),
    
    #6位重复数间隔
    ('ABBBBBBA', False),

    #三个不同数字
    ('AABBBCCC', False),
    ('AABBBBCC', False),
    ('AAABBCCC', False),
    ('AAABBBCC', False),
    
    #2位重叠 两个不同数字
    ('ABABABAB', False),
    ('ABABAB**', False),
    ('**ABABAB', False),
    ('ABABBABA', False),
    ('ABABAABB', False),
    
    #3位重叠 两个不同数字
    ('ABBABB**', False),
    ('**ABBABB', False),

    #4位重叠 两个不同数字
    ('ABBBABBB', False),
    ('AABBAABB', False),
    ('AAABAAAB', False),

    #2位重叠 三个不同数字
    ('AABBCC**', False),
    ('**AABBCC', False),
    ('*AABBCC*', False),

    #3位重叠（ABC包括非连续数重叠） 三个不同数字
    ('ABCABC**', False),
    ('**ABCABC', False),
    ('*ABCABC*', False),

    #2位重叠 四个不同数字
    ('AABBCCDD', False), #(ABCD包括非连续)

    #4位重叠 四个不同数字
    ('ABCDABCD', False),

    #8位连续
    ('ABCDEFGH', True),
    ('HGFEDCBA', True),
    ('ABCDABCD', True),
    ('DCBADCBA', True),
    
    #7位连续
    ('ABCDEFG*', True),
    ('GFEDCBA*', True),
    ('*ABCDEFG', True),
    ('*GFEDCBA', True),
    
    #6位连续
    ('ABCDEF**', True),
    ('FEDCBA**', True),
    ('**ABCDEF', True),
    ('**FEDCBA', True),

    #5位连续+3位连续
    ('ABCDEXYZ', True),
    ('ABCDEZYX', True),
    ('EDCBAXYZ', True),
    ('EDCBAZYX', True),
    ('XYZABCDE', True),
    ('XYZEDCBA', True),
    ('ZYXABCDE', True),
    ('ZYXEDCBA', True),

    #4位连续+重叠
    ('ABCDABCD', True),
    ('DCBADCBA', True),

    #4位连续+2位重复
    ('XXABCDYY', True),
    ]

def check(pattern, order, num):
    hs = {}
    num_set = set()
    for idx, ch in enumerate(pattern):
        if ch == '*':
            continue
        if ch not in hs:
            hs[ch] = []
            num_set.add(num[idx])
        hs[ch].append(idx)
    if len(num_set) != len(hs.keys()):
        return False    

    for idx_list in hs.values():
        s = set(num[idx] for idx in idx_list)
        if len(s) > 1:
            return False

    if order:
        pre = None
        for key in sorted(hs.keys()):
            if pre and ord(key) - ord(pre) == 1 and ord(num[hs[key][0]]) - ord(num[hs[pre][0]]) != 1:
                return False
            pre = key

    return True
#check('XXABCDYY', True, '13425333')
#print(any(check(pattern[0], pattern[1], '88888878') for pattern in patterns))
#result_set = set()
#candidate_set = set(("%08d" % i) for i in range(100000000))
arr = np.full(100000000,True,dtype=bool)
for pattern in patterns:
    i = 0
    while i < 100000000:
        if arr[i]:
            sstr = "%08d" % i
            if check(pattern[0], pattern[1], sstr):
                print(sstr)
                arr[i] = False
        i += 1