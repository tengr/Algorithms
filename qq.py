#! /usr/env/python
from itertools import permutations, combinations, combinations_with_replacement
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

def set_stars(star_list, arrs, result_set):
    if len(star_list) == 0:
        for arr in arrs:
            result_set.add(''.join(arr))
    for combination in combinations_with_replacement(num_str, len(star_list)):
        for permutation in permutations(''.join(combination)):
            for arr in arrs:
                new_arr = [ch for ch in arr]
                for idx, ch in enumerate(permutation):
                    new_arr[star_list[idx]] = ch
                result_set.add(''.join(new_arr))

def set_chars(char_map):
    res_list = []
    for permutation in permutations(num_str, len(char_map)):
        arr = [''] * 8
        for ch, key in zip(permutation, char_map):
            idx_list = char_map[key]
            for idx in idx_list:
                arr[idx] = ch
        res_list.append(arr)
    return res_list

def set_chars_in_place(res_list):
    res_list_total = []
    for res in res_list:
        char_map, star_list = init(res)
        for permutation in permutations(num_str, len(char_map)):
            arr = [ch for ch in res]
            for ch, key in zip(permutation, char_map):
                idx_list = char_map[key]
                for idx in idx_list:
                    arr[idx] = ch
            res_list_total.append(arr)
    return res_list_total

def sequence_gen(char_map, pattern):
    res_list = []
    arr = [ch for ch in pattern]
    offset1 = 0
    seq1 = set()
    while chr(ord('A') + offset1) in char_map:
        seq1.add(chr(ord('A') + offset1))
        offset1 += 1
    offset1 = 10 - offset1
    while offset1 >= 0:
        arr1 = [str(offset1 + ord(ch) - ord('A')) if ch in seq1 else ch for ch in arr]
        if 'X' in char_map:
            offset2 = 0
            seq2 = set()
            while chr(ord('X') + offset2) in char_map:
                seq2.add(chr(ord('X') + offset2))
                offset2 += 1
            offset2 = 10 - offset2
            while offset2 >= 0:
                arr2 = [str(offset2 + ord(ch) - ord('X')) if ch in seq2 else ch for ch in arr1]
                res_list.append(arr2)
                offset2 -= 1
        else:
            res_list.append(arr1)
        offset1 -= 1
    return res_list

def init(pattern):
    char_map = {}
    star_list = []
    for idx, ch in enumerate(pattern):
        if ch == '*':
            star_list.append(idx)
        elif ch.isalpha():
            if ch not in char_map:
                char_map[ch] = []
            char_map[ch].append(idx)
    return char_map, star_list  

num_str = '0123456789'
result_set = set()

for pattern, order in patterns:
    char_map, star_list = init(pattern)
    if order is None:
        pattern = pattern.replace('X','Z')
        char_map, star_list = init(pattern)
        res_list = sequence_gen(char_map, pattern)
        res_list_total = set_chars_in_place(res_list)
        set_stars(star_list, res_list_total, result_set)
    elif order:
        res_list = sequence_gen(char_map, pattern)
        set_stars(star_list, res_list, result_set)
    else:
        res_list = set_chars(char_map)
        set_stars(star_list, res_list, result_set)

for result in sorted(result_set):
    if len(result) != 8:
        print ('ill formatted result')
    print(result)

# print("order")
# for _ in result_set_order:
#     if len(_) != 8:
#         print(_)
# print("not order")
# for _ in result_set_not_order:
#     if len(_) != 8:
#         print(_)
