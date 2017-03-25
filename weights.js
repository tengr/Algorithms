input = {
    "objects": [
        {
            "category": "Gadgets", 
            "title": "10 Pack Family Car Sticker Decals", 
            "weight": 120.0, 
            "size": {
                "width": 15.0, 
                "length": 13.0, 
                "height": 1.0
            }
        }, 
        {
            "category": "Air Conditioners", 
            "title": "Window Seal for Portable Air Conditioner Outlets", 
            "weight": 235.0, 
            "size": {
                "width": 26.0, 
                "length": 26.0, 
                "height": 5.0
            }
        }, 
        {
            "category": "Batteries", 
            "title": "10 Pack Kogan CR2032 3V Button Cell Battery", 
            "weight": 60.0, 
            "size": {
                "width": 5.8, 
                "length": 19.0, 
                "height": 0.3
            }
        }, 
        {
            "category": "Cables & Adapters", 
            "title": "3 Pack Apple MFI Certified Lightning to USB Cable (3m)", 
            "weight": 90.0, 
            "size": {
                "width": 10.0, 
                "length": 20.0, 
                "height": 3.0
            }
        }, 
        {
            "category": "Air Conditioners", 
            "title": "Kogan 10,000 BTU Portable Air Conditioner (2.9KW)", 
            "weight": 26200.0, 
            "size": {
                "width": 49.6, 
                "length": 38.7, 
                "height": 89.0
            }
        }
    ], 
    "next": "/api/products/2"
}

// arr = input.objects
// weight_sum = 0
// for(var i = 0; i < arr.length; i++) {
//     weight_sum += arr[i].size.width * arr[i].size.length * arr[i].size.height
// }
// result1 = weight_sum / arr.length * 250
// console.log(result1)

// result2 = input.objects.map(item => item.size.width * item.size.length * item.size.height).reduce(function(sum, a) { return sum + a },0)/(input.objects.length||1) * 250;
// console.log(result2)

// sum = 0
// count = 0
// var p = new Promise(function(resolve, reject) {
//     input.next
//     .on('error', reject)
//     .pipe(/* do some stuff */)
//     .on('end', resolve)
//     .on('error', reject); // call reject(err) when something goes wrong
// });


var Q = require("q");
sum = 0
// `condition` is a function that returns a boolean
// `body` is a function that returns a promise
// returns a promise for the completion of the loop
function promiseWhile(condition, body) {
    var done = Q.defer();

    function loop() {
        // When the result of calling `condition` is no longer true, we are
        // done.
        if (!condition()) return done.resolve();
        // Use `when`, in case `body` does not return a promise.
        // When it completes loop again otherwise, if it fails, reject the
        // done promise
        Q.when(body(), loop, done.reject);
    }

    // Start running the loop in the next tick so that this function is
    // completely async. It would be unexpected if `body` was called
    // synchronously the first time.
    Q.nextTick(loop);

    // The promise
    return done.promise;
}


dict = {}
dict[1] = 2
dict[2] = 3
dict[3] = 4
dict[4] = 5
dict[5] = null

// // Usage
var index = 1;

promiseWhile(function () { return dict[index] != null; }, function () {
    index = dict[index];
    var delayMillis = Math.random() * (30000 - 1000) + 1000; //1 second

    setTimeout(function() {
      //your code to be executed after 1 second
    }, delayMillis);
    console.log(index);
    return index; // arbitrary async
}).then(function () {
    console.log("done");
}).done();

// while(dict[index] != null) {
//   console.log(index);
//   index = dict[index]
// }
