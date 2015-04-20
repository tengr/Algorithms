def check_segment(input, start, end):
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
                elif input[i+1] == 'n' and cleanup[-1] == '|':
                    dic[i-1] = cleanup[:-1]
                    return dic
                else:
                    dic[-1] = ''
                    return dic
            else:
                dic[-1] = ''
                return dic
        elif ord(input[i]) < ord(' ') or ord(input[i]) > ord('~'):
            dic[-1] = ''
            return dic
        else:
            cleanup += input[i]
            i += 1
    return dic

def validate(input):
    res = check_segment(input, 0, len(input))
    if -1 in res:
        return '0:0:0:format_error'
    else:
        fl_end = res.keys()[0]
        first_line = input[1:fl_end]
        fnms = first_line.split('|')
        nmfnms = len(fnms)
        last_name = fnms[-1]
        records = 0
        nmfds = 0
        nonempty = 0
        names = {}
        pos = fl_end + 3
        while pos < len(input):
            res = check_segment(input, pos, len(input))
            if -1 in res:
                return '0:0:0:format_error'
            pos = res.keys()[0] + 3
            line = res.values()[0]
            print line
            fields = line.split('|')
            name = fields[0].strip().lower()
            if len(name) == 0 or name in names:
                return '0:0:0:format_error'
            else:
                names[name] = 1
            for f in fields:
                if len(f) > 0:
                    nonempty += 1
            records += 1
            nmfds = max(nmfds, len(fields))
        nmfds = max(nmfds, nmfnms)
        empty = records * nmfds - nonempty
        extra = nmfds - nmfnms
        if extra > 0:
            last_name += ('_'+str(extra))
        return str(records) + ":"+str(nmfds) + ":" + str(empty) + ":" + last_name

input = "|name|address|~n|Annie|a@b.com|sdsf.com|~n|brian|sdsdd|~n"
input = "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie||annie@test.com|~n"
#input = "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n"

print solution(input)
