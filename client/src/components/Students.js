import React, { useEffect, useState } from 'react';

function Students() {
  useEffect(() => {
    console.log('hello');
  }, [])

  return(
    <div>
      <h1>Students component works</h1>
    </div>
  )
}

export default Students;