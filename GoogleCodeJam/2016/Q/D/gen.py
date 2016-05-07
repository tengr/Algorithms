K = 2
C = 3

def gen(s):
	temp = s
	for i in range(C - 1):
		s = s.replace("G", K * "G")
		s = s.replace("L", temp)
	return s


pattern = ["L", "G"]
for i in xrange(2 ** K):
	res = ""
	for x in xrange(K):
		res += pattern[i % 2]
		i /= 2 
	print gen(res)
	#print "SDFSFD"