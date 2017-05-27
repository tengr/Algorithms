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
    for idx, ch in enumerate(pattern):
        if ch == '*':
            continue
        if ch not in hs:
            hs[ch] = []
        hs[ch].append(idx)
    #print(hs)
    for idx_list in hs.values():
        s = set()
        for idx in idx_list:
            s.add(num[idx])
            if len(s) > 1:
                return False
    if order:
        keys = sorted(hs.keys())
        pre = None
        for k in keys:
            if pre:
                if num[hs[pre][0]] >= num[hs[k][0]]:
                    return False
            pre = k
    #print(hs)
    #print(keys)
    return True
#check('XXABCDYY', True, '13425333')

i = 0
total = 0
while i < 100000000:
    sstr = "%08d" % i
    #print (sstr)
    # total += 1
    # if total > 100:
    #    break
    if any(check(pattern[0], pattern[1], sstr) for pattern in patterns):
        print(sstr)
    i += 1
#     # total += 1
#     # if total > 100:
#     #     break