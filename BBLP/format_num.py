#given an integer number num, it returns the a string representation of the number, comma separated.
#input a number, output a formated number, e.g. "1234" -> "1,234"


def format_nums(num):
	if num == 0:
		return "0"
	else:
		#handling negative number
		sign = ""
		if num < 0:
			num  = -num
			sign = "-"
		
		#handling floating point number
		decimal = ""
		if num != int(num): 
			decimal = str(num - int(num))[1:]
			num = int(num)

		num_digits = 0
		out = ""
		while True:
			if num == 0:
				break
			if (num_digits % 3 == 0 and num_digits != 0):
				out = "," + out
			digit = num - num / 10 * 10
			out = str(digit) + out
			num = num / 10
			num_digits += 1

		return sign + out + decimal

print format_nums(1234)
print format_nums(100000)
print format_nums(123123123)
print format_nums(0010010)
print format_nums(123123.123123)
print format_nums(-2342342.23452565)
