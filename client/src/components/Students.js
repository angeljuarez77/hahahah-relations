import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Students() {
  const [students, setStudents] = useState(null);

  async function getStudents() {
    try {
      const res = await axios.get('http://localhost:8080/students');
      setStudents(res.data);
    } catch(e) {
      console.error(e, e.message);
    }
  }

  useEffect(() => {
    getStudents();
  }, [])

  const [form, setForm] = useState(null);

  function handleChange(e) {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  }

  function handleSubmit(e) {
    e.preventDefault();
    createStudent();
  }

  async function createStudent() {
    try {
      const res = await axios.post('http://localhost:8080/students', form);
      setStudents([...students, res.data]);
    } catch(e) {
      console.error(e, e.message);
    }
  }

  const [selectedStudent, setSelectedStudent] = useState(null);

  function selectStudent(student) {
    setSelectedStudent(student)
  }

  function handleEditChange(e) {
    const { name, value } = e.target;
    setSelectedStudent({ ...selectedStudent, [name]: value });
  }

  async function handleEditSubmit(e) {
    e.preventDefault();
    try {
      const res = await axios.patch('http://localhost:8080/students', selectedStudent);
      console.log(res.data);
      getStudents();
    } catch(e) {
      console.error(e, e.message);
    }
  }

  return(
    <div>
      { students && students.map(student => (
        <div className="student" key={ student.id }>
          <h3>The students full name is { student.firstName } { student.lastName }</h3>
          <h6>They are currently in grade { student.grade }</h6>
          <button onClick={ () => selectStudent(student) }>Edit student</button>
        </div>
      ))}

      <div>
        <h2>Enroll a new student!</h2>
        <form
          onChange={ (e) => handleChange(e) }
          onSubmit={ (e) => handleSubmit(e) }>
          <label>
            First Name:
            <input type="text" name="firstName" />
          </label>
          <label>
            Last Name:
            <input type="text" name="lastName" />
          </label>
          <label>
            Age:
            <input type="text" name="age" />
          </label>
          <label>
            Grade Level:
            <input type="text" name="grade" />
          </label>
          <label>
            School Name:
            <input type="text" name="schoolName" />
          </label>
          <input type="submit" value="Enroll student" />
        </form>

        { selectedStudent && <form
          onChange={ (e) => handleEditChange(e) }
          onSubmit={ (e) => handleEditSubmit(e) }>
          <label>
            First Name:
            <input type="text" name="firstName" defaultValue={ selectedStudent.firstName } />
          </label>
          <label>
            Last Name:
            <input type="text" name="lastName" defaultValue={ selectedStudent.lastName } />
          </label>
          <label>
            Age:
            <input type="text" name="age" defaultValue={ selectedStudent.age } />
          </label>
          <label>
            Grade Level:
            <input type="text" name="grade" defaultValue={ selectedStudent.grade } />
          </label>
          <label>
            School Name:
            <input type="text" name="schoolName" defaultValue={ selectedStudent.schoolName } />
          </label>
          <input type="submit" value="Edit student information" />
        </form> }
      </div>
    </div>
  )
}

export default Students;