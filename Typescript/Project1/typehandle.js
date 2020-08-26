// fetch the button
var button = document.querySelector("button");
// fetch text boxes
var input1 = document.getElementById("num1");
var input2 = document.getElementById("num2");
// const, let 
function add(n1, n2) {
    return n1 + n2;
}
var username;
username = "First";
var number1 = 20;
var trial;
trial = "Hello";
trial = 20;
// username = 24;
// handle the click event of button
button.addEventListener("click", function () {
    console.log(add(+input1.value, +input2.value));
});
