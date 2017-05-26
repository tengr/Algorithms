# dic = {}
# dic["key1"] = {}
# dic["key1"]["key1.1"] = "value1"
# dic["key2"]  = {}
# dic["key2"]["key2.1"] = "value2"
# dic["key2"]["key2.2"] = dic["key1"]
# dic["key2"]["key2.3"] = dic

# # def myprint(d):
# #       for k, v in d.iteritems():
# #         if isinstance(v, dict):
# #           myprint(v)
# #         else:
# #           print "{0} : {1}".format(k, v)



# def myprint(d):
#     stack = d.items()
#     visited = set()
#     while stack:
#         k, v = stack.pop()
#         if isinstance(v, dict):
#         	if k not in visited:
#         		stack.extend(v.iteritems())
#         else:
#         	print("%s: %s" % (k, v))
#        	visited.add(k)

# # def myprint(d):
# #       for k, v in d.iteritems():
# #         if isinstance(v, dict):
# #           myprint(v)
# #         else:
# #           print "{0} : {1}".format(k, v)


# myprint(dic)


# #print写入txt是真么写/
# donelist = []
# total = 0
# i = 0
# #f=open('demo.txt','w')
# while i < 100000000:
#     sstr = "%08d" % i
#     print (sstr)
#     total += 1
#     if total > 100:
#         break
#     i += 1
#     # if p1.match(sstr) or \
#     #    p2.match(sstr) or \
#     #    p3.match(sstr) or \
#     #    p4.match(sstr) or \
#     #    p5.match(sstr):
#     #     total += 1
#     #     print (sstr)
#     # if total >= 10000000:
#     #     break
#     # i += 1
# #f.write('total = ', total)
# #f.close

patterns = [
    #无间隔
    'AAAAAAAA',
    'AAAAAAA*',
    'AAAAAA**',
    'AAAAA***',
    'AAAA****',
    '****AAAA',
    '***AAAAA',
    '**AAAAAA',
    '*AAAAAAA',
    
    #1位间隔
    'A*AAAAAA',
    'AA*AAAAA',
    'AAA*AAAA',
    'AAAA*AAA',
    'AAAAA*AA',
    'AAAAAA*A',
    
    #2位间隔
    'A**AAAAA',
    'AA**AAAA',
    'AAA**AAA',
    'AAAA**AA',
    'AAAAA**A',
    
    #3位间隔
    'A***AAAA',
    'AA***AAA',
    'AAA***AA',
    'AAAA***A',
    
    #4位重复数间隔
    'ABBBBAAA',
    'AABBBBAA',
    'AAABBBBA',
    'ABBBBABB',
    'ACBBBBAC',
    
    #5位重复数间隔
    'ABBBBBAA',
    'ABBBBBAB',
    'AABBBBBA',
    
    #6位重复数间隔
    'ABBBBBBA',

    #三个不同数字
    'AABBBCCC',
    'AABBBBCC',
    'AAABBCCC',
    'AAABBBCC',
    
    #2位重叠 两个不同数字
    'ABABABAB',
    'ABABAB**',
    '**ABABAB',
    'ABABBABA',
    'ABABAABB',
    
    #3位重叠 两个不同数字
    'ABBABB**',
    '**ABBABB',

    #4位重叠 两个不同数字
    'ABBBABBB',
    'AABBAABB',
    'AAABAAAB',

    #2位重叠 三个不同数字
    'AABBCC**',
    '**AABBCC',
    '*AABBCC*',

    #3位重叠（ABC包括非连续数重叠） 三个不同数字
    'ABCABC**',
    '**ABCABC',
    '*ABCABC*',

    #2位重叠 四个不同数字
    'AABBCCDD', #(ABCD包括非连续)

    #4位重叠 四个不同数字
    'ABCDABCD',

    #8位连续
    'ABCDEFGH',
    'HGFEDCBA',
    'ABCDABCD',
    'DCBADCBA',
    
    #7位连续
    'ABCDEFG*'
    'GFEDCBA*'
    '*ABCDEFG'
    '*GFEDCBA'
    
    #6位连续
    'ABCDEF**'
    'FEDCBA**'
    '**ABCDEF'
    '**FEDCBA'

    #5位连续+3位连续
    'ABCDEXYZ'
    'ABCDEZYX'
    'EDCBAXYZ'
    'EDCBAZYX'
    'XYZABCDE'
    'XYZEDCBA'
    'ZYXABCDE'
    'ZYXEDCBA'

    #4位连续+重叠
    'ABCDABCD'
    'DCBADCBA'

    #4位连续+2位重复
    'XXABCDYY'

    

    

    

    


    


    ]