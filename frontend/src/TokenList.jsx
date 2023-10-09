import React from 'react';
import ListGroup from 'react-bootstrap/ListGroup';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function TokenList({ tokens }) {
  return (
    <Container className="mt-5">
      <Row className="justify-content-center">
        <Col xs={12} sm={8} md={6}>
          <h2 className="text-center mb-3">Token List</h2>
          <div className="text-center">
            <ListGroup>
              {tokens.map((token, index) => (
                <ListGroup.Item key={index} className="text-center">
                  {token}
                </ListGroup.Item>
              ))}
            </ListGroup>
          </div>
        </Col>
      </Row>
    </Container>
  );
}

export default TokenList;
