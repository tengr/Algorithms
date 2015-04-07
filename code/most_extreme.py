from audioop import avg
# def solution(a):
#     if len(a) == 0:
#         return -1
#     else:
#         avg = sum(a) * 1.0 / len(a)
#         ind = -1
#         diff = 0
#         for i in xrange(len(a)):
#             temp_diff = a[i] - avg
#             if temp_diff < 0:
#                 temp_diff = -temp_diff
#             print temp_diff
#             if temp_diff >= diff:
#                 diff = temp_diff
#                 ind = i
#     return ind

def solution(A):
    if len(A) == 0:
        return -1
    ind = 0
    s = A[0]
    min_ind = 0
    max_ind = 0
    for i in xrange(1,len(A)):
        s += A[i]
        if A[i] < A[min_ind:
            ind = i
        if 
        
    return ind 
    
    
test = [1,1,1,1]
print(solution(test))