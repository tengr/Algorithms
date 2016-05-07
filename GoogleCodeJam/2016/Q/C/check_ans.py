S = set()
with open("C-large.500", "r") as f:
	for line in f:
		if "#" in line:
			continue
		if line[:32] in S:
			print "WA"
		else:
			S.add(line[:32])

print len(S)		