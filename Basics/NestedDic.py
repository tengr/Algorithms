import collections

def myprint(d):
  for k, v in d.iteritems():
    if isinstance(v, dict):
      myprint(v)
    else:
      print "{0} : {1}".format(k, v)

def nested_dict_iter(nested):
     for key, value in nested.iteritems():
         if isinstance(value, collections.Mapping):
             for inner_key, inner_value in nested_dict_iter(value):
                 yield inner_key, inner_value
         else:
             yield key, value
def myprin2(d):
    stack = d.items()
    while stack:
        k, v = stack.pop()
        if isinstance(v, dict):
            stack.extend(v.iteritems())
        else:
            print("%s: %s" % (k, v))


dic = {}
dic["key1"] = {}
dic["key1"]["key1.1"] = "value1"
dic["key2"]  = {}
dic["key2"]["key2.1"] = "value2"
dic["key2"]["key2.2"] = dic["key1"]
dic["key2"]["key2.3"] = dic

print dic
#print myprin2(dic)



#myprint(dic)


