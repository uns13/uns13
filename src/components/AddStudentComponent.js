
import React, {useState, useEffect} from 'react';
import {useHistory, Link, useParams} from 'react-router-dom';
import Studentservice from '../services/Studentservice';

const AddStudentComponent = () => {

    const [firstName, setFirstName] = useState('')
    const [lastName,setLastName] = useState('')
    const [emailId,setEmailId] = useState('')
    const history = useHistory();
    const {id} = useParams();

    const saveStudent = (e) => {
        e.preventDefault();

        const student = {firstName,lastName,emailId}

        Studentservice.creatStudent(student).then((Response) =>{

            console.log(Response.data)

            history.push('/students');

        }).catch(error => {
            console.log(error)
        })
    }

    useEffect(() => {

        Studentservice.getStudentById(id).then((Response) => {
            setFirstName(Response.data.firstName)
            setLastName(Response.data.lastName)
            setEmailId(Response.data.emailId)
        }).catch(error => {
            console.log(error)
        })
    },)

    const title = () => {
        if(id){
            return <h2 className = "text-center">Update Student</h2>
        }else{
            return <h2 className = "text-center">Add Student</h2>
        }
    }
    
  return (
    <div>
        <br /><br />
        <div className= "container">
            <div className="row">
                <div className="card col-md-6 offset-md-3 offset-md-3">
                    {
                        title()
                    }
                    <div className="card-body">
                        <form>
                            <div className="form-group mb-2">
                                <label className="form-label">First Name :</label>
                                <input 
                                type="text"
                                placeholder="Enter first Name"
                                name="firstName"
                                className="form-control"
                                value={firstName}
                                onChange = {(e) => setFirstName(e.target.value)}></input>
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Last Name :</label>
                                <input 
                                type="text"
                                placeholder="Enter last Name"
                                name="lastName"
                                className="form-control"
                                value={lastName}
                                onChange = {(e) => setLastName(e.target.value)}></input>
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Email Id :</label>
                                <input 
                                type="emailID"
                                placeholder="Enter emailid"
                                name="emailId"
                                className="form-control"
                                value={emailId}
                                onChange = {(e) => setEmailId(e.target.value)}></input>
                            </div>
                            <button className="btn btn-success" onClick={(e) => saveStudent(e)}>Submit</button>
                            <Link to="/students" className="btn btn-danger"> Cancel </Link>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default AddStudentComponent