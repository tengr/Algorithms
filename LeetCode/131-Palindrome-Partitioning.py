def partition(s):
    """
    :type s: str
    :rtype: List[List[str]]
    """
    if s is None or len(s) == 0:
        return [[]]
    res = []
    dic = {}
    dic[len(s) - 1] = [list(s)]    
    for i in reversed(xrange(len(s) - 1)):
        if i + 1 in dic:
            l = dic[i + 1] #list of list of strings with i+1 stops
            for ll in l:
                for j in xrange(1, len(ll)):
                    if ll[j] == ll[j-1]:
                        temp = list(ll)
                        temp[j] = temp[j] + temp[j]
                        temp.pop(j-1)
                        if i in dic:
                            if temp not in dic[i]:
                                dic[i].append(temp)
                        else:
                            dic[i] = [temp]
        if i + 2 in dic:
            l = dic[i + 2]
            for ll in l:
                for j in xrange(1, len(ll)):
                    if j + 1 <= len(ll) - 1 and ll[j - 1] == ll[j + 1]:
                        temp = list(ll)
                        temp[j - 1] = temp[j - 1] +  temp[j] + temp[j + 1]
                        temp.pop(j)
                        temp.pop(j)
                        if i in dic:
                            if temp not in dic[i]:
                                dic[i].append(temp)
                        else:
                            dic[i] = [temp]

    for k in dic:
        for ele in dic[k]:
            res.append(ele)
    #print dic
    return res

print partition("ababababababababababababcbabababababababababababa")