# Work-Mode API
The Work-Mode API facilitates employee and department management operations within an organization. It includes authentication mechanisms using JSON Web Tokens (JWT) for secure access to its features.

## Features
Authentication: Users can authenticate via JWT tokens to access protected endpoints securely.
Employee Management: CRUD operations for managing employee records.
Department Management: CRUD operations for managing department information.
## Endpoints
Authentication:

POST /api/auth/login: Authenticate users and generate JWT tokens.
POST /api/auth/register: Register new users.
## Employee Management:

GET /api/employees: Retrieve all employees.
GET /api/employees/{id}: Retrieve an employee by ID.
POST /api/employees: Create a new employee.
PUT /api/employees/{id}: Update an existing employee.
DELETE /api/employees/{id}: Delete an employee.
## Department Management:

GET /api/departments: Retrieve all departments.
GET /api/departments/{id}: Retrieve a department by ID.
POST /api/departments: Create a new department.
PUT /api/departments/{id}: Update an existing department.
DELETE /api/departments/{id}: Delete a department.
## Authentication
Send a POST request to /api/auth/login with valid credentials (username and password) in the request body to authenticate.
Upon successful authentication, receive a JWT token in the response.
Include the JWT token in the Authorization header of subsequent requests to access protected endpoints.
## Setup
Clone the repository named "work-mode" to your local machine.
Navigate to the project directory.
Install any required dependencies.
Configure environment variables for any necessary settings.
Run the server using the appropriate command.
## Technologies Used
Spring Boot
JSON Web Tokens (JWT)
bcrypt
## License
This project is licensed under the MIT License - see the LICENSE file for details.
