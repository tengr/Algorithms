def maxSubArray(nums):
    if not nums:
        return 0
    current_sum = 0
    max_seen = 0
    short_sum = 0
    for i in range(len(nums)):
        if nums[i] < 0:
            short_sum = 0
            if current_sum + nums[i] < 0:
                max_seen = max(max_seen, current_sum)
                current_sum = 0
            else:    
                current_sum += nums[i]
        else:
            short_sum + nums[i]
            max_seen = max(max_seen, short_sum)

    return max(max_seen, current_sum)


nums = [4, -1, 2, 1]
print  maxSubArray(nums)

