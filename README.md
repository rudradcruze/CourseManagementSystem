# College Management System
This is a simple college management system created using Java and Spring Boot. The system allows you to manage students, professors, subjects, and admissions. The system is designed to be used by college administration staff.

## Features
- Manage Students
- Manage Professors
- Manage Subjects
- Manage Admissions
- Assign Students to Subjects
- Assign Professors to Subjects
- Assign Students to Admissions

## Technologies
- Java
- Spring Boot
- MySQL

## Database Schema

### Student
- id 
- name 

### Professor
- id 
- title

### Subject
- id
- title
- professor_id

### AdmissionRecord
- id
- fees
- student_id

### Student Professor
- student_id
- professor_id

### Subject Student
- subject_id
- student_id


## API Endpoints
### Students
- `GET /students` - Get all students
- `POST /students` - Add a student
- `GET /students/{id}` - Get student by id
- `PUT /students/{studentId}/subjects/{subjectId}` - Assign subject to student

### Subjects
- `GET /subjects` - Get all subjects
- `POST /subjects` - Add a subject
- `GET /subjects/{id}` - Get subject by id
- `PUT /subjects/{subjectId}/professors/{professorId}` - Assign professor to subject

### Professors
- `GET /professors` - Get all professors
- `POST /`professors - Add a professor
- `GET /professors/{id}` - Get professor by id
- `PUT /professors/{professorId}/students/{studentId}` - Assign student to professor

### Admissions
- `GET /admission` - Get all admission records
- `POST /admission` - Add an admission record
- `GET /admission/{id}` - Get admission record by id
- `PUT /admission/{admissionId}/students/{studentId}` - Assign student to admission record

## How to Run
1. Clone the repository
2. Update the `application.properties` file with your MySQL username and password
3. Run the application

## 🚀 About Me

Tech-savvy learner/programmer pushing boundaries of online tech. Passionate about new tools, seeking challenges to advance skills.

## 🔗 Social Links

![Name](https://img.shields.io/badge/Name-Francis%20Rudra%20D%20Cruze-yellowgreen?style=for-the-badge)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rudradcruze)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/rudradcruze)
[![Facebook](https://img.shields.io/badge/facebook-4267B2?style=for-the-badge&logo=facebook&logoColor=white)](https://facebook.com/rudradcruze)
[![francisrudra@gmail.com](https://img.shields.io/badge/gmail-4267B2?style=for-the-badge&logo=gmail&logoColor=white)](mailto:francisrudra@gmail.com)
