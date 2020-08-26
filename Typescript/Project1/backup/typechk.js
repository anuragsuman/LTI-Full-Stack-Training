// fetch the button
var button = document.querySelector("button");
// fetch text boxes
var input1 = document.getElementById("num1");
var input2 = document.getElementById("num2");

console.log(input1.value);
console.log(input2.value);

function add(n1, n2){
    // add JS validation
    if(typeof n1 !== 'number' || typeof n2 !== 'number'){
        throw new Error("Incorrect Input");
    }
    return n1 + n2;
}

// handle the click event of button
button.addEventListener("click", function(){
    console.log(add(input1.value, input2.value));
});