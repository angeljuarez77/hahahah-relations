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
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  function handleSubmit(e) {
    e.preventDefault();
    createStudent();
  }

  async function createStudent() {
    try {
      const res = await axios.post('http://localhost:8080/students', form);
      console.log(res.data);
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
      </div>
    </div>
  )
}

export default Students;