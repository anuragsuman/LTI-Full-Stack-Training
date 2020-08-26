// fetch the button
let button = document.querySelector("button");
// fetch text boxes
let input1 = document.getElementById("num1")! as HTMLInputElement;
let input2 = document.getElementById("num2")! as HTMLInputElement;

// const, let 

function add(n1:number, n2:number){
    
    return n1 + n2;
}

let username : string;
username="First";

let number1 : number = 20;

let trial;

trial = "Hello";

trial = 20;

// inference
let mytest = "Hello"; // type bounded as string
// mytest = 20;

// username = 24;


// handle the click event of button
button.addEventListener("click", function(){
    console.log(add(+input1.value, +input2.value));
});