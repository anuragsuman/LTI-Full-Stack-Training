// if no return type is mention : any
// return type specific
function add(n1:number, n2:number): number{
    return n1+n2;
}

function fun(val : string){
    console.log(val);
}

// ES6 : Fat Arrow function (lambdas)
let someFun = (a:number, b:number) => a*b; // return 
console.log(someFun(10,20));
someFun = add; // alias of add
console.log(someFun(10,20));
// someFun = fun;

// functions can be passed as arguments

function operationAndHandle(n1:number,
                            n2:number,
                            guest: (num : number)=>void
                            ){
   // const result = n1 + n2;
   let result = n1 + n2;
   // some other should decide what to do
   // guest(result);
   guest(n1 + n2);

}
function handleResult(result : number){
    console.log("Handle Result : " + result);
}

// operationAndHandle(50, 60,handleResult);
operationAndHandle(50, 60,result=> console.log("Anonymous :" + result));