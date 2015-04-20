#ord('~')

input = "|name|address|~n|Annie|a@b.com|sdsf.com|~n|brian|sdsdd|~n"
input = "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|Annie@test.com|~n"

if input[0] != '|':
    print("0:0:0:format_error")
pos = input.find('|~n',1)
if pos < 0:
    print("0:0:0:format_error")

    
fnms = input[1:pos].split('|')
nmfnms = len(fnms)
last_name = fnms[-1]

records = 0
nmfds = 0
nonempty = 0
names = []
while True:
    start = pos + 4
    pos = input.find('|~n', start)
    if pos < 0:
        if start >= len(input):
            break
        else:
            print("0:0:0:format_error")
    else:
        records += 1
        line = input[start:pos]
        fields = line.split('|')
        if len(fields) > nmfds:
            nmfds = len(fields)
        if len(fields[0]) == 0 or fields[0] in names:
            print("0:0:0:format_error")
        else:
            print(fields[0])
            names.append(fields[0])
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

