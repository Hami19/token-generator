import React, { useState } from 'react';
import axios from 'axios';
import Container from 'react-bootstrap/esm/Container';

function TokenValidator({ onTokenValidated }) {
  const [token, setToken] = useState('');
  const [isValid, setIsValid] = useState(false);

  const url = "http://localhost:8082";

  const validateToken = async () => {
    try {
      const response = await axios.get(`${url}/validator/token/${token}`);
      const isValid = response.data.valid; // Assuming the API response includes a 'isValid' property
      setIsValid(isValid);
      onTokenValidated(isValid); // Notify the parent component
    } catch (error) {
      console.error('Error validating token:', error);
    }
  };

  return (
    <Container>
      <label>Validate Token</label>
      <input
        type="text"
        value={token}
        onChange={(e) => setToken(e.target.value)}
      />
      <button onClick={validateToken}>Validate</button>
      <p>Token is {isValid ? 'valid' : 'invalid'}</p>
    </Container>
  );
}

export default TokenValidator;
