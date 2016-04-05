class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.nums = nums
        self.sums = [None for x in xrange(len(nums) + 1)]

    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        if j < i:
            return 0
            
        if j == i:
            return self.nums[j]
        
        if self.sums[j + 1] is not None:
            return self.sums[j + 1] - self.sums[i]
        
        self.sums[0] = 0
        #sum[i] := sums from nums[0] to nums[i-1]
        for ii in xrange(1, len(self.sums)):
            self.sums[ii] = self.nums[ii-1] + self.sums[ii-1]
        
        print self.sums

        return self.sums[j + 1] - self.sums[i]


# Your NumArray object will be instantiated and called as such:
numArray = NumArray([-2,0,3,-5,2,-1])
print numArray.sumRange(0, 2)
print numArray.sumRange(2, 5)
print numArray.sumRange(0, 5)