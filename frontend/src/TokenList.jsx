import React from 'react';
import ListGroup from 'react-bootstrap/ListGroup';
import Container from 'react-bootstrap/Container';

function TokenList({ tokens }) {
  return (
    <Container>
      <h2>Token List</h2>
      <ListGroup>
        {tokens.map((token, index) => (
          <ListGroup.Item key={index}>{token}</ListGroup.Item>
        ))}
      </ListGroup>
    </Container>
  );
}

export default TokenList;
