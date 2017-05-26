def partition(ar): 
    if not ar or len(ar) < 2:
        print ' '.join(ar)
        return ""
    pivot = ar[0]
    i = 1
    j = len(ar) - 1
    while i < j:
        print i, j
        print ar
        while i < j and ar[i] <= pivot:
            i += 1
        while i < j and ar[j] >= pivot:
            j -= 1
        if i >= j:
            break
        else:
            temp = ar[i]
            ar[i] = ar[j]
            ar[j] = temp
    ar[0] = ar[i]
    ar[i] = pivot
    #print ar
    print ' '.join(map(str, ar[1:] + ar[:1]))
    return ""

partition([2,3,4,5,6])