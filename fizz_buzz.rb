(1..100).each do |x|
	if x % 15 == 0
		print " Fizz Buzz,"
	elsif x % 3 == 0
		print " Fizz,"
	elsif x % 5 == 0
		print " Buzz,"
	else
		print " " + x.to_s + ","
	end
end