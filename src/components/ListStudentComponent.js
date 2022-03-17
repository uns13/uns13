import React,{useState,useEffect} from 'react'
import {Link} from 'react-router-dom'
import Studentservice from '../services/Studentservice'

const ListStudentComponent = () => {

    const [students, setStudents] = useState([])

    useEffect(() => {

        Studentservice.getAllStudents().then(Response => {
            setStudents(Response.data)
            console.log(Response.data);
        }).catch(error =>{
            console.log(error);
        })
 
    }, [])
    
    return (
      
      <div className = "container">
        <h2 className = "text-center">Students List</h2>
        <Link to = "/add-student" className = "btn btn-primary mb-2"> Add Student </Link>
        <table className="table table-bordered table-striped">
            <thead>
                <th>Student Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Id</th>
                <th>Actions</th>
            </thead>
            <tbody>
                {
                    students.map(
                        student =>
                        <tr key = {student.id}>
                            <td>{student.id}</td>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td>{student.emailId}</td>
                            <td>
                                <Link className="btn btn-info" to={'/edit-student/key={student.id}'}>Update</Link>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
       
    </div>
  )
}

export default ListStudentComponent