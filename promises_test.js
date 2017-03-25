// var promises = [];
// var sum  = 0
// for (var i = 2; i < 10; i++) {
//     promises.push(doAjax(i));
// }

// console.log(sum)

// function doAjax(ii) {
//     return new Promise(function(resolve, reject) {
//         abb(i, function(err, sum) {
//             if (err) return reject(err);
//             resolve(i);
//             //var delayMillis = Math.random() * (300 - 100) + 100; //1 second

// 			//setTimeout(function() {
// 			  //your code to be executed after 1 second
// 			//}, delayMillis);
//             console.log(ii);
//         });
//     });
// }

// Promise.all(promises).then(function(iii) {
//     // returned data is in arguments[0], arguments[1], ... arguments[n]
//     // you can process it here
//     sum += iii
//     console.log(sum)
// }, function(err) {
//     // error occurred
// });


// var promises = [];
// var sum  = 0
// for (var i = 1; i < 10; i++) {
//     asyncFunction(i)
// }

// function asyncFunction(i) {
    
//     return new Promise(function (resolve, reject) {
//         setTimeout(function () {
//             resolve(i);
//         }, 79);
//     });
// }

// asyncFunction().then(function (value) {
//     console.log(value);    // => 'Async Hello world'
// }).catch(function (error) {
//     console.log(error);
// });
var promise = new Promise(function (resolve){
    console.log("inner promise"); // 1
    resolve(42);
});
promise.then(function(value){
    console.log(value); // 3
});
console.log("outer promise"); // 2
