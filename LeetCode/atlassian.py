for line in sys.stdin:
    left = 0
    right = len(line)
    if found == 0:#new find
        while(left <= right):
            if line[left:left+2] == "//":
                print line[left:]
                break
            elif line[left:left+2] == "/*":
                found = 1
            else:
                left += 1
        if found == 1:
            while right >= left + 4:
                if line[right-2:right] != "*/":
                    righ -= 1
            if right < left + 4:
                print line[left:]
            else:
                print line[left:right]
                found = 0
    elif found ==1:
        while right >= left + 2:
            if line[right-2:right] != "*/":
                righ -= 1
        if right < left + 2:
            print line[left:]
        else:
            print line[left:right]
            found = 0