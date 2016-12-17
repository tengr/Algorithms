import urllib2
import json
from random import randint

testcases = 1
members = 7
finances = 2

#API_key = "6971542F-3632-5E7F-D5730H3EG5278549"   #Kyogle Little Athletics Centre
API_key = "6971542G-3631-5F7F-E5730I3FH5278540" #Alpine Little Athletics

test_results = [None for x in range(testcases)]
for testcase in range(testcases):
    test_results[testcase] = [[x for i in range(finances)] for j in range(members)]
    for member in range(members):
        for finance in range(finances):
            url = "https://api.sportstg.com/index.cfm?method=getAllMembers&key=" \
                + API_key\
                + "&memberstatus=" + str(member) \
                + "&financialstatus=" + str(finance)
            resp = json.loads(urllib2.urlopen(url).read())
            test_results[testcase][member][finance] = resp

for member in range(members):
    for finance in range(finances):
        if(test_results[randint(0,testcases-1)][member][finance] != test_results[randint(0,testcases-1)][member][finance]):
            print("error")

tc =  test_results[0][0][0]["data"]
#check unfinancial
print "unfinancial"
for member in range(members):
    print str(len(test_results[0][member][0]["data"]))


print "\nfinancial"
for member in range(members):
    print str(len(test_results[0][member][1]["data"]))
# for ele in tc:
#     print ele
# print len(tc)
