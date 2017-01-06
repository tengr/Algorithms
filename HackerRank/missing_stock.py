# LSTM for international airline passengers problem with regression framing
import numpy
import matplotlib.pyplot as plt
import pandas
import math
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import LSTM
from sklearn.preprocessing import MinMaxScaler
from sklearn.metrics import mean_squared_error
# convert an array of values into a dataset matrix
def create_dataset(dataset, look_back=1):
	dataX, dataY = [], []
	for i in range(len(dataset)-look_back-1):
		a = dataset[i:(i+look_back), 0]
		dataX.append(a)
		dataY.append(dataset[i + look_back, 0])
	return numpy.array(dataX), numpy.array(dataY)
# fix random seed for reproducibility
numpy.random.seed(7)
# load the dataset
#dataframe = pandas.read_csv('international-airline-passengers.csv', usecols=[1], engine='python', skipfooter=3)
#dataset = dataframe.values
arr = []
stocks = [333.74, 334.79, 331.65, 329.67, 323.18, 316.58, 314.38, 316.13, 313.16, 315.67, 316.68, 320.17, 295.2, 294.04, 293.55, 289.07, 286.95, 289.87, 289.71, 291.71, 292.46, None, 298.24, 305.11, 304.3903, 305.3693, 306.94, 303.76, None, 305.69, 306.16, 304.1, 303.51, 308.63, 308.08, 303.67, 305.52, 305.87, None, 312.49, 312.54, 311.69, 310.93, None, 305.2883, 305.44, 305.64, 303.2, None, 311.08, 311.44, 312.641, 318.316, 317.71, 323.37, None, 323.93, 324.42, 326.42, 328.965, 327.97, 326.42, 323.43, 323.65, 319.18, 317.9, 317.35, 316.93, 317.68, None, None, 311.59, 308.54, 306.09, 307.82, 304.12, 298.93, 303.01, 305.37, 308.69, 308.06, 307.733, 305.49, 303.75, 307.11, 303.6403, 304.98, 308.14, 307.88, 307.79, 306.97, 303.95, 307.19, 314.73, 318.61, 315.89, 307.539, 306.6, 304.5, 305.654, 300.56, 299.27, 295.65, 294.7, 286.04, 289.95, 288.78, 290.69, 293.65, 290.21, 292.3661, 284.86, 283.22, 282.2525, 281.98, None, 291.8479, 289.71, 289.63, 285.45, 283.7622, 283.02, 286.707, 282.83, 289.77, 291.2084, 293.91, 299.73, 296.46, 294.01, 295.92, 288.64, 285.68, 289.2845, 289.3054, 290.04, 291.55, 298.94, 306.16, 308.87, 308.66, 306.38, 308.13, 317.18, 320.98, 317.93, 319.4344, 318.7, 321.54, 324.37, 321.81, 322.61, 322.8618, None, 329.74, 336.09, 336.79, None, 338.29, 339.1, 338.661, 339.96, 339.9, 339.88, 335.66, None, 344.15, None, None, 342.16, 342.91, 349.5951, 355.77, 356.05, 349.97, 347.107, 354.15, 356.14, 356.08, None, 363.92, 365.3243, 367.09, 374.64, 382.06, 380.24, 381.04, 379.27, 382.12, 382.61, 381.58, 384.56, 386.803, 381.41, 380.279, 373.39, None, None, 371.543, 373.1215, 377.79, 379.333, 353.0, 341.97, 343.32, 343.1565, None, 341.17, 340.1595, 345.1, 347.427, 343.09, 342.91, 338.777, 335.41, None, 334.57, 333.4662, 330.76, 329.67, 326.181, None, 338.66, 334.57, 334.66, 333.17, 337.16, 342.11, 346.6, 349.26, 352.592, 347.41, 346.9028, 347.46, 348.092, 345.48, 350.61, 351.4, 357.879, 353.5561, 368.77, 364.19, 361.14, 361.9627, 359.05, 357.23, 356.08, 354.07, 353.1, 354.93]
for stock in stocks:
	if stock is not None:
		arr.append(stock)
arr = numpy.array(arr)
arr.resize(len(arr),1)
dataset = arr
 
dataset = dataset.astype('float32')
# normalize the dataset
scaler = MinMaxScaler(feature_range=(0, 1))
dataset = scaler.fit_transform(dataset)
# split into train and test sets
train_size = int(len(dataset) * 0.67)
test_size = len(dataset) - train_size
train, test = dataset[0:train_size,:], dataset[train_size:len(dataset),:]
# reshape into X=t and Y=t+1
look_back = 1
trainX, trainY = create_dataset(train, look_back)
testX, testY = create_dataset(test, look_back)
# reshape input to be [samples, time steps, features]
trainX = numpy.reshape(trainX, (trainX.shape[0], 1, trainX.shape[1]))
testX = numpy.reshape(testX, (testX.shape[0], 1, testX.shape[1]))
# create and fit the LSTM network
model = Sequential()
model.add(LSTM(4, input_dim=look_back))
model.add(Dense(1))
model.compile(loss='mean_squared_error', optimizer='adam')
model.fit(trainX, trainY, nb_epoch=100, batch_size=1, verbose=2)
# make predictions
trainPredict = model.predict(trainX)
testPredict = model.predict(testX)
# invert predictions
trainPredict = scaler.inverse_transform(trainPredict)
trainY = scaler.inverse_transform([trainY])
testPredict = scaler.inverse_transform(testPredict)
testY = scaler.inverse_transform([testY])
# calculate root mean squared error
trainScore = math.sqrt(mean_squared_error(trainY[0], trainPredict[:,0]))
print('Train Score: %.2f RMSE' % (trainScore))
testScore = math.sqrt(mean_squared_error(testY[0], testPredict[:,0]))
print('Test Score: %.2f RMSE' % (testScore))
# shift train predictions for plotting
trainPredictPlot = numpy.empty_like(dataset)
trainPredictPlot[:, :] = numpy.nan
trainPredictPlot[look_back:len(trainPredict)+look_back, :] = trainPredict
# shift test predictions for plotting
testPredictPlot = numpy.empty_like(dataset)
testPredictPlot[:, :] = numpy.nan
testPredictPlot[len(trainPredict)+(look_back*2)+1:len(dataset)-1, :] = testPredict
# plot baseline and predictions
plt.plot(scaler.inverse_transform(dataset))
plt.plot(trainPredictPlot)
plt.plot(testPredictPlot)
plt.show()
