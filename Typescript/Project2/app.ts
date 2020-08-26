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

/*enum Roles{
    ADMIN, // 0
    MANAGER, // 1
    EMPLOYEE // 2
};*/

/*enum Roles{
    ADMIN = 100, // 0
    MANAGER, // 101
    EMPLOYEE // 102
};*/

/*enum Roles{
    ADMIN = 100, // 0
    MANAGER=200, // 200
    EMPLOYEE=300 // 300
};*/

enum Roles{
    ADMIN = "ADMIN", // 0
    MANAGER = 200, // 101
    EMPLOYEE = "EMPLOYEE"// 102
};


let person : {
    name : string,
    age : number
    hobbies : string[],
    // randomArray : (number|string)[]
    // role : [string, number]
    role : Roles
} = {
    name : "First",
    age : 30,
    hobbies : ["Cricket","Chess"],
    // role : ["Admin", 100]
    role : Roles.ADMIN
}


let colors : string[];

colors = ["Red","Green"]; // , 20];

// let myCode : []; // can hold value of any type, as many
let myCode : [string, number];
myCode = ["First", 100];
//  myCode = ["First", 100, "Second"];

// myCode = ["First", "Second"];

// myCode = [100, "Second"];

console.log(person.name);
// person.name = 20;
for(let hobby of person.hobbies){
    console.log(hobby);
}

console.log(person.role);

function fun(val1 : number | string, 
             val2 : string, 
             val3 : string|boolean){
    console.log(val1);
}

// fun(20);
// fun("Hello");
 //fun(true);

 let a : any;
 a="Hello";
 a=20;