def scramble(pres, s, res):
	if len(s) == 1:
		res.append(pres + s)
	for i in range(2, len(s)):
		scramble(s[:i], s[i:], res) + scramble(s[i:], s[:i], res)

s = raw_input()
res = []
scramble(s, res)
for ele in res:
	print res


