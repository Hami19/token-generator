import React, { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function TokenGenerator({ onTokenGenerated }) {
  const [digits, setDigits] = useState('');
  const [generatedToken, setGeneratedToken] = useState('');
  const url = "http://localhost:8082";

  const generateToken = async () => {
    try {
      const response = await axios.get(`${url}/generator/token/${digits}`);
      const token = response.data.token; // Assuming the API response returns the token
      setGeneratedToken(token);
      onTokenGenerated(token); // Notify the parent component
    } catch (error) {
      console.error('Error generating token:', error);
    }
  };

  // Handle input change and enforce digit-only and comma insertion
  const handleInputChange = (e) => {
    const inputValue = e.target.value;
    // Remove non-digits and commas
    const sanitizedValue = inputValue.replace(/[^0-9,]/g, '');
    // Ensure a comma is inserted after entering a single digit
    const formattedValue = sanitizedValue.replace(/(\d)(?=(\d{1})+(?!\d))/g, '$1,');
    setDigits(formattedValue);
  };

  return (
      <Row className="justify-content-center">
        <Col xs={12} sm={8} md={6}>
          <Row className="mb-3">
            <Form.Label column sm={3}>
              Generate Token
            </Form.Label>
            <Col sm={9}>
              <InputGroup>
                <Form.Control
                  type="text"
                  placeholder="Enter digits (0-9)"
                  value={digits}
                  onChange={handleInputChange}
                />
                <Button variant="primary" onClick={generateToken}>
                  Generate
                </Button>
              </InputGroup>
            </Col>
          </Row>
        </Col>
      </Row>
  );
}

export default TokenGenerator;
