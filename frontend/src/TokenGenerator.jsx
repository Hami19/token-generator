import React, { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';


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

  return (
    // <div className="token-generator">
    //   <div className="input-container">
    //     <label>Generate Token</label>
    //     <input
    //       type="text"
    //       value={digits}
    //       onChange={(e) => setDigits(e.target.value)}
    //     />
    //   </div>
    //   <div className="button-container">
    //     <button onClick={generateToken}>Generate</button>
    //   </div>
    //   <p>Generated Token: {generatedToken.token}</p>
    // </div>

    <form>
      <div className="mb-6">
        <label for="email" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your email</label>
        <input type="email" id="email" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@flowbite.com" required />
      </div>
      <div className="mb-6">
        <label for="password" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your password</label>
        <input type="password" id="password" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required/>
      </div>
      <div className="flex items-start mb-6">
        <div className="flex items-center h-5">
          <input id="remember" type="checkbox" value="" className="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-blue-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:focus:ring-offset-gray-800" required/>
        </div>
        <label for="remember" className="ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Remember me</label>
      </div>
      <button type="submit" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Submit</button>
    </form>
  );
}

export default TokenGenerator;
