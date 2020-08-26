var Department = /** @class */ (function () {
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
    function Department(id) {
        this.id = id;
    }
    Department.prototype.showInfo = function () {
        // this : object responsible to call current method
        console.log(this.name + " : " + this.id);
    };
    return Department;
}());
var dept1 = new Department(1);
dept1.name = "Account";
dept1.showInfo();
// object of anonymous class
var dept2 = {
    name: "IT",
    // id : 2,
    showInfo: dept1.showInfo
};
// using the functionality of another class 
// able to inject my values
dept2.showInfo();
