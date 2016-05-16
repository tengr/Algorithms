a = [1,2,3,4,5,6]
greater = True
for i in xrange(1, len(a)):
    if greater:
        if a[i] >= a[i-1]:
            pass
        else:
            temp = a[i]
            a[i] = a[i-1]
            a[i-1] = temp
    else:
        if a[i] <= a[i-1]:
            pass
        else:
            temp = a[i]
            a[i] = a[i-1]
            a[i-1] = temp
            
    greater = not greater

print a