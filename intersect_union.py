# /usr/env/python
a = [1,1,2,2,2,3,3,4,4,4]
b = [2,2,4,4,4,4,6,6,8,8,8]

inter = []
union = []
ptrA = 0
ptrB = 0
#use b as dic
while ptrA < len(a) or ptrB < len(b):
	while ptrA + 1 < len(a) and a[ptrA] == a[ptrA+1]:
		ptrA += 1
	while ptrB + 1 < len(b) and b[ptrB] == b[ptrB+1]:
		ptrB += 1
	if ptrA >= len(a):
		union.append(b[ptrB])
		ptrB += 1
		continue
	if ptrB >= len(b):
		union.append(a[ptrA])
		ptrA += 1
		continue
	if a[ptrA] == b[ptrB]:
		inter.append(a[ptrA])
		union.append(a[ptrA])
		ptrA += 1
		ptrB += 1
	elif a[ptrA] > b[ptrB]:
		union.append(b[ptrB])
		ptrB += 1
	else:
		union.append(a[ptrA])
		ptrA += 1
print inter
print union