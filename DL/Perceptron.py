#!/usr/env/python
# Single Layer Perceptron training for a simple AND gate

def step(val):
	return 1 if val > 0 else 0

def cross_prod(a, b):
	return sum(x*y for (x,y) in zip(a,b))

train_data = []
train_data.append([1,0,0])
train_data.append([1,1,1])
train_data.append([0,1,0])
train_data.append([0,0,0])

w = [0,0]
b = 0
learning_rate = 0.1

for i in xrange(10):
	for data in train_data:
		y = step(cross_prod(w,data[:2]) + b)
		#update
		delta_w = [learning_rate * (data[2] - y) * x  for x in data[:2]]
		w[0] += delta_w[0]
		w[1] += delta_w[1]

		delta_b = learning_rate * (data[2] - y)
		b += delta_b

def predict(x):
	return step(cross_prod(w,x) + b)

print w
print b	

print predict([1,0])
print predict([0,1])
print predict([1,1])
print predict([0,0])



