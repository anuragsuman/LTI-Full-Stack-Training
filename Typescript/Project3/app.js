// if no return type is mention : any
// return type specific
function add(n1, n2) {
    return n1 + n2;
}
function fun(val) {
    console.log(val);
}
// ES6 : Fat Arrow function (lambdas)
var someFun = function (a, b) { return a * b; }; // return 
console.log(someFun(10, 20));
someFun = add; // alias of add
console.log(someFun(10, 20));
// someFun = fun;
// functions can be passed as arguments
function operationAndHandle(n1, n2, guest) {
    var result = n1 + n2;
    // some other should decide what to do
    guest(result);
}
function handleResult(result) {
    console.log("Handle Result : " + result);
}
// operationAndHandle(50, 60,handleResult);
operationAndHandle(50, 60, function (result) { return console.log("Anonymous :" + result); });
