#ord('~')

input = "|name|address|~n|Annie|a@b.com|sdsf.com|~n|brian|sdsdd|~n"
input = "|name|address|~n|Patrick|patrick@test.com|~~pat@test.com|~n|Annie|Annie@test.com|~n"

pos = input.find('|~n',1)
fnms = input[1:pos].split('|')
nmfnms = len(fnms)
last_name = fnms[-1]

# print (fnms[-1])

# print (len(fnms))

# print (input[pos+4])

records = 0
nmfds = 0
nonempty = 0
while True:
    start = pos + 4
    pos = input.find('|~n', start)
    if pos < 0:
        break
    else:
        records += 1
        line = input[start:pos]
        fields = line.split('|')
        if len(fields) > nmfds:
            nmfds = len(fields)
        if len(fields[0]) == 0:
            print("0:0:0:format_error")
        
        for field in fields:
            if len(field) > 0:
                nonempty += 1
                for i in range(len(field)):
                    if ord(field[i]) < ord(' ') or ord(field[i]) >= ord('~'):
                        print("0:0:0:format_error")


empty = records * nmfds - nonempty
extra = nmfds - nmfnms

if extra > 0:
    last_name += ('_'+str(extra))

print(str(records) + ":"+str(nmfds) + ":" + str(empty) + ":" + last_name)




#print("|name|address|Annie|sdsf|~n".split("|"))

# print (inst[1:inst.find("|~n")].split("|"))

# start = inst.find("|~n") + 4
# pos = inst[start:].find("|~n")

# print(inst[start:pos])

# print (inst[start:pos].split("|"))

# print(inst[start:pos].split("|"))

# line = inst[start:pos]

# fields = line.split("|")

# print (len(fields))
# print (fields[0])
