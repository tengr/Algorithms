def check_segment(start, end):
    dic = {}
    if input[start] != '|':
        dic[-1] = ''
        return dic
    cleanup = ''
    i = start + 1
    while i < end:
        if input[i] == '~':
            if i + 1 < end :
                if input[i+1] == '~':
                    cleanup += 'a'
                    i += 2
                elif input[i+1] == '|':
                    cleanup += 'b'
                    i += 2
                elif input[i+1] == 'n' and input[i-1] == '|':
                    dic[i] = cleanup
                    return dic
                else:
                    return -1
            else:
                dic[-1] = ''
                return dic
        elif ord(input[i]) < ord(' ') or ord(input[i]) > ord('~'):
            return -1
        else:
            cleanup += line[i]
            i += 1
    return dic

def solution(input):
    lines = input.split('~n')
    first_line = lines[0]
    get_line = check_line(first_line)
    if len(get_line) == 0:
        return '0:0:0:format_error'
    else:   
        fnms = get_line.split('|')
        nmfnms = len(fnms)
        last_name = fnms[-1]
        lines.pop(0)
        if len(lines[-1]) == 0:
            lines.pop(-1)
        records = 0
        nmfds = 0
        nonempty = 0
        names = {}
        for line in lines:
                get_line = check_line(line)
                if len(get_line)  == 0:
                    return '0:0:0:format_error'
                else:
                    records += 1
                    fields = get_line.split('|')
                    name = fields[0].strip().lower()
                    if len(name) == 0 or name in names:
                        return '0:0:0:format_error'
                    else:
                        names[name] = 1
                    for f in fields:
                        if len(f) > 0:
                            nonempty += 1
          
                    nmfds = max(nmfds, len(fields))
    empty = records * nmfds - nonempty
    extra = nmfds - nmfnms
    if extra > 0:
        last_name += ('_'+str(extra))
    
    return str(records) + ":"+str(nmfds) + ":" + str(empty) + ":" + last_name

input = "|name|address|~n|Annie|a@b.com|sdsf.com|~n|brian|sdsdd|~n"
input = "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie||Annie@test.com|~n"

print solution(input)
