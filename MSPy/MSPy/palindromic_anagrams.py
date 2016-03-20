import math
import string

file_name = "test.txt"
 
f = open(file_name, 'r')
 
out_file = "out.txt"
fo = open(out_file, "w")


for line in f:
    s = line
    dic = {}
    alpha_list = list( string.ascii_lowercase)
    #print alpha_list
    #print len(alpha_list)
    for alpha in alpha_list:
        dic[alpha] = 0  
    for letter in s:
        if letter != "\n":
            dic[letter] += 1
    
    count_one = 0
    rm = 0
    fact = 1
    num_even_letters = 0
    for num in dic.values():
        if num != 0 and num % 2 == 0:
            num_even_letters += num / 2
            fact *= math.factorial(num / 2)
        elif num == 1:
            #print num
            if count_one == 0:
                count_one = 1
            else:
                rm += 1 
        elif num % 2 == 1:
            if count_one == 0:
                count_one = 1
            else:
                rm += 1             
            num_even_letters += (num - 1) / 2
            fact *= math.factorial((num - 1) / 2)
    #print dic
    #print str(num_even_letters) + "\t" + str(fact) + "\t" + str(rm)
    if rm == 0:
        fo.write("0," + str(math.factorial(num_even_letters) / fact) + "\n")
    else:
        fo.write(str(rm) + ","  + str(math.factorial(num_even_letters) / fact) + "\n" )
  

