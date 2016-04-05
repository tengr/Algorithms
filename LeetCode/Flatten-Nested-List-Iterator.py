# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.l = nestedList
        sefl.currentList = None

    def next(self):
        """
        :rtype: int
        """
        if self.l.getList() is None:
            return self.l.getInteger()
        else:
            self.innerMostList = self.l.getList()
            return self.l.next(self.getList()[0]) 
            
    def getFirst(self):
        if self.l.getList() is None:
            return self.l.getInteger()
        else:
            return self.l.next(self.getList()[0])

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.l.getList() is not None or self.l.getInteger() is not None

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())

#test case
#[[1,1],2,[1,1]]