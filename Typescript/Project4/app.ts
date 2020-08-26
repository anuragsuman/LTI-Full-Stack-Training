interface Greeting{
    greet(message:string):void;
}

class EmailGreeting implements Greeting{
    greet(message: string): void {
        console.log("Email :" + message);
    }

}

class Department{
    // class data members
    name : string;  // public (default)
    // private id : number
    // public name : string; 
    // private name : string; 
    // protected name : string; 

    /*constructor(val : string){

    }*/

    /*constructor(id : number){
        this.id = id;
    }*/

    // auto creates a new field with initialization
    constructor(private readonly id : number){
        
    }

    // every class method auto receives an 'this' instance
    // as param
    // 'this' : any : object of any class can call mehtod
    showInfo(this:Department){
        // this : object responsible to call current method
        console.log(this.name + " : " + this.id);
    }
    // method 
    // default : any
    /*fun(): void{

    }*/
}

let dept1 = new Department(1);
dept1.name = "Account";
dept1.showInfo();

// object of anonymous class
let dept2 = {
    name : "IT",
    id : 2,
    showInfo : dept1.showInfo
}


// using the functionality of another class 
// able to inject my values
// dept2.showInfo();