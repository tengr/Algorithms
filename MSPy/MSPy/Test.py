import math
import string

file_name = "test.txt"
 
f = open(file_name, 'r')
 
out_file = "out.txt"
fo = open(out_file, "w")
sep = "//----"
l = []
for line in f:
    if "Unused" in line:
        pass
    elif "; //Used" in line:
        l.append(line[:-9])
        l.sort()  
        #print line[:-9]  
    elif sep in line:
        for ele in l:
            fo.write(ele + "; //Used\n")
        fo.write(line)
        l = []

