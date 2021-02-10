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

  return(
    <div>
      { students && students.map(student => (
        <div className="student" key={ student.id }>
          <h3>The students full name is { student.firstName } { student.lastName }</h3>
          <h6>They are currently in grade { student.grade }</h6>
        </div>
      ))}
    </div>
  )
}

export default Students;