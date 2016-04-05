import sys
for line in sys.stdin:
    found = 0
    left = 0
    right = len(line)
    if found == 0:#new find
        while left <= right:
            if line[left:left+2] == "//":
                print line[left:]
                break
            elif line[left:left+2] == "/*":
                found = 1
                break
            else:
                left += 1
        if found == 1:
            while right >= left + 4:
                if line[right-2:right] == "*/":
                    break
                else:
                    right -= 1
            if right < left + 4:
                print line[left:]
            else:
                print line[left:right]
                found = 0
    elif found ==1:
        while right >= left + 2:
            if line[right-2:right] == "*/":
                break
            else:
                righ -= 1
        if right < left + 2:
            print line[left:]
        else:
            print line[left:right]
            found = 0