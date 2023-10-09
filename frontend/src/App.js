import React, { useState } from 'react';
import TokenGenerator from './TokenGenerator';
import TokenValidator from './TokenValidator';
import TokenList from './TokenList';
import Container from 'react-bootstrap/Container';


function App() {
  const [tokens, setTokens] = useState([]);

  const handleTokenGenerated = (token) => {
    setTokens([...tokens, token]);
  };

  const handleTokenValidated = (valid) => {
  
  };

  return (
    <Container className="mt-3 border border-primary p-4 rounded">
      <h1 className='mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900'>Token App</h1>
      <TokenGenerator onTokenGenerated={handleTokenGenerated} />
      <TokenValidator onTokenValidated={handleTokenValidated} />
      <TokenList tokens={tokens} />
    </Container>
  );
}

export default App;
