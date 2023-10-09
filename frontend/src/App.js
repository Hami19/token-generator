import React, { useState } from 'react';
import TokenGenerator from './TokenGenerator';
import TokenValidator from './TokenValidator';
import TokenList from './TokenList';

function App() {
  const [tokens, setTokens] = useState([]);

  const handleTokenGenerated = (token) => {
    setTokens([...tokens, token]);
  };

  const handleTokenValidated = (valid) => {
  
  };

  return (
    <div className="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
      <h1 className='mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900'>Token App</h1>
      <TokenGenerator onTokenGenerated={handleTokenGenerated} />
      <TokenValidator onTokenValidated={handleTokenValidated} />
      <TokenList tokens={tokens} />
    </div>
  );
}

export default App;
