/*var person ={
    name: "First",
    age : 30
};*/
// let person : Employee = {}
// typescript way
/*let person : {
    name : string,
    age : number
} = {
    name : "First",
    age : 30
}*/
/*let person = {
    name : "First",
    age : 30,
    hobbies : ["Cricket","Chess"],
     
}*/
var Roles;

// prototype oriented syntax 
(function (Roles) {
    Roles[Roles["ADMIN"] = 0] = "ADMIN";
    Roles[Roles["MANAGER"] = 1] = "MANAGER";
    Roles[Roles["EMPLOYEE"] = 2] = "EMPLOYEE"; // 2
})(Roles || (Roles = {}));
;
var person = {
    name: "First",
    age: 30,
    hobbies: ["Cricket", "Chess"],
    // role : ["Admin", 100]
    role: Roles.ADMIN
};
var colors;
colors = ["Red", "Green"]; // , 20];
// let myCode : []; // can hold value of any type, as many
var myCode;
myCode = ["First", 100];
//  myCode = ["First", 100, "Second"];
// myCode = ["First", "Second"];
// myCode = [100, "Second"];
console.log(person.name);
// person.name = 20;
for (var _i = 0, _a = person.hobbies; _i < _a.length; _i++) {
    var hobby = _a[_i];
    console.log(hobby);
}
console.log(person.role);
function fun(val1, val2, val3) {
    console.log(val1);
}
// fun(20);
// fun("Hello");
//fun(true);
