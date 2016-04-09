s = ["1111", "1101"]
#dvs = [3,2,5,2,7,2,3,2,11];
#       2 3 4 5 6 7 8 9 10
dvs = " 3 2 5 2 7 2 3 2 11"
ss = set()
dic = {}

for i in xrange(16):
	res = ""
	#first bit
	res += s[i % 2]
	res += s[(i / 2) % 2]
	res += s[(i / 2 / 2) % 2]
	res += s[(i / 2 / 2 / 2) % 2]
	#ss.add(res)
	#print res + dvs
	dic[res] = dvs

#print ss
#print len(ss)

#print "1101110111011101" + " 13 2 3 2 11 2 17 2 3"
dic["1101110111011101"] =  " 13 2 3 2 11 2 17 2 3"
#print "1011101110111011" + " 11 2 3 2 223 2 17 2 3"
dic["1011101110111011"] = " 11 2 3 2 223 2 17 2 3"

s2 = ["10111101", "11011011"]
dvs2 = " 3 2 3 2 7 2 3 2 3"
for i in xrange(4):
	res = ""
	#first bit
	res += s2[i % 2]
	res += s2[(i / 2) % 2]
	#res += s[(i / 2 / 2) % 2]
	#ss.add(res)
	print res + dvs
	dic[res] = dvs

print len(dic)