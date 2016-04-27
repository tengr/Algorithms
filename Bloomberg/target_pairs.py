import unittest

class MyTest(unittest.TestCase):


	def target_pairs(self, nums, target):
		dic = {}
		res = []

		for num in nums:
			if num in dic:
				dic[num] += 1
			else:
				dic[num] = 1

			if target - num in dic and dic[target - num] > 0:
				res.append((num, target - num))
				dic[target - num] -= 1
				dic[num] -= 1
		return res

	# dic = {}
	# res = []
	def test_target_pairs(self):
		self.assertEqual(self.target_pairs(target_pairs([1,3,2,9,5],5), [(2,3)]))
		print "end"
	# for num in nums:
	# 	if target - num in dic:
	# 		if dic[target - num] == "expected":
	# 			res.append((target - num, num))
	# 			dic[target - num] = ""
	# 	else:
	# 		dic[target - num] = "expected"
	# 	print dic

	# 	# if target - num in dic and dic[target - num] == "waiting":
	# 	# 	res.append((num, target - num))
	# 	# 	dic[target - num] = ""
	# 	# else:
	# 	# 	dic[num] = "waiting"
	# 	#print dic
	# return res

	if __name__ == '__main__':
	    #unittest.main()
	    self.test_target_pairs()
	    assertEqual(self.target_pairs(target_pairs([1,3,2,9,5],5), [(1,0)]))
	 #    print target_pairs([1,3,2,9,5],5)
		# assertEqual(target_pairs([1,3,2,9,5],5), [(2,3)])
		# print target_pairs([3,2,3,2],5)
		# print target_pairs([1,2,3,5,7],5)
		# print target_pairs([1,3,3,1],4)
		# print target_pairs([4,4,4,4,1,1,1,1,1,1],5)
		# print target_pairs([2,3,2,2,3],5)
