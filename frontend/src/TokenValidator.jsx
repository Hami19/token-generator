import React, { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

// Import FontAwesome icons
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheckCircle, faTimesCircle } from '@fortawesome/free-solid-svg-icons';

function TokenValidator({ onTokenValidated }) {
  const [token, setToken] = useState('');
  const [isValid, setIsValid] = useState(false);
  const url = "http://localhost:8082";
  const [show, setShow] = useState(false); 
  const validateToken = async () => {
    try {
      const response = await axios.get(`${url}/validator/token/${token}`);
      const isValid = response.data.valid;
      setShow(true); // Show the icon after clicking "Validate"
      setIsValid(isValid);
      onTokenValidated(isValid); // Notify the parent component
    } catch (error) {
      console.error('Error validating token:', error);
    }
  };

  return (
    <Row className="justify-content-center">
      <Col xs={12} sm={8} md={6}>
        <Row className="mb-3">
          <Form.Label column sm={3}>
            Validate Token
            {show && ( // Conditionally render the icon if 'show' is true
              isValid ? (
                <FontAwesomeIcon icon={faCheckCircle} className="text-success" />
              ) : (
                <FontAwesomeIcon icon={faTimesCircle} className="text-danger" />
              )
            )}
          </Form.Label>
          <Col sm={9}>
            <InputGroup>
              <Form.Control
                type="text"
                placeholder="Enter token to validate"
                value={token}
                onChange={(e) => {
                  setShow(false); // Hide the icon while typing
                  setToken(e.target.value);
                }}
              />
              <Button variant="primary" onClick={validateToken}>
                Validate
              </Button>
            </InputGroup>
          </Col>
        </Row>
        {/* <p className={`text-${isValid ? 'success' : 'danger'}`}>
          Token is {isValid ? 'valid' : 'invalid'}
        </p> */}
      </Col>
    </Row>
  );
}

export default TokenValidator;
