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
      <h1>Students component works</h1>
    </div>
  )
}

export default Students;