import math
def calc(x, y, k):
	#return 'V' * (k / y) + 'H' * (x - k / y - 1) + 'H' + 'V' * (y - k % y)
	res = ""
	while True:		
		fact_x_y = math.factorial(x + y)
		fact_x = math.factorial(x)
		fact_y = math.factorial(y)
		total = fact_x_y / fact_x / fact_y #choosing x from x + y
		
		first_half = (fact_x_y / (x + y) ) / (fact_x / x) / fact_y #choosing x - 1 from x + y - 1, picking x
		second_half = total - first_half
		# print first_half
		# print second_half
		# print total
		if k + 1 <= first_half:
			res += "H"
			x -= 1
		else:
			res += "V"
			k -= first_half
			y -= 1

		if x == 0:
			res += y * "V"
			break
		if y == 0:
			res += x * "H"
			break

		#print "ASDFASF"
	return res

# 	print calc(2,2,0)
#print calc(2,2,1)
# print calc(2,2,2)
# print calc(2,2,3)
# print cacl(2,2,4)

for i in xrange(0, 12):
	print calc(3,4,i)