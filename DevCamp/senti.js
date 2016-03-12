var natural = require('natural'),
  classifier = new natural.BayesClassifier();
classifier.addDocument('i am long qqqq', 'buy');
classifier.addDocument('buy the q\'s', 'buy');
classifier.addDocument('short gold', 'sell');
classifier.addDocument('sell gold', 'sell');

classifier.train();

console.log(classifier.classify('i am short silver'));
console.log(classifier.classify('i am long copper'));


classifier.save('classifier.json', function(err, classifier) {
    // the classifier is saved to the classifier.json file!
});

