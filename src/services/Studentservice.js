import axios from 'axios'

const Student_BASE_REAST_API_URL = 'http://localhost:8080/api/v1/students'

class StudentService{

    getAllStudents(){
        return axios.get(Student_BASE_REAST_API_URL)
    }
    creatStudent(student){
        return axios.post(Student_BASE_REAST_API_URL, student)
    }
    getStudentById(studentId){
        return axios.get(Student_BASE_REAST_API_URL + '/' + studentId);
    }

}

export default new StudentService();