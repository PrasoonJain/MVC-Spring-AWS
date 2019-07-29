# MVC-Spring-AWS
Steps for testing . :


// View list of employees :
URL : http://3.14.146.213:8080/springmvc-ems/employees

// Add new employee :
URL : http://3.14.146.213:8080/springmvc-ems/add 
In body pass the object , For example :
{
	"name":"xyzgh",
	"lastName":"jain",
	"birthDate":"01/08/1997",
	"role":"SD",
	"department":"airteltv",
	"email":"emailxyz.com"
}


// View employee by id :
URL : http://3.14.146.213:8080/springmvc-ems/view?id=202

// Update Employee by id :
URL : http://3.14.146.213:8080/springmvc-ems/update?id=128
In body pass the object , For example :
 {
        "name": "Sara",
        "lastName": "singh",
        "birthDate": "12/12/1990",
        "role": "SD",
        "department": "wynk",
        "email": "jainpraqwe123@gmail.com"
    }
    

// Delete Employee by id  :
URL : http://3.14.146.213:8080/springmvc-ems/delete?id=128

