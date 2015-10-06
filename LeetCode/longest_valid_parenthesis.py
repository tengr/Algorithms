class Solution(object):


    def longestValidParentheses(s):
        """
        :type s: str
        :rtype: int
        """
        # Change to list
        result = 0
        left = 0
        right = 0
        l = 0
        r = 0
        last_valid = -1
        pre = ""
        if not s:
            return 0
        for char in s:
            if char == "(":
                left += 1
                l += 1
                if last_valid == 0:
                    last_valid = 1
            elif char == ")":
                right += 1
                r += 1
                # if(pre == "("):
                #     last_invalid = 0
                #     l = 0
                #     r = 0
                #print right
                if left >= right:
                    if last_valid > 0:
                        result = max(result, r * 2)
                    else:
                        result = max(result, right * 2)
                    last_valid = 0
                    l = 0
                    r = 0
                else:
                    left = 0
                    right = 0
                    l = 0
                    r = 0
                    if last_valid == 0:
                        last_valid = 1
            #if left < right: #already illegal

                #print "invalid"
            #elif left == right:
                # result = max(result, right * 2)
                # last_valid = 0
                # l = 0
                # r = 0
            #else:

            print str(result) +  "\t" + str(last_valid)
            pre = char
        # if last_valid > 0:
        #     result = max(result, r * 2)
        # else:
        #     result = max(result, right * 2)
        #print "right = " + str(right)
        # print result
        # print "l = " + str(l)
        # print "r = " + str(r)
        return result

    if __name__ == "__main__":
        s = "(()()"
        print longestValidParentheses(s)
        #print"SAdsf"   
                
